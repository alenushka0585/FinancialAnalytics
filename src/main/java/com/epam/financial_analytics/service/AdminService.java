package com.epam.financial_analytics.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.financial_analytics.service.ServiceConstants.*;

public class AdminService implements Service {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect(ADMINISTRATION_URL);
    }
}
