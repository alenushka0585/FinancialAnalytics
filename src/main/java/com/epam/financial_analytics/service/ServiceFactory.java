package com.epam.financial_analytics.service;

import java.util.HashMap;
import java.util.Map;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();

    static {
        SERVICE_MAP.put(ANALYTICS_URL, new AnalyticsService());
        SERVICE_MAP.put(ADMIN_URL, new AdminService());
        SERVICE_MAP.put(LOGINPAGE_URL, new LoginService());
        SERVICE_MAP.put(LOGOUT_URL, new LogoutService());
        SERVICE_MAP.put(ERROR, new LoginService());
        SERVICE_MAP.put(BASIC_INDICATOR_URL, new BasicIndicatorService());
        SERVICE_MAP.put(METAL_PROCESSING_URL, new MetalProcessingService());
        SERVICE_MAP.put(EXPENSE_URL, new ExpenseService());
        SERVICE_MAP.put(PRODUCT_GROUP_URL, new ProductGroupService());
        SERVICE_MAP.put(CURRENCY_EXCHANGE_RATE_URL, new CurrencyExchangeRateService());
        SERVICE_MAP.put(CREATE_USER_URL, new CreateUserService());
        SERVICE_MAP.put(UPDATE_USER_EMAIL_URL, new UpdateUserEmailService());
        SERVICE_MAP.put(UPDATE_USER_PASSWORD_URL, new UpdateUserPasswordService());
        SERVICE_MAP.put(UPDATE_USER_NAME_URL, new UpdateUserNameService());
        SERVICE_MAP.put(UPDATE_USER_ROLE_URL, new UpdateUserRoleService());
    }

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }

    public Service getServiceFactory(String request){
        if (SERVICE_MAP.get(request) == null){
            return SERVICE_MAP.get(ERROR);
        }
        return SERVICE_MAP.get(request);
    }
}
