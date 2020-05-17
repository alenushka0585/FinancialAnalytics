package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class CurrencyExchangeRateService implements Service{
    private CurrencyExchangeRateDaoImpl dao = new CurrencyExchangeRateDaoImpl();
    private CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        Currency currencyRUB = currencyDao.getByName(req.getParameter(RUB));
        Currency currencyUSD = currencyDao.getByName(req.getParameter(USD));
        Currency currencyKZT = currencyDao.getByName(req.getParameter(KZT));

        CurrencyExchangeRate currencyExchangeRateRUB = new CurrencyExchangeRate(date, currencyRUB, Double.parseDouble(req.getParameter(RATE_RUB)));
        CurrencyExchangeRate currencyExchangeRateUSD = new CurrencyExchangeRate(date, currencyUSD, Double.parseDouble(req.getParameter(RATE_USD)));
        CurrencyExchangeRate currencyExchangeRateKZT = new CurrencyExchangeRate(date, currencyKZT, Double.parseDouble(req.getParameter(RATE_KZT)));

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMINISTRATOR)){
            dao.create(currencyExchangeRateRUB);
            dao.create(currencyExchangeRateUSD);
            dao.create(currencyExchangeRateKZT);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(RUB, dao.getByCurrencyAndDate(currencyRUB.getName(),date,date).get(FIRST_INDEX));
            req.setAttribute(USD, dao.getByCurrencyAndDate(currencyUSD.getName(),date,date).get(FIRST_INDEX));
            req.setAttribute(KZT, dao.getByCurrencyAndDate(currencyKZT.getName(),date,date).get(FIRST_INDEX));

            requestDispatcher = req.getRequestDispatcher(CURRENCY_EXCHANGE_RATE_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
