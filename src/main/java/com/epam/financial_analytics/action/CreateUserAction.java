package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.RoleDaoImpl;
import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Role;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.util.ActionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class CreateUserAction implements Action {
    private UserDaoImpl dao = new UserDaoImpl();
    private RoleDaoImpl roleDao = new RoleDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        Role userRole = roleDao.getByName(req.getParameter(ROLE));

        User newUser = new User(req.getParameter(NAME),req.getParameter(LOGIN), ActionUtil.md5Apache(req.getParameter(PASSWORD)), req.getParameter(EMAIL), userRole);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            dao.create(newUser);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(NEW_USER, dao.getByName(newUser.getName()));

            requestDispatcher = req.getRequestDispatcher(USER_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
