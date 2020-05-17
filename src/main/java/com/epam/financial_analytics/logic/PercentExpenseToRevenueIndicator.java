package com.epam.financial_analytics.logic;

import java.sql.Date;

public class PercentExpenseToRevenueIndicator extends Indicator implements Fillable {
    RevenueIndicator revenueIndicator;
    TotalExpenseIndicator totalExpenseIndicator;

    public PercentExpenseToRevenueIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        revenueIndicator = new RevenueIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalExpenseIndicator = new TotalExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        revenueIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        totalExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        revenueIndicator.fillAllIndicator();
        totalExpenseIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countPercentOneToAnother(totalExpenseIndicator.getPresentPeriodIndicator(),revenueIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countPercentOneToAnother(totalExpenseIndicator.getPastPeriodIndicator(),revenueIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public TotalExpenseIndicator getTotalExpenseIndicator() {
        return totalExpenseIndicator;
    }

    public RevenueIndicator getRevenueIndicator() {
        return revenueIndicator;
    }
}

