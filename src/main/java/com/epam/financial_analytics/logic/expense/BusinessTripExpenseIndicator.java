package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.BUSINESS_TRIP;

public class BusinessTripExpenseIndicator extends ExpenseIndicator implements Fillable {
    public BusinessTripExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, BUSINESS_TRIP));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, BUSINESS_TRIP));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(), BUSINESS_TRIP));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(), BUSINESS_TRIP));
        fillIndicator();
    }
}
