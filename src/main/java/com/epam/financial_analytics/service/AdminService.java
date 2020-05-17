package com.epam.financial_analytics.service;

import com.epam.financial_analytics.entity.dictionary.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class AdminService implements Service {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMINISTRATOR)){
            resp.sendRedirect(ADMINISTRATION_URL + JSP);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
