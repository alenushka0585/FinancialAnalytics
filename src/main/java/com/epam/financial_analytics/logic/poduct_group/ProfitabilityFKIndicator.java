package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityFKIndicator extends Indicator implements Fillable {
    private SalesSumFKIndicator salesSumFKIndicator;
    private ValueAddedTaxSumFKIndicator valueAddedTaxSumFKIndicator;
    private MarginSumFKIndicator marginSumFKIndicator;

    public ProfitabilityFKIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumFKIndicator = new SalesSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumFKIndicator = new ValueAddedTaxSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumFKIndicator = new MarginSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumFKIndicator.fillAllIndicator();
        valueAddedTaxSumFKIndicator.fillAllIndicator();
        marginSumFKIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumFKIndicator.getPresentPeriodIndicator(),
                salesSumFKIndicator.getPresentPeriodIndicator(), valueAddedTaxSumFKIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumFKIndicator.getPastPeriodIndicator(),
                salesSumFKIndicator.getPastPeriodIndicator(), valueAddedTaxSumFKIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
