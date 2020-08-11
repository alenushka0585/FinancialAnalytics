package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.dictionary.User;

public interface UserDao<M extends User> extends BaseDao<M> {
    M getByLoginAndPassword(String login, String password);
    M getByLogin(String login);
    M getByEmail(String email);
}
