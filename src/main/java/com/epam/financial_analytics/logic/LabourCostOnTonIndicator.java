package com.epam.financial_analytics.logic;

import java.sql.Date;

public class LabourCostOnTonIndicator extends Indicator implements Fillable{
    private LabourCostIndicator labourCostIndicator;
    private SalesOfTonsIndicator salesOfTonsIndicator;

    public LabourCostOnTonIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostIndicator = new LabourCostIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfTonsIndicator = new SalesOfTonsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        labourCostIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfTonsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        labourCostIndicator.fillAllIndicator();
        salesOfTonsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(labourCostIndicator.getPresentPeriodIndicator(), salesOfTonsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(labourCostIndicator.getPastPeriodIndicator(), salesOfTonsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
