package com.epam.financial_analytics.controller;

import com.epam.financial_analytics.service.Service;
import com.epam.financial_analytics.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinantialAnalyticsServlet extends HttpServlet {
    private static long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(FinantialAnalyticsServlet.class);

    public FinantialAnalyticsServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getService(req, resp);
    }

    private void getService(HttpServletRequest req, HttpServletResponse resp){
        String requestPathInfo = req.getPathInfo().toLowerCase();
        Service service = ServiceFactory.getInstance().getService(requestPathInfo);

        try {
            service.execute(req, resp);
        } catch (Exception e) {
            LOGGER.error("Exception in FinantialAnalyticsServlet", e);
        }
    }
}
