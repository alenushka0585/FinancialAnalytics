package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

public class ValueAddedTaxSumProductionIndicator extends ValueAddedTaxSumProductGroupIndicator implements Fillable {
    private ValueAddedTaxSumOVPIndicator valueAddedTaxSumOVPIndicator;
    private ValueAddedTaxSumTSPIndicator valueAddedTaxSumTSPIndicator;
    private ValueAddedTaxSumVSIndicator valueAddedTaxSumVSIndicator;
    private ValueAddedTaxSumSEOIndicator valueAddedTaxSumSEOIndicator;
    private ValueAddedTaxSumENKIndicator valueAddedTaxSumENKIndicator;
    private ValueAddedTaxSumEBKIndicator valueAddedTaxSumEBKIndicator;
    private ValueAddedTaxSumSPPSIndicator valueAddedTaxSumSPPSIndicator;
    private ValueAddedTaxSumFKIndicator valueAddedTaxSumFKIndicator;
    private ValueAddedTaxSumOtherIndicator valueAddedTaxSumOtherIndicator;

    public ValueAddedTaxSumProductionIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumOVPIndicator = new ValueAddedTaxSumOVPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumTSPIndicator = new ValueAddedTaxSumTSPIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumVSIndicator = new ValueAddedTaxSumVSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumSEOIndicator = new ValueAddedTaxSumSEOIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumENKIndicator = new ValueAddedTaxSumENKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumEBKIndicator = new ValueAddedTaxSumEBKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumSPPSIndicator = new ValueAddedTaxSumSPPSIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumFKIndicator = new ValueAddedTaxSumFKIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxSumOtherIndicator = new ValueAddedTaxSumOtherIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);

    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        valueAddedTaxSumOVPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumTSPIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumVSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumSEOIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumENKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumEBKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumSPPSIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumFKIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        valueAddedTaxSumOtherIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        valueAddedTaxSumOVPIndicator.fillAllIndicator();
        valueAddedTaxSumTSPIndicator.fillAllIndicator();
        valueAddedTaxSumVSIndicator.fillAllIndicator();
        valueAddedTaxSumSEOIndicator.fillAllIndicator();
        valueAddedTaxSumENKIndicator.fillAllIndicator();
        valueAddedTaxSumEBKIndicator.fillAllIndicator();
        valueAddedTaxSumSPPSIndicator.fillAllIndicator();
        valueAddedTaxSumFKIndicator.fillAllIndicator();
        valueAddedTaxSumOtherIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(fillTotalIndicator(valueAddedTaxSumOVPIndicator.getPresentPeriodIndicator(), valueAddedTaxSumTSPIndicator.getPresentPeriodIndicator(),
                valueAddedTaxSumVSIndicator.getPresentPeriodIndicator(), valueAddedTaxSumSEOIndicator.getPresentPeriodIndicator(), valueAddedTaxSumENKIndicator.getPresentPeriodIndicator(),
                valueAddedTaxSumEBKIndicator.getPresentPeriodIndicator(), valueAddedTaxSumSPPSIndicator.getPresentPeriodIndicator(), valueAddedTaxSumFKIndicator.getPresentPeriodIndicator(),
                valueAddedTaxSumOtherIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(valueAddedTaxSumOVPIndicator.getPastPeriodIndicator(), valueAddedTaxSumTSPIndicator.getPastPeriodIndicator(),
                valueAddedTaxSumVSIndicator.getPastPeriodIndicator(), valueAddedTaxSumSEOIndicator.getPastPeriodIndicator(), valueAddedTaxSumENKIndicator.getPastPeriodIndicator(),
                valueAddedTaxSumEBKIndicator.getPastPeriodIndicator(), valueAddedTaxSumSPPSIndicator.getPastPeriodIndicator(), valueAddedTaxSumFKIndicator.getPastPeriodIndicator(),
                valueAddedTaxSumOtherIndicator.getPastPeriodIndicator()));

        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long ovp, long tsp, long vs, long seo, long enk, long ebk, long spps, long fk, long other){
        long expenseIndecator = ovp + tsp + vs + seo + enk + ebk + spps + fk + other;
        return expenseIndecator;
    }

    public ValueAddedTaxSumOVPIndicator getValueAddedTaxSumOVPIndicator() {
        return valueAddedTaxSumOVPIndicator;
    }

    public ValueAddedTaxSumTSPIndicator getValueAddedTaxSumTSPIndicator() {
        return valueAddedTaxSumTSPIndicator;
    }

    public ValueAddedTaxSumVSIndicator getValueAddedTaxSumVSIndicator() {
        return valueAddedTaxSumVSIndicator;
    }

    public ValueAddedTaxSumSEOIndicator getValueAddedTaxSumSEOIndicator() {
        return valueAddedTaxSumSEOIndicator;
    }

    public ValueAddedTaxSumENKIndicator getValueAddedTaxSumENKIndicator() {
        return valueAddedTaxSumENKIndicator;
    }

    public ValueAddedTaxSumEBKIndicator getValueAddedTaxSumEBKIndicator() {
        return valueAddedTaxSumEBKIndicator;
    }

    public ValueAddedTaxSumSPPSIndicator getValueAddedTaxSumSPPSIndicator() {
        return valueAddedTaxSumSPPSIndicator;
    }

    public ValueAddedTaxSumFKIndicator getValueAddedTaxSumFKIndicator() {
        return valueAddedTaxSumFKIndicator;
    }

    public ValueAddedTaxSumOtherIndicator getValueAddedTaxSumOtherIndicator() {
        return valueAddedTaxSumOtherIndicator;
    }
}
