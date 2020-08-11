package com.epam.financial_analytics.validation;

import com.epam.financial_analytics.dao.impl.UserDaoImpl;
import com.epam.financial_analytics.entity.dictionary.User;
import org.apache.log4j.Logger;

public class EmailValidation {
    private static final Logger LOGGER = Logger.getLogger(EmailValidation.class);

    public static boolean isEmailExits(String email, UserDaoImpl userDao){
        boolean isExist = false;
        User user = userDao.getByEmail(email);
        LOGGER.info("The email is " + user.getEMail());

        if (user.getEMail() != null && user.getEMail().equals(email)) {
            isExist = true;
        }
        return isExist;
    }
}
