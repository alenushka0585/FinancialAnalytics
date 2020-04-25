package com.epam.financial_analytics.service;

import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.logic.BasicIndicator;
import com.epam.financial_analytics.logic.ExpenseIndicator;
import com.epam.financial_analytics.logic.KazakhstanIndicator;
import com.epam.financial_analytics.logic.ProductGroupIndicator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.service.ServiceConstants.*;

public class AnalyticsService implements Service {
    private RequestDispatcher requestDispatcher;

    private BasicIndicator basicIndicator;
    private KazakhstanIndicator kazakhstanIndicator;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date presentPeriodStartDate = Date.valueOf(req.getParameter("presentPeriodStartDate"));
        Date presentPeriodFinishDate = Date.valueOf(req.getParameter("presentPeriodFinishDate"));
        Date pastPeriodStartDate = Date.valueOf(req.getParameter("pastPeriodStartDate"));
        Date pastPeriodFinishDate = Date.valueOf(req.getParameter("pastPeriodFinishDate"));
        String currency = req.getParameter("currency");
        String organizationUnit = req.getParameter("organizationUnit");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String role = user.getRole().getName();

        if ((organizationUnit.equals(KAZAKHSTAN) && role.equals(ADMINISTRATOR)) || (organizationUnit.equals(KAZAKHSTAN) && role.equals(DIRECTOR))){
            kazakhstanIndicator = new KazakhstanIndicator(presentPeriodStartDate,presentPeriodFinishDate,
                    pastPeriodStartDate,pastPeriodFinishDate,currency);
            kazakhstanIndicator.setAll();
            req.setAttribute("kazakhstanIndicator", kazakhstanIndicator);
            requestDispatcher = req.getRequestDispatcher(RESULT_COUNTRY_URL);
            requestDispatcher.forward(req, resp);

        } else if (role.contains(organizationUnit) || role.equals(ADMINISTRATOR) || role.equals(DIRECTOR)){
            basicIndicator = new BasicIndicator(presentPeriodStartDate,presentPeriodFinishDate,
                    pastPeriodStartDate,pastPeriodFinishDate,currency);
            basicIndicator.setAllWithOrganizationUnit(organizationUnit);

            System.out.println(basicIndicator.getChangingOfRevenueInPercents());

            req.setAttribute("basicIndicator", basicIndicator);
            requestDispatcher = req.getRequestDispatcher(RESULT_ORG_UN_URL);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL);
        }
    }
}
