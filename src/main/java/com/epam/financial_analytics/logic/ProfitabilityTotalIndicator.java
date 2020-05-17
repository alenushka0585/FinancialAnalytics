package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.logic.poduct_group.*;

import java.sql.Date;

public class ProfitabilityTotalIndicator extends Indicator implements Fillable {
    private SalesSumTotalIndicator salesSumTotalIndicator;
    private ValueAddedTaxSumTotalIndicator valueAddedTaxSumTotalIndicator;
    private MarginSumTotalIndicator marginSumTotalIndicator;
    private ProfitabilityProductionIndicator profitabilityProductionIndicator;
    private ProfitabilityOVPIndicator profitabilityOVPIndicator;
    private ProfitabilityTSPIndicator profitabilityTSPIndicator;
    private ProfitabilityVSIndicator profitabilityVSIndicator;
    private ProfitabilitySEOIndicator profitabilitySEOIndicator;
    private ProfitabilityENKIndicator profitabilityENKIndicator;
    private ProfitabilityEBKIndicator profitabilityEBKIndicator;
    private ProfitabilitySPPSIndicator profitabilitySPPSIndicator;
    private ProfitabilityFKIndicator profitabilityFKIndicator;
    private ProfitabilityOtherIndicator profitabilityOtherIndicator;
    private ProfitabilityGoodsIndicator profitabilityGoodsIndicator;


    public ProfitabilityTotalIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumTotalIndicator = new SalesSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumTotalIndicator = new ValueAddedTaxSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTotalIndicator = new MarginSumTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityProductionIndicator = new ProfitabilityProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityOVPIndicator = new ProfitabilityOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityTSPIndicator = new ProfitabilityTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityVSIndicator = new ProfitabilityVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilitySEOIndicator = new ProfitabilitySEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityENKIndicator = new ProfitabilityENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityEBKIndicator = new ProfitabilityEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilitySPPSIndicator = new ProfitabilitySPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityFKIndicator = new ProfitabilityFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityOtherIndicator = new ProfitabilityOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityGoodsIndicator = new ProfitabilityGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilitySEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilitySPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumTotalIndicator.fillAllIndicator();
        valueAddedTaxSumTotalIndicator.fillAllIndicator();
        marginSumTotalIndicator.fillAllIndicator();
        profitabilityProductionIndicator.fillAllIndicator();
        profitabilityOVPIndicator.fillAllIndicator();
        profitabilityTSPIndicator.fillAllIndicator();
        profitabilityVSIndicator.fillAllIndicator();
        profitabilitySEOIndicator.fillAllIndicator();
        profitabilityENKIndicator.fillAllIndicator();
        profitabilityEBKIndicator.fillAllIndicator();
        profitabilitySPPSIndicator.fillAllIndicator();
        profitabilityFKIndicator.fillAllIndicator();
        profitabilityOtherIndicator.fillAllIndicator();
        profitabilityGoodsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginSumTotalIndicator.getPresentPeriodIndicator(),
                salesSumTotalIndicator.getPresentPeriodIndicator(), valueAddedTaxSumTotalIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginSumTotalIndicator.getPastPeriodIndicator(),
                salesSumTotalIndicator.getPastPeriodIndicator(), valueAddedTaxSumTotalIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public SalesSumTotalIndicator getSalesSumTotalIndicator() {
        return salesSumTotalIndicator;
    }

    public MarginSumTotalIndicator getMarginSumTotalIndicator() {
        return marginSumTotalIndicator;
    }

    public ProfitabilityProductionIndicator getProfitabilityProductionIndicator() {
        return profitabilityProductionIndicator;
    }

    public ProfitabilityOVPIndicator getProfitabilityOVPIndicator() {
        return profitabilityOVPIndicator;
    }

    public ProfitabilityTSPIndicator getProfitabilityTSPIndicator() {
        return profitabilityTSPIndicator;
    }

    public ProfitabilityVSIndicator getProfitabilityVSIndicator() {
        return profitabilityVSIndicator;
    }

    public ProfitabilitySEOIndicator getProfitabilitySEOIndicator() {
        return profitabilitySEOIndicator;
    }

    public ProfitabilityENKIndicator getProfitabilityENKIndicator() {
        return profitabilityENKIndicator;
    }

    public ProfitabilityEBKIndicator getProfitabilityEBKIndicator() {
        return profitabilityEBKIndicator;
    }

    public ProfitabilitySPPSIndicator getProfitabilitySPPSIndicator() {
        return profitabilitySPPSIndicator;
    }

    public ProfitabilityFKIndicator getProfitabilityFKIndicator() {
        return profitabilityFKIndicator;
    }

    public ProfitabilityOtherIndicator getProfitabilityOtherIndicator() {
        return profitabilityOtherIndicator;
    }

    public ProfitabilityGoodsIndicator getProfitabilityGoodsIndicator() {
        return profitabilityGoodsIndicator;
    }
}
