package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.logic.poduct_group.ValueAddedTaxSumGoodsIndicator;
import com.epam.financial_analytics.logic.poduct_group.ValueAddedTaxSumProductionIndicator;

import java.sql.Date;

public class ValueAddedTaxSumTotalIndicator extends Indicator implements Fillable {
    private ValueAddedTaxSumProductionIndicator valueAddedTaxSumProductionIndicator;
    private ValueAddedTaxSumGoodsIndicator valueAddedTaxSumGoodsIndicator;

    public ValueAddedTaxSumTotalIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumProductionIndicator = new ValueAddedTaxSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumGoodsIndicator = new ValueAddedTaxSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        valueAddedTaxSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        valueAddedTaxSumProductionIndicator.fillAllIndicator();
        valueAddedTaxSumGoodsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(fillTotalIndicator(valueAddedTaxSumProductionIndicator.getPresentPeriodIndicator(), valueAddedTaxSumGoodsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(valueAddedTaxSumProductionIndicator.getPastPeriodIndicator(), valueAddedTaxSumGoodsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long production, long goods){
        long expenseIndecator = production + goods;
        return expenseIndecator;
    }
}
