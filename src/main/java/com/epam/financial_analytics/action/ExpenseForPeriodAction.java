package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseTypeDaoImpl;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.util.ActionUtil;
import com.epam.financial_analytics.util.IndicatorUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ExpenseForPeriodAction implements Action {
    private RequestDispatcher requestDispatcher;
    private final ExpenseInfoDaoImpl dao = new ExpenseInfoDaoImpl();
    private final ExpenseTypeDaoImpl expenseTypeDao = new ExpenseTypeDaoImpl();
    private final CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();
    private List<CurrencyExchangeRate> currencyExchangeRateList;
    private Map<Integer, Long> reportMap = new HashMap<>();
    private final Map<String, Map<Integer,Long>> expenseMap = new HashMap<>();
    private List<Report> reportList;
    private List<ExpenseType> expenseTypeList;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date startDate = Date.valueOf(req.getParameter(START_DATE));
        Date finishDate = Date.valueOf(req.getParameter(FINISH_DATE));
        String currency = req.getParameter(CURRENCY);
        String organizationUnit = req.getParameter(ORGANIZATION_UNIT);
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        currencyExchangeRateList = currencyExchangeRateDao.getByCurrencyAndDate(currency, startDate, finishDate);
        expenseTypeList = expenseTypeDao.getAll();

        req.setAttribute(KIND_OF_REPORT, kindOfReport);
        req.setAttribute(START_DATE, startDate);
        req.setAttribute(FINISH_DATE, finishDate);
        req.setAttribute(ORGANIZATION_UNIT, organizationUnit);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (organizationUnit.equals(KAZAKHSTAN) && (role.equals(ADMIN) || role.equals(DIRECTOR))
                || role.contains(organizationUnit) || role.equals(ADMIN) || role.equals(DIRECTOR)){
            for (ExpenseType expenseType : expenseTypeList) {
                if (organizationUnit.equals(KAZAKHSTAN)){
                    reportList = IndicatorUtil.fillIndicatorSumListAndExpenseType(dao, startDate, finishDate, expenseType.getName());
                } else {
                    reportList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType
                            (dao, startDate, finishDate, organizationUnit, expenseType.getName());
                }
                reportMap = ActionUtil.getMapWithCurrency(reportList, currencyExchangeRateList, currency);
                expenseMap.put(expenseType.getName(), reportMap);
            }

            expenseMap.put(TOTAl, ActionUtil.getTotalMapForExpenses(expenseMap, expenseTypeList));

            req.setAttribute(REPORT, expenseMap);

            requestDispatcher = req.getRequestDispatcher(EXPENSE_FOR_PERIOD_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
