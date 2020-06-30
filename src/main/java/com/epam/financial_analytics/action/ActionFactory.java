package com.epam.financial_analytics.action;

import java.util.HashMap;
import java.util.Map;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ActionFactory {
    private static final ActionFactory INSTANCE = new ActionFactory();
    private static final Map<String, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(ANALYTICS_URL, new AnalyticsAction());
        ACTION_MAP.put(LOGIN_PAGE_URL, new LoginAction());
        ACTION_MAP.put(LOGOUT_URL, new LogoutAction());
        ACTION_MAP.put(ERROR, new LoginAction());
        ACTION_MAP.put(BASIC_INDICATOR_URL, new BasicIndicatorAction());
        ACTION_MAP.put(METAL_PROCESSING_URL, new MetalProcessingAction());
        ACTION_MAP.put(EXPENSE_URL, new ExpenseAction());
        ACTION_MAP.put(PRODUCT_GROUP_URL, new ProductGroupAction());
        ACTION_MAP.put(CURRENCY_EXCHANGE_RATE_URL, new CurrencyExchangeRateAction());
        ACTION_MAP.put(CREATE_USER_URL, new CreateUserAction());
        ACTION_MAP.put(UPDATE_USER_EMAIL_URL, new UpdateUserEmailAction());
        ACTION_MAP.put(UPDATE_USER_PASSWORD_URL, new UpdateUserPasswordAction());
        ACTION_MAP.put(UPDATE_USER_NAME_URL, new UpdateUserNameAction());
        ACTION_MAP.put(UPDATE_USER_ROLE_URL, new UpdateUserRoleAction());
        ACTION_MAP.put(KEY_INDICATORS_FOR_PERIOD_URL, new KeyIndicatorsForPeriodAction());
        ACTION_MAP.put(PRODUCT_GROUP_FOR_PERIOD_URL, new ProductGroupForPeriodAction());
        ACTION_MAP.put(EXPENSE_FOR_PERIOD_URL, new ExpenseForPeriodAction());
    }

    private ActionFactory(){}

    public static ActionFactory getInstance(){
        return INSTANCE;
    }

    public Action getActionFactory(String request){
        if (ACTION_MAP.get(request) == null){
            return ACTION_MAP.get(ERROR);
        }
        return ACTION_MAP.get(request);
    }
}
