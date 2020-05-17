package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilitySEOIndicator extends Indicator implements Fillable {
    private SalesSumSEOIndicator salesSumSEOIndicator;
    private ValueAddedTaxSumSEOIndicator valueAddedTaxSumSEOIndicator;
    private MarginSumSEOIndicator marginSumSEOIndicator;

    public ProfitabilitySEOIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumSEOIndicator = new SalesSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumSEOIndicator = new ValueAddedTaxSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumSEOIndicator = new MarginSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumSEOIndicator.fillAllIndicator();
        valueAddedTaxSumSEOIndicator.fillAllIndicator();
        marginSumSEOIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumSEOIndicator.getPresentPeriodIndicator(),
                salesSumSEOIndicator.getPresentPeriodIndicator(), valueAddedTaxSumSEOIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumSEOIndicator.getPastPeriodIndicator(),
                salesSumSEOIndicator.getPastPeriodIndicator(), valueAddedTaxSumSEOIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
