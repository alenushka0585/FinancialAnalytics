package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.FillableWithProductGroup;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class ProfitabilityIndicator extends Indicator implements FillableWithProductGroup {
    private SalesIndicator salesIndicator;
    private ValueAddedTaxIndicator valueAddedTaxIndicator;
    private MarginIndicator marginIndicator;

    public ProfitabilityIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                     Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesIndicator = new SalesIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        valueAddedTaxIndicator = new ValueAddedTaxIndicator
                (presentPeriodStartDate, presentPeriodFinishDate,
                        pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginIndicator = new MarginIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnitAndProductGroup(String organizationUnitName, String productGroup) {
        salesIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup);
        valueAddedTaxIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup);
        marginIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup);
        fillIndicator();
    }

    @Override
    public void fillAllIndicatorAndProductGroup(String productGroup) {
        salesIndicator.fillAllIndicatorAndProductGroup(productGroup);
        valueAddedTaxIndicator.fillAllIndicatorAndProductGroup(productGroup);
        marginIndicator.fillAllIndicatorAndProductGroup(productGroup);
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(marginIndicator.getPresentPeriodIndicator(),
                salesIndicator.getPresentPeriodIndicator(), valueAddedTaxIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(marginIndicator.getPastPeriodIndicator(),
                salesIndicator.getPastPeriodIndicator(), valueAddedTaxIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}