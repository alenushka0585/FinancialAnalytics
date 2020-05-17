package com.epam.financial_analytics.logic;

import java.sql.Date;

public class MarginOnSquareMetreIndicator extends Indicator implements Fillable{
    private MarginSumTotalIndicator marginSumTotalIndicator;
    private SalesOfSquareMetresIndicator salesOfSquareMetresIndicator;

    public MarginOnSquareMetreIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTotalIndicator = new MarginSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfSquareMetresIndicator = new SalesOfSquareMetresIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        marginSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfSquareMetresIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        marginSumTotalIndicator.fillAllIndicator();
        salesOfSquareMetresIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(marginSumTotalIndicator.getPresentPeriodIndicator(), salesOfSquareMetresIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(marginSumTotalIndicator.getPastPeriodIndicator(), salesOfSquareMetresIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public SalesOfSquareMetresIndicator getSalesOfSquareMetresIndicator() {
        return salesOfSquareMetresIndicator;
    }
}
