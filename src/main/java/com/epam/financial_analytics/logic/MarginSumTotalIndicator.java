package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.logic.poduct_group.*;

import java.sql.Date;

public class MarginSumTotalIndicator extends Indicator implements Fillable {

    private MarginSumProductionIndicator marginSumProductionIndicator;
    private MarginSumGoodsIndicator marginSumGoodsIndicator;
    private MarginSumOVPIndicator marginSumOVPIndicator;
    private MarginSumTSPIndicator marginSumTSPIndicator;
    private MarginSumVSIndicator marginSumVSIndicator;
    private MarginSumSEOIndicator marginSumSEOIndicator;
    private MarginSumENKIndicator marginSumENKIndicator;
    private MarginSumEBKIndicator marginSumEBKIndicator;
    private MarginSumSPPSIndicator marginSumSPPSIndicator;
    private MarginSumFKIndicator marginSumFKIndicator;
    private MarginSumOtherIndicator marginSumOtherIndicator;

    public MarginSumTotalIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumProductionIndicator = new MarginSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumGoodsIndicator = new MarginSumGoodsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumOVPIndicator = new MarginSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumTSPIndicator = new MarginSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumVSIndicator = new MarginSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumSEOIndicator = new MarginSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumENKIndicator = new MarginSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumEBKIndicator = new MarginSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumSPPSIndicator = new MarginSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumFKIndicator = new MarginSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginSumOtherIndicator = new MarginSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        marginSumProductionIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumGoodsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        marginSumProductionIndicator.fillAllIndicator();
        marginSumGoodsIndicator.fillAllIndicator();
        marginSumOVPIndicator.fillAllIndicator();
        marginSumTSPIndicator.fillAllIndicator();
        marginSumVSIndicator.fillAllIndicator();
        marginSumSEOIndicator.fillAllIndicator();
        marginSumENKIndicator.fillAllIndicator();
        marginSumEBKIndicator.fillAllIndicator();
        marginSumSPPSIndicator.fillAllIndicator();
        marginSumFKIndicator.fillAllIndicator();
        marginSumOtherIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(fillTotalIndicator(marginSumProductionIndicator.getPresentPeriodIndicator(), marginSumGoodsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(marginSumProductionIndicator.getPastPeriodIndicator(), marginSumGoodsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long production, long goods){
        long expenseIndecator = production + goods;
        return expenseIndecator;
    }

    public MarginSumProductionIndicator getMarginSumProductionIndicator() {
        return marginSumProductionIndicator;
    }

    public MarginSumGoodsIndicator getMarginSumGoodsIndicator() {
        return marginSumGoodsIndicator;
    }

    public MarginSumOVPIndicator getMarginSumOVPIndicator() {
        return marginSumOVPIndicator;
    }

    public MarginSumTSPIndicator getMarginSumTSPIndicator() {
        return marginSumTSPIndicator;
    }

    public MarginSumVSIndicator getMarginSumVSIndicator() {
        return marginSumVSIndicator;
    }

    public MarginSumSEOIndicator getMarginSumSEOIndicator() {
        return marginSumSEOIndicator;
    }

    public MarginSumENKIndicator getMarginSumENKIndicator() {
        return marginSumENKIndicator;
    }

    public MarginSumEBKIndicator getMarginSumEBKIndicator() {
        return marginSumEBKIndicator;
    }

    public MarginSumSPPSIndicator getMarginSumSPPSIndicator() {
        return marginSumSPPSIndicator;
    }

    public MarginSumFKIndicator getMarginSumFKIndicator() {
        return marginSumFKIndicator;
    }

    public MarginSumOtherIndicator getMarginSumOtherIndicator() {
        return marginSumOtherIndicator;
    }
}
