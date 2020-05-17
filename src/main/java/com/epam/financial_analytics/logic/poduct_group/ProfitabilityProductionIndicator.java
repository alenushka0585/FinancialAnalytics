package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityProductionIndicator extends Indicator implements Fillable {
    private SalesSumProductionIndicator salesSumProductionIndicator;
    private ValueAddedTaxSumProductionIndicator valueAddedTaxSumProductionIndicator;
    private MarginSumProductionIndicator marginSumProductionIndicator;

    public ProfitabilityProductionIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumProductionIndicator = new SalesSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumProductionIndicator = new ValueAddedTaxSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumProductionIndicator = new MarginSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumProductionIndicator.fillAllIndicator();
        valueAddedTaxSumProductionIndicator.fillAllIndicator();
        marginSumProductionIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumProductionIndicator.getPresentPeriodIndicator(),
                salesSumProductionIndicator.getPresentPeriodIndicator(), valueAddedTaxSumProductionIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumProductionIndicator.getPastPeriodIndicator(),
                salesSumProductionIndicator.getPastPeriodIndicator(), valueAddedTaxSumProductionIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
