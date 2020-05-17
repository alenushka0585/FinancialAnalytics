package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.logic.poduct_group.*;

import java.sql.Date;

public class SalesSumTotalIndicator extends Indicator implements Fillable {
    private SalesSumProductionIndicator salesSumProductionIndicator;
    private SalesSumGoodsIndicator salesSumGoodsIndicator;
    private SalesSumOVPIndicator salesSumOVPIndicator;
    private SalesSumTSPIndicator salesSumTSPIndicator;
    private SalesSumVSIndicator salesSumVSIndicator;
    private SalesSumSEOIndicator salesSumSEOIndicator;
    private SalesSumENKIndicator salesSumENKIndicator;
    private SalesSumEBKIndicator salesSumEBKIndicator;
    private SalesSumSPPSIndicator salesSumSPPSIndicator;
    private SalesSumFKIndicator salesSumFKIndicator;
    private SalesSumOtherIndicator salesSumOtherIndicator;

    public SalesSumTotalIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumProductionIndicator = new SalesSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumGoodsIndicator = new SalesSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumOVPIndicator = new SalesSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumTSPIndicator = new SalesSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumVSIndicator = new SalesSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumSEOIndicator = new SalesSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumENKIndicator = new SalesSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumEBKIndicator = new SalesSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumSPPSIndicator = new SalesSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumFKIndicator = new SalesSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesSumOtherIndicator = new SalesSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salesSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salesSumProductionIndicator.fillAllIndicator();
        salesSumGoodsIndicator.fillAllIndicator();
        salesSumOVPIndicator.fillAllIndicator();
        salesSumTSPIndicator.fillAllIndicator();
        salesSumVSIndicator.fillAllIndicator();
        salesSumSEOIndicator.fillAllIndicator();
        salesSumENKIndicator.fillAllIndicator();
        salesSumEBKIndicator.fillAllIndicator();
        salesSumSPPSIndicator.fillAllIndicator();
        salesSumFKIndicator.fillAllIndicator();
        salesSumOtherIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(fillTotalIndicator(salesSumProductionIndicator.getPresentPeriodIndicator(), salesSumGoodsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(salesSumProductionIndicator.getPastPeriodIndicator(), salesSumGoodsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long production, long goods){
        long expenseIndecator = production + goods;
        return expenseIndecator;
    }

    public SalesSumProductionIndicator getSalesSumProductionIndicator() {
        return salesSumProductionIndicator;
    }

    public SalesSumGoodsIndicator getSalesSumGoodsIndicator() {
        return salesSumGoodsIndicator;
    }

    public SalesSumOVPIndicator getSalesSumOVPIndicator() {
        return salesSumOVPIndicator;
    }

    public SalesSumTSPIndicator getSalesSumTSPIndicator() {
        return salesSumTSPIndicator;
    }

    public SalesSumVSIndicator getSalesSumVSIndicator() {
        return salesSumVSIndicator;
    }

    public SalesSumSEOIndicator getSalesSumSEOIndicator() {
        return salesSumSEOIndicator;
    }

    public SalesSumENKIndicator getSalesSumENKIndicator() {
        return salesSumENKIndicator;
    }

    public SalesSumEBKIndicator getSalesSumEBKIndicator() {
        return salesSumEBKIndicator;
    }

    public SalesSumSPPSIndicator getSalesSumSPPSIndicator() {
        return salesSumSPPSIndicator;
    }

    public SalesSumFKIndicator getSalesSumFKIndicator() {
        return salesSumFKIndicator;
    }

    public SalesSumOtherIndicator getSalesSumOtherIndicator() {
        return salesSumOtherIndicator;
    }
}
