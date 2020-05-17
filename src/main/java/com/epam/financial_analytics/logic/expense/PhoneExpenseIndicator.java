package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;
import com.epam.financial_analytics.logic.expense.ExpenseIndicator;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.PHONE;

public class PhoneExpenseIndicator extends ExpenseIndicator implements Fillable {
    public PhoneExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, PHONE));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, PHONE));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(), PHONE));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(), PHONE));
        fillIndicator();
    }
}
