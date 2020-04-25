package com.epam.financial_analytics.service;

import static com.epam.financial_analytics.service.ServiceConstants.*;

public class ServiceFactory {
    private volatile static ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public Service getService (String request){
        switch (request){
            case ANALYTICS_URL: return new AnalyticsService();
            case ADMIN_URL: return new AdminService();
            case LOGINPAGE_URL: return new LoginService();
            default: return new LoginService();
        }
    }
}
