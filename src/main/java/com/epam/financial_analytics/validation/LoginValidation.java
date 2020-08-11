package com.epam.financial_analytics.validation;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;
import org.apache.log4j.Logger;

public class LoginValidation {
    private static final Logger LOGGER = Logger.getLogger(LoginValidation.class);

    public static boolean isLoginExits(String login, UserDaoImpl userDao){
        boolean isExist = false;
        User user = userDao.getByLogin(login);
        LOGGER.info("Login is " + user.getLogin());

        if (user.getLogin() != null && user.getLogin().equals(login)) {
            isExist = true;
        }
        return isExist;
    }
}
