package com.epam.financial_analytics.logic;

import java.sql.Date;

public class MarginOnTonsIndicator extends Indicator implements Fillable{
    private MarginSumTotalIndicator marginSumTotalIndicator;
    private SalesOfTonsIndicator salesOfTonsIndicator;

    public MarginOnTonsIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTotalIndicator = new MarginSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfTonsIndicator = new SalesOfTonsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        marginSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfTonsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        marginSumTotalIndicator.fillAllIndicator();
        salesOfTonsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(marginSumTotalIndicator.getPresentPeriodIndicator(), salesOfTonsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(marginSumTotalIndicator.getPastPeriodIndicator(), salesOfTonsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public SalesOfTonsIndicator getSalesOfTonsIndicator() {
        return salesOfTonsIndicator;
    }
}
