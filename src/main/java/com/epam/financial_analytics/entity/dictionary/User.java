package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class User extends Entity {
    private String login;
    private String password;
    private String eMail;
    private Role role;

    public User(){}

    public User(long id, String name, String login, String password, String eMail, Role role) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.eMail = eMail;
        this.role = role;
    }
    public User(String name, String login, String password, String eMail) {
        super(name);
        this.login = login;
        this.password = password;
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User " + super.toString() +
                ", login: " + login +
                ", password: " + password + ", e-mail: " + eMail + ", role: " + role;
    }
}
