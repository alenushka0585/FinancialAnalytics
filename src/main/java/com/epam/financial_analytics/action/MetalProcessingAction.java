package com.epam.financial_analytics.action;


import com.epam.financial_analytics.dao.impl.MetalProcessingDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class MetalProcessingAction implements Action {
    private final MetalProcessingDaoImpl dao = new MetalProcessingDaoImpl();
    private final OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        OrganizationUnit organizationUnitKaraganda = organizationUnitDao.getByName(KARAGANDA);
        OrganizationUnit organizationUnitAlmaty = organizationUnitDao.getByName(ALMATY);

        ReportWithOrganization karaganda = new ReportWithOrganization(date, Long.parseLong(req.getParameter(AMOUNT_KARAGANDA)), organizationUnitKaraganda);
        ReportWithOrganization almaty = new ReportWithOrganization(date, Long.parseLong(req.getParameter(AMOUNT_ALMATY)), organizationUnitAlmaty);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            dao.create(karaganda);
            dao.create(almaty);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(KARAGANDA, dao.getByDateAndOrganizationUnit(date, date, organizationUnitKaraganda.getName()).get(FIRST_INDEX));
            req.setAttribute(ALMATY, dao.getByDateAndOrganizationUnit(date, date, organizationUnitAlmaty.getName()).get(FIRST_INDEX));

            requestDispatcher = req.getRequestDispatcher(METAL_PROCESSING_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
