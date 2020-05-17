package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
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

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class BasicIndicatorService implements Service {
    private ReportWithOrganizationDao dao;
    private OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date date = Date.valueOf(req.getParameter(DATE));
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        dao = ServiceUtil.getDao(kindOfReport);

        OrganizationUnit organizationUnitKaraganda = organizationUnitDao.getByName(KARAGANDA);
        OrganizationUnit organizationUnitAlmaty = organizationUnitDao.getByName(ALMATY);
        OrganizationUnit organizationUnitAtyrau = organizationUnitDao.getByName(ATYRAU);
        OrganizationUnit organizationUnitAstana = organizationUnitDao.getByName(ASTANA);
        OrganizationUnit organizationUnitAktobe = organizationUnitDao.getByName(AKTOBE);
        OrganizationUnit organizationUnitOskemen = organizationUnitDao.getByName(OSKEMEN);
        OrganizationUnit organizationUnitShymkent = organizationUnitDao.getByName(SHYMKENT);

        ReportWithOrganization karaganda = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_KARAGANDA)), organizationUnitKaraganda, currency );
        ReportWithOrganization almaty = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_ALMATY)), organizationUnitAlmaty, currency);
        ReportWithOrganization atyrau = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_ATYRAU)), organizationUnitAtyrau, currency);
        ReportWithOrganization astana = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_ASTANA)), organizationUnitAstana, currency);
        ReportWithOrganization aktobe = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_AKTOBE)), organizationUnitAktobe, currency);
        ReportWithOrganization oskemen = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_OSKEMEN)), organizationUnitOskemen, currency);
        ReportWithOrganization shymkent = ServiceUtil.fillReport(kindOfReport, date, Long.parseLong(req.getParameter(AMOUNT_SHYMKENT)), organizationUnitShymkent, currency);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMINISTRATOR)){
            dao.create(karaganda);
            dao.create(almaty);
            dao.create(atyrau);
            dao.create(astana);
            dao.create(aktobe);
            dao.create(oskemen);
            dao.create(shymkent);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(KARAGANDA, dao.getByDateAndOrganizationUnit(date, date, organizationUnitKaraganda.getName()).get(FIRST_INDEX));
            req.setAttribute(ALMATY, dao.getByDateAndOrganizationUnit(date, date, organizationUnitAlmaty.getName()).get(FIRST_INDEX));
            req.setAttribute(ATYRAU, dao.getByDateAndOrganizationUnit(date, date, organizationUnitAtyrau.getName()).get(FIRST_INDEX));
            req.setAttribute(ASTANA, dao.getByDateAndOrganizationUnit(date, date, organizationUnitAstana.getName()).get(FIRST_INDEX));
            req.setAttribute(AKTOBE, dao.getByDateAndOrganizationUnit(date, date, organizationUnitAktobe.getName()).get(FIRST_INDEX));
            req.setAttribute(OSKEMEN, dao.getByDateAndOrganizationUnit(date, date, organizationUnitOskemen.getName()).get(FIRST_INDEX));
            req.setAttribute(SHYMKENT, dao.getByDateAndOrganizationUnit(date, date, organizationUnitShymkent.getName()).get(FIRST_INDEX));

            if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)){
                requestDispatcher = req.getRequestDispatcher(REPORT_WITH_ORGANIZATION_UNIT_RESULT_URL + JSP);
                requestDispatcher.forward(req, resp);
            } else {
                requestDispatcher = req.getRequestDispatcher(REPORT_WITH_ORGANIZATION_UNIT_AND_CURRENCY_RESULT_URL + JSP);
                requestDispatcher.forward(req, resp);
            }
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
