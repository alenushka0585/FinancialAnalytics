package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class ExpenseIndicator extends Indicator {
    private final ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();

    public ExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                            Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }


    public void fillAllIndicatorWithOrganizationUnitAndExpenseType(String organizationUnitName, String expenseType) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(expenseInfoDao,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(),organizationUnitName, expenseType));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(expenseInfoDao,
                getPastPeriodStartDate(), getPastPeriodFinishDate(),organizationUnitName, expenseType));
        fillIndicator();
    }


    public void fillAllIndicatorAndExpenseType(String expenseType) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(expenseInfoDao,
                getPresentPeriodStartDate(),getPresentPeriodFinishDate(), expenseType));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(expenseInfoDao,
                getPastPeriodStartDate(),getPastPeriodFinishDate(), expenseType));
        fillIndicator();
    }
}
