package com.epam.financial_analytics.controller;

import com.epam.financial_analytics.service.Service;
import com.epam.financial_analytics.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinancialAnalyticsServlet extends HttpServlet {
    private static long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(FinancialAnalyticsServlet.class);
    private Service service;

    public FinancialAnalyticsServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAction(req, resp);
    }

    private void getAction(HttpServletRequest req, HttpServletResponse resp){
        String requestPathInfo = req.getPathInfo().toLowerCase();

        service = ServiceFactory.getInstance().getServiceFactory(requestPathInfo);

        try {
            service.execute(req, resp);
        } catch (IOException | ServletException e) {
            LOGGER.error("Exception in FinantialAnalyticsServlet", e);
        }
    }
}
