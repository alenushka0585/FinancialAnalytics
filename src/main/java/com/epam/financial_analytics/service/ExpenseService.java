package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseTypeDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.service.ServiceConstant.*;
import static com.epam.financial_analytics.service.ServiceConstant.JSP;

public class ExpenseService implements Service{
    private ExpenseTypeDaoImpl expenseType = new ExpenseTypeDaoImpl();
    private ExpenseInfoDaoImpl dao =  new ExpenseInfoDaoImpl();
    private OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        OrganizationUnit organizationUnit = organizationUnitDao.getByName(req.getParameter(ORGANIZATION_UNIT));

        ExpenseType salaryType = expenseType.getByName(req.getParameter(SALARY));
        ExpenseType factoryType = expenseType.getByName(req.getParameter(FACTORY));
        ExpenseType transportType = expenseType.getByName(req.getParameter(TRANSPORT));
        ExpenseType packageType = expenseType.getByName(req.getParameter(PACKAGE));
        ExpenseType rentType = expenseType.getByName(req.getParameter(RENT));
        ExpenseType otherType = expenseType.getByName(req.getParameter(OTHER));
        ExpenseType phoneType = expenseType.getByName(req.getParameter(PHONE));
        ExpenseType businessTripType = expenseType.getByName(req.getParameter(BUSINESS_TRIP));
        ExpenseType advertisementType = expenseType.getByName(req.getParameter(ADVERTISEMENT));
        ExpenseType ecquiringType = expenseType.getByName(req.getParameter(ECQUIRING));

        ExpenseInfo salaryExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_SALARY)), organizationUnit,currency,salaryType);
        ExpenseInfo factoryExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_FACTORY)), organizationUnit,currency,factoryType);
        ExpenseInfo transportExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_TRANSPORT)), organizationUnit,currency,transportType);
        ExpenseInfo packageExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_PACKAGE)), organizationUnit,currency,packageType);
        ExpenseInfo rentExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_RENT)), organizationUnit,currency,rentType);
        ExpenseInfo otherExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_OTHER)), organizationUnit,currency,otherType);
        ExpenseInfo phoneExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_PHONE)), organizationUnit,currency,phoneType);
        ExpenseInfo businessTripExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_BUSINESS_TRIP)), organizationUnit,currency,businessTripType);
        ExpenseInfo advertisementExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_ADVERTISEMENT)), organizationUnit,currency,advertisementType);
        ExpenseInfo ecquiringExpense = new ExpenseInfo(date, Long.parseLong(req.getParameter(AMOUNT_ECQUIRING)), organizationUnit,currency,ecquiringType);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMINISTRATOR)){
            dao.create(salaryExpense);
            dao.create(factoryExpense);
            dao.create(transportExpense);
            dao.create(packageExpense);
            dao.create(rentExpense);
            dao.create(otherExpense);
            dao.create(phoneExpense);
            dao.create(businessTripExpense);
            dao.create(advertisementExpense);
            dao.create(ecquiringExpense);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(ORGANIZATION_UNIT, organizationUnit);
            req.setAttribute(SALARY, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), salaryType.getName()).get(FIRST_INDEX));
            req.setAttribute(FACTORY, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), factoryType.getName()).get(FIRST_INDEX));
            req.setAttribute(TRANSPORT, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), transportType.getName()).get(FIRST_INDEX));
            req.setAttribute(PACKAGE, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), packageType.getName()).get(FIRST_INDEX));
            req.setAttribute(RENT, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), rentType.getName()).get(FIRST_INDEX));
            req.setAttribute(OTHER, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), otherType.getName()).get(FIRST_INDEX));
            req.setAttribute(PHONE, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), phoneType.getName()).get(FIRST_INDEX));
            req.setAttribute(BUSINESS_TRIP, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), businessTripType.getName()).get(FIRST_INDEX));
            req.setAttribute(ADVERTISEMENT, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), advertisementType.getName()).get(FIRST_INDEX));
            req.setAttribute(ECQUIRING, dao.getByDateAndOrganizationUnitAndExpense(date, date, organizationUnit.getName(), ecquiringType.getName()).get(FIRST_INDEX));

            requestDispatcher = req.getRequestDispatcher(EXPENSE_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
