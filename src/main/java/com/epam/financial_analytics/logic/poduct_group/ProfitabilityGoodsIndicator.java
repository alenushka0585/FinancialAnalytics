package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityGoodsIndicator extends Indicator implements Fillable {
    private SalesSumGoodsIndicator salesSumGoodsIndicator;
    private ValueAddedTaxSumGoodsIndicator valueAddedTaxSumGoodsIndicator;
    private MarginSumGoodsIndicator marginSumGoodsIndicator;

    public ProfitabilityGoodsIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumGoodsIndicator = new SalesSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumGoodsIndicator = new ValueAddedTaxSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumGoodsIndicator = new MarginSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumGoodsIndicator.fillAllIndicator();
        valueAddedTaxSumGoodsIndicator.fillAllIndicator();
        marginSumGoodsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumGoodsIndicator.getPresentPeriodIndicator(),
                salesSumGoodsIndicator.getPresentPeriodIndicator(), valueAddedTaxSumGoodsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumGoodsIndicator.getPastPeriodIndicator(),
                salesSumGoodsIndicator.getPastPeriodIndicator(), valueAddedTaxSumGoodsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
