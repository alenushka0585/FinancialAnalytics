package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseTypeDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ExpenseAction implements Action {
    private final ExpenseTypeDaoImpl expenseType = new ExpenseTypeDaoImpl();
    private final ExpenseInfoDaoImpl dao =  new ExpenseInfoDaoImpl();
    private final OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private final CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;
    private final Map<String, Long> expenseInfoMap = new HashMap<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        OrganizationUnit organizationUnit = organizationUnitDao.getByName(req.getParameter(ORGANIZATION_UNIT));

        Enumeration paramNames = req.getParameterNames();

        List<ExpenseType> expenseTypeList = expenseType.getAll();

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            while(paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();

                for (ExpenseType expenseType : expenseTypeList) {
                    if (paramName.contains(expenseType.getName())) {
                        ExpenseInfo expenseInfo = new ExpenseInfo(date, Long.parseLong(req.getParameter(paramName)), organizationUnit, currency, expenseType);
                        expenseInfoMap.put(expenseType.getName(), expenseInfo.getAmount());
                        dao.create(expenseInfo);
                    }
                }
            }

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(ORGANIZATION_UNIT, organizationUnit);
            req.setAttribute(REPORT, expenseInfoMap);

            requestDispatcher = req.getRequestDispatcher(EXPENSE_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
