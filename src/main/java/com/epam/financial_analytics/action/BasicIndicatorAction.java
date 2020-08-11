package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.util.ActionUtil;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class BasicIndicatorAction implements Action {
    private static final Logger LOGGER = Logger.getLogger(BasicIndicatorAction.class);
    private ReportWithOrganizationDao dao;
    private OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    private RequestDispatcher requestDispatcher;
    private Map<String, Long> reportWithOrganizationMap = new HashMap<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.info("Execute method starts in BasicIndicatorAction");

        Date date = Date.valueOf(req.getParameter(DATE));
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        dao = ActionUtil.getDao(kindOfReport);

        Enumeration paramNames = req.getParameterNames();

        List<OrganizationUnit> organizationUnitList = organizationUnitDao.getAll();

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){

            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();

                for (OrganizationUnit organizationUnit: organizationUnitList) {
                    if (paramName.contains(organizationUnit.getName())) {
                        ReportWithOrganization reportWithOrganization = ActionUtil.fillReport
                                (kindOfReport, date, Long.parseLong(req.getParameter(paramName)), organizationUnit, currency);
                        reportWithOrganizationMap.put(organizationUnit.getName(), reportWithOrganization.getAmount());
                        dao.create(reportWithOrganization);
                    }
                }
            }

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(REPORT, reportWithOrganizationMap);

            if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)){
                requestDispatcher = req.getRequestDispatcher(REPORT_WITH_ORGANIZATION_UNIT_RESULT_URL + JSP);
            } else {
                requestDispatcher = req.getRequestDispatcher(REPORT_WITH_ORGANIZATION_UNIT_AND_CURRENCY_RESULT_URL + JSP);
            }
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
