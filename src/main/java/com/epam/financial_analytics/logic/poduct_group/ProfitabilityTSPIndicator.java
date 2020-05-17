package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityTSPIndicator extends Indicator implements Fillable {
    private SalesSumTSPIndicator sumTSPIndicator;
    private ValueAddedTaxSumTSPIndicator valueAddedTaxSumTSPIndicator;
    private MarginSumTSPIndicator marginSumTSPIndicator;

    public ProfitabilityTSPIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        sumTSPIndicator = new SalesSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumTSPIndicator = new ValueAddedTaxSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTSPIndicator = new MarginSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        sumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        sumTSPIndicator.fillAllIndicator();
        valueAddedTaxSumTSPIndicator.fillAllIndicator();
        marginSumTSPIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumTSPIndicator.getPresentPeriodIndicator(),
                sumTSPIndicator.getPresentPeriodIndicator(), valueAddedTaxSumTSPIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumTSPIndicator.getPastPeriodIndicator(),
                sumTSPIndicator.getPastPeriodIndicator(), valueAddedTaxSumTSPIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
