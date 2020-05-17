package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.*;

import java.sql.Date;

public class ProfitabilityOVPIndicator extends Indicator implements Fillable {
    private SalesSumOVPIndicator sumOVPIndicator;
    private ValueAddedTaxSumOVPIndicator valueAddedTaxSumOVPIndicator;
    private MarginSumOVPIndicator marginSumOVPIndicator;

    public ProfitabilityOVPIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        sumOVPIndicator = new SalesSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumOVPIndicator = new ValueAddedTaxSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumOVPIndicator = new MarginSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        sumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        sumOVPIndicator.fillAllIndicator();
        valueAddedTaxSumOVPIndicator.fillAllIndicator();
        marginSumOVPIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumOVPIndicator.getPresentPeriodIndicator(),
                sumOVPIndicator.getPresentPeriodIndicator(), valueAddedTaxSumOVPIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumOVPIndicator.getPastPeriodIndicator(),
                sumOVPIndicator.getPastPeriodIndicator(), valueAddedTaxSumOVPIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
