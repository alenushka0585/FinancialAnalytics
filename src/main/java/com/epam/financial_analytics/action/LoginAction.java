package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.util.ActionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class LoginAction implements Action {
    private RequestDispatcher requestDispatcher;
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        String userName = req.getParameter(LOGIN);
        String userPassword = ActionUtil.md5Apache(req.getParameter(PASSWORD));
        User user = userDao.getByLoginAndPassword(userName, userPassword);

        if (user.getLogin() != null){
            session.setAttribute(USER, user);
            resp.sendRedirect(MAINPAGE_URL + JSP);
        } else {
            requestDispatcher = req.getRequestDispatcher(LOGIN_ERROR_URL + JSP);
            requestDispatcher.forward(req, resp);
        }
    }
}
