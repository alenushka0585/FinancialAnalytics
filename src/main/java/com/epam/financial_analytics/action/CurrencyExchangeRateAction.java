package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class CurrencyExchangeRateAction implements Action {
    private final CurrencyExchangeRateDaoImpl dao = new CurrencyExchangeRateDaoImpl();
    private final CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;
    private final Map<String, Double> currencyRateMap = new HashMap<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        Enumeration paramNames = req.getParameterNames();

        List<Currency> currencyList = currencyDao.getAll();

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            while(paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();

                for (Currency currency: currencyList) {
                    if (paramName.contains(currency.getName())) {
                        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate(date, currency, Double.parseDouble(req.getParameter(paramName)));
                        currencyRateMap.put(currency.getName(), currencyExchangeRate.getCurrencyExchangeRate());
                        dao.create(currencyExchangeRate);
                    }
                }
            }

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(REPORT, currencyRateMap);

            requestDispatcher = req.getRequestDispatcher(CURRENCY_EXCHANGE_RATE_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
