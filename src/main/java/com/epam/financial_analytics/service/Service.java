package com.epam.financial_analytics.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Service {
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
