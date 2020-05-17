package com.epam.financial_analytics.logic;

import java.sql.Date;

public class MarginOnEmployeeIndicator extends Indicator implements Fillable{
    private MarginSumTotalIndicator marginSumTotalIndicator;
    private NumberOfStuffIndicator numberOfStuffIndicator;

    public MarginOnEmployeeIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTotalIndicator = new MarginSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        numberOfStuffIndicator = new NumberOfStuffIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        marginSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        numberOfStuffIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        marginSumTotalIndicator.fillAllIndicator();
        numberOfStuffIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(marginSumTotalIndicator.getPresentPeriodIndicator(),
                numberOfStuffIndicator.getPresentPeriodIndicator(),getAmountOfMonths()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(marginSumTotalIndicator.getPastPeriodIndicator(),
                numberOfStuffIndicator.getPastPeriodIndicator(), getAmountOfMonths()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
