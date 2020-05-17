package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class MarginSumProductionIndicator extends MarginSumProductGroupIndicator implements Fillable {
    private volatile static MarginSumProductionIndicator instance;
    private MarginSumOVPIndicator marginSumOVPIndicator;
    private MarginSumTSPIndicator marginSumTSPIndicator;
    private MarginSumVSIndicator marginSumVSIndicator;
    private MarginSumSEOIndicator marginSumSEOIndicator;
    private MarginSumENKIndicator marginSumENKIndicator;
    private MarginSumEBKIndicator marginSumEBKIndicator;
    private MarginSumSPPSIndicator marginSumSPPSIndicator;
    private MarginSumFKIndicator marginSumFKIndicator;
    private MarginSumOtherIndicator marginSumOtherIndicator;

    public MarginSumProductionIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
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
        setPresentPeriodIndicator(fillTotalIndicator(marginSumOVPIndicator.getPresentPeriodIndicator(), marginSumTSPIndicator.getPresentPeriodIndicator(),
                marginSumVSIndicator.getPresentPeriodIndicator(), marginSumSEOIndicator.getPresentPeriodIndicator(), marginSumENKIndicator.getPresentPeriodIndicator(),
                marginSumEBKIndicator.getPresentPeriodIndicator(), marginSumSPPSIndicator.getPresentPeriodIndicator(), marginSumFKIndicator.getPresentPeriodIndicator(),
                marginSumOtherIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(marginSumOVPIndicator.getPastPeriodIndicator(), marginSumTSPIndicator.getPastPeriodIndicator(),
                marginSumVSIndicator.getPastPeriodIndicator(), marginSumSEOIndicator.getPastPeriodIndicator(), marginSumENKIndicator.getPastPeriodIndicator(),
                marginSumEBKIndicator.getPastPeriodIndicator(), marginSumSPPSIndicator.getPastPeriodIndicator(), marginSumFKIndicator.getPastPeriodIndicator(),
                marginSumOtherIndicator.getPastPeriodIndicator()));

        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long ovp, long tsp, long vs, long seo, long enk, long ebk, long spps, long fk, long other){
        long expenseIndecator = ovp + tsp + vs + seo + enk + ebk + spps + fk + other;
        return expenseIndecator;
    }

    public static MarginSumProductionIndicator getInstance(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName){
        if (instance == null){
            synchronized (MarginSumProductionIndicator.class){
                if (instance == null){
                    instance = new MarginSumProductionIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
                }
            }
        }
        return instance;
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
