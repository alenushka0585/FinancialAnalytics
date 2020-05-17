package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class SalesSumProductionIndicator extends SalesSumProductGroupIndicator implements Fillable {
    private SalesSumOVPIndicator salesSumOVPIndicator;
    private SalesSumTSPIndicator salesSumTSPIndicator;
    private SalesSumVSIndicator salesSumVSIndicator;
    private SalesSumSEOIndicator salesSumSEOIndicator;
    private SalesSumENKIndicator salesSumENKIndicator;
    private SalesSumEBKIndicator salesSumEBKIndicator;
    private SalesSumSPPSIndicator salesSumSPPSIndicator;
    private SalesSumFKIndicator salesSumFKIndicator;
    private SalesSumOtherIndicator salesSumOtherIndicator;

    public SalesSumProductionIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
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
        setPresentPeriodIndicator(fillTotalIndicator(salesSumOVPIndicator.getPresentPeriodIndicator(), salesSumTSPIndicator.getPresentPeriodIndicator(),
                salesSumVSIndicator.getPresentPeriodIndicator(), salesSumSEOIndicator.getPresentPeriodIndicator(), salesSumENKIndicator.getPresentPeriodIndicator(),
                salesSumEBKIndicator.getPresentPeriodIndicator(), salesSumSPPSIndicator.getPresentPeriodIndicator(), salesSumFKIndicator.getPresentPeriodIndicator(),
                salesSumOtherIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(salesSumOVPIndicator.getPastPeriodIndicator(), salesSumTSPIndicator.getPastPeriodIndicator(),
                salesSumVSIndicator.getPastPeriodIndicator(), salesSumSEOIndicator.getPastPeriodIndicator(), salesSumENKIndicator.getPastPeriodIndicator(),
                salesSumEBKIndicator.getPastPeriodIndicator(), salesSumSPPSIndicator.getPastPeriodIndicator(), salesSumFKIndicator.getPastPeriodIndicator(),
                salesSumOtherIndicator.getPastPeriodIndicator()));

        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long ovp, long tsp, long vs, long seo, long enk, long ebk, long spps, long fk, long other){
        long expenseIndecator = ovp + tsp + vs + seo + enk + ebk + spps + fk + other;
        return expenseIndecator;
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
