package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.service.ServiceConstants.*;

public class LoginService implements Service {
    private RequestDispatcher requestDispatcher;
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        String userName = req.getParameter("login");
        String userPassword = req.getParameter("password");
        User user = userDao.getByLoginAndPassword(userName, userPassword);

        if (user.getLogin() != null){
            session.setAttribute("user", user);
            resp.sendRedirect(MAINPAGE_URL);
        } else {
            requestDispatcher = req.getRequestDispatcher(LOGIN_ERROR_URL);
            requestDispatcher.forward(req, resp);
        }
    }
}
