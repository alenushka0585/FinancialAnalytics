package com.epam.financial_analytics.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class LogoutAction implements Action {
    private RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session != null){
            session.invalidate();
            requestDispatcher = req.getRequestDispatcher(INDEX_URL + JSP);
            requestDispatcher.forward(req, resp);
        }
    }
}
