package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityOtherIndicator extends Indicator implements Fillable {
    private SalesSumOtherIndicator salesSumOtherIndicator;
    private ValueAddedTaxSumOtherIndicator valueAddedTaxSumOtherIndicator;
    private MarginSumOtherIndicator marginSumOtherIndicator;

    public ProfitabilityOtherIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumOtherIndicator = new SalesSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumOtherIndicator = new ValueAddedTaxSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumOtherIndicator = new MarginSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumOtherIndicator.fillAllIndicator();
        valueAddedTaxSumOtherIndicator.fillAllIndicator();
        marginSumOtherIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumOtherIndicator.getPresentPeriodIndicator(),
                salesSumOtherIndicator.getPresentPeriodIndicator(), valueAddedTaxSumOtherIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumOtherIndicator.getPastPeriodIndicator(),
                salesSumOtherIndicator.getPastPeriodIndicator(), valueAddedTaxSumOtherIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
