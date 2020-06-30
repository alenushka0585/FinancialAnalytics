package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.SalesSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.FillableWithProductGroup;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class SalesIndicator extends Indicator implements FillableWithProductGroup {
    private final SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();

    public SalesIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                          Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnitAndProductGroup(String organizationUnitName, String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(salesSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(),organizationUnitName, productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(salesSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(),organizationUnitName, productGroup));
        fillIndicator();
    }

    @Override
    public void fillAllIndicatorAndProductGroup(String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(salesSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(), productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(salesSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(), productGroup));
        fillIndicator();
    }

}
