package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityVSIndicator extends Indicator implements Fillable {
    private SalesSumVSIndicator salesSumVSIndicator;
    private ValueAddedTaxSumVSIndicator valueAddedTaxSumVSIndicator;
    private MarginSumVSIndicator marginSumVSIndicator;

    public ProfitabilityVSIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumVSIndicator = new SalesSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumVSIndicator = new ValueAddedTaxSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumVSIndicator = new MarginSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumVSIndicator.fillAllIndicator();
        valueAddedTaxSumVSIndicator.fillAllIndicator();
        marginSumVSIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumVSIndicator.getPresentPeriodIndicator(),
                salesSumVSIndicator.getPresentPeriodIndicator(), valueAddedTaxSumVSIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumVSIndicator.getPastPeriodIndicator(),
                salesSumVSIndicator.getPastPeriodIndicator(), valueAddedTaxSumVSIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
