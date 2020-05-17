package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class LogoutService implements Service {
    private RequestDispatcher requestDispatcher;
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session != null){
            System.out.println("in if");
            session.invalidate();
            requestDispatcher = req.getRequestDispatcher(INDEX_URL + JSP);
            requestDispatcher.forward(req, resp);
        }
    }
}
