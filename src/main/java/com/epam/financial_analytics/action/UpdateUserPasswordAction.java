package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.util.ActionUtil;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class UpdateUserPasswordAction implements Action {
    private static final Logger LOGGER = Logger.getLogger(UpdateUserPasswordAction.class);
    private final UserDaoImpl dao = new UserDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.info("Execute method starts in UpdateUserPasswordAction");
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        String login = req.getParameter(LOGIN);
        String newParameter = ActionUtil.md5Apache(req.getParameter(PASSWORD));

        User newUser = dao.getByLogin(login);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            newUser.setPassword(newParameter);

            dao.update(newUser);
            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(NEW_USER, dao.getByLogin(newUser.getLogin()));

            requestDispatcher = req.getRequestDispatcher(USER_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
