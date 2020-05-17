package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilitySPPSIndicator extends Indicator implements Fillable {
    private SalesSumSPPSIndicator salesSumSPPSIndicator;
    private ValueAddedTaxSumSPPSIndicator valueAddedTaxSumSPPSIndicator;
    private MarginSumSPPSIndicator marginSumSPPSIndicator;

    public ProfitabilitySPPSIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumSPPSIndicator = new SalesSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumSPPSIndicator = new ValueAddedTaxSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumSPPSIndicator = new MarginSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumSPPSIndicator.fillAllIndicator();
        valueAddedTaxSumSPPSIndicator.fillAllIndicator();
        marginSumSPPSIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumSPPSIndicator.getPresentPeriodIndicator(),
                salesSumSPPSIndicator.getPresentPeriodIndicator(), valueAddedTaxSumSPPSIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumSPPSIndicator.getPastPeriodIndicator(),
                salesSumSPPSIndicator.getPastPeriodIndicator(), valueAddedTaxSumSPPSIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
