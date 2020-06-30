package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ValueAddedTaxSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.FillableWithProductGroup;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class ValueAddedTaxIndicator extends Indicator implements FillableWithProductGroup {
    private final ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml = new ValueAddedTaxSumDaoIml();

    public ValueAddedTaxIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                  Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnitAndProductGroup(String organizationUnitName, String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(valueAddedTaxSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(),organizationUnitName, productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(valueAddedTaxSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(),organizationUnitName, productGroup));
        fillIndicator();
    }

    @Override
    public void fillAllIndicatorAndProductGroup(String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(valueAddedTaxSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(), productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(valueAddedTaxSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(), productGroup));
        fillIndicator();
    }

}
