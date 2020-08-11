package com.epam.financial_analytics.action;

import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.logic.AllIndicator;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class AnalyticsAction implements Action {
    private RequestDispatcher requestDispatcher;
    private AllIndicator allIndicator;
    private static final Logger LOGGER = Logger.getLogger(AnalyticsAction.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.info("Execute method starts in AnalyticsAction");

        Date presentPeriodStartDate = Date.valueOf(req.getParameter(PRESENT_PERIOD_START_DATE));
        Date presentPeriodFinishDate = Date.valueOf(req.getParameter(PRESENT_PERIOD_FINISH_DATE));
        Date pastPeriodStartDate = Date.valueOf(req.getParameter(PAST_PERIOD_START_DATE));
        Date pastPeriodFinishDate = Date.valueOf(req.getParameter(PAST_PERIOD_FINISH_DATE));
        String currency = req.getParameter(CURRENCY);
        String organizationUnit = req.getParameter(ORGANIZATION_UNIT);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (organizationUnit.equals(KAZAKHSTAN) && (role.equals(ADMIN) || role.equals(DIRECTOR))){
            allIndicator = new AllIndicator(presentPeriodStartDate,presentPeriodFinishDate,pastPeriodStartDate, pastPeriodFinishDate, currency);
            allIndicator.fillAllIndicator();
            req.setAttribute(ALL_INDICATOR, allIndicator);
            requestDispatcher = req.getRequestDispatcher(ANALYTICS_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else if (role.contains(organizationUnit) || role.equals(ADMIN) || role.equals(DIRECTOR)){
            allIndicator = new AllIndicator(presentPeriodStartDate,presentPeriodFinishDate,pastPeriodStartDate, pastPeriodFinishDate, currency);
            allIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnit);

            req.setAttribute(ALL_INDICATOR, allIndicator);
            requestDispatcher = req.getRequestDispatcher(ANALYTICS_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
