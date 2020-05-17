package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityENKIndicator extends Indicator implements Fillable {
    private SalesSumENKIndicator salesSumENKIndicator;
    private ValueAddedTaxSumENKIndicator valueAddedTaxSumENKIndicator;
    private MarginSumENKIndicator marginSumENKIndicator;

    public ProfitabilityENKIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumENKIndicator = new SalesSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumENKIndicator = new ValueAddedTaxSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumENKIndicator = new MarginSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumENKIndicator.fillAllIndicator();
        valueAddedTaxSumENKIndicator.fillAllIndicator();
        marginSumENKIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumENKIndicator.getPresentPeriodIndicator(),
                salesSumENKIndicator.getPresentPeriodIndicator(), valueAddedTaxSumENKIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumENKIndicator.getPastPeriodIndicator(),
                salesSumENKIndicator.getPastPeriodIndicator(), valueAddedTaxSumENKIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
