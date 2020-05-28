package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
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

public class KeyIndicatorsForPeriodAction implements Action {
    private RequestDispatcher requestDispatcher;
    private ReportWithOrganizationDao dao;
    private OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();
    private List<CurrencyExchangeRate> currencyExchangeRateList;
    private Map<Integer, Long> reportMap = new HashMap<>();
    private Map<String, Map<Integer,Long>> totalReportMap = new HashMap<>();
    private List<Report> reportList;
    private List<OrganizationUnit> organizationUnitList;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date startDate = Date.valueOf(req.getParameter(START_DATE));
        Date finishDate = Date.valueOf(req.getParameter(FINISH_DATE));
        String currency = req.getParameter(CURRENCY);
        String organizationUnit = req.getParameter(ORGANIZATION_UNIT);
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        dao = ActionUtil.getDao(kindOfReport);

        currencyExchangeRateList = currencyExchangeRateDao.getByCurrencyAndDate(currency, startDate, finishDate);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (organizationUnit.equals(KAZAKHSTAN) && (role.equals(ADMIN) || role.equals(DIRECTOR))){
            organizationUnitList = organizationUnitDao.getAll();

            for (OrganizationUnit orgUnit : organizationUnitList){
                reportList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(dao, startDate, finishDate, orgUnit.getName());

                if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)) {
                    reportMap = ActionUtil.getMap(reportList);
                } else {
                    reportMap = ActionUtil.getMapWithCurrency(reportList, currencyExchangeRateList, currency);
                }
                totalReportMap.put(orgUnit.getName(), reportMap);
            }

            totalReportMap.put(TOTAl, ActionUtil.getTotalMap(totalReportMap, organizationUnitList));

            req.setAttribute(REPORT, totalReportMap);
            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(START_DATE, startDate);
            req.setAttribute(FINISH_DATE, finishDate);
            requestDispatcher = req.getRequestDispatcher(KEY_INDICATORS_FOR_PERIOD_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else if (role.contains(organizationUnit) || role.equals(ADMIN) || role.equals(DIRECTOR)){
            reportList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(dao, startDate, finishDate, organizationUnit);

            if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)) {
                reportMap = ActionUtil.getMap(reportList);
            } else {
                reportMap = ActionUtil.getMapWithCurrency(reportList, currencyExchangeRateList, currency);
            }

            req.setAttribute(REPORT, reportMap);
            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(START_DATE, startDate);
            req.setAttribute(FINISH_DATE, finishDate);
            requestDispatcher = req.getRequestDispatcher(KEY_INDICATORS_FOR_PERIOD_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
