package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityEBKIndicator extends Indicator implements Fillable {
    private SalesSumEBKIndicator salesSumEBKIndicator;
    private ValueAddedTaxSumEBKIndicator valueAddedTaxSumEBKIndicator;
    private MarginSumEBKIndicator marginSumEBKIndicator;

    public ProfitabilityEBKIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumEBKIndicator = new SalesSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumEBKIndicator = new ValueAddedTaxSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumEBKIndicator = new MarginSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumEBKIndicator.fillAllIndicator();
        valueAddedTaxSumEBKIndicator.fillAllIndicator();
        marginSumEBKIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumEBKIndicator.getPresentPeriodIndicator(),
                salesSumEBKIndicator.getPresentPeriodIndicator(), valueAddedTaxSumEBKIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumEBKIndicator.getPastPeriodIndicator(),
                salesSumEBKIndicator.getPastPeriodIndicator(), valueAddedTaxSumEBKIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
