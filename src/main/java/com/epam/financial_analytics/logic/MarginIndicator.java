package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.MarginSumDaoIml;
import com.epam.financial_analytics.dao.impl.SalesSumDaoIml;
import com.epam.financial_analytics.dao.impl.ValueAddedTaxSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.FillableWithProductGroup;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class MarginIndicator extends Indicator implements FillableWithProductGroup {
    private SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();
    private MarginSumDaoIml marginSumDaoIml = new MarginSumDaoIml();
    private ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml = new ValueAddedTaxSumDaoIml();

    public MarginIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                           Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnitAndProductGroup(String organizationUnitName, String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(marginSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(),organizationUnitName, productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(marginSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(),organizationUnitName, productGroup));
        fillIndicator();
    }

    @Override
    public void fillAllIndicatorAndProductGroup(String productGroup) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(marginSumDaoIml,
                getPresentPeriodStartDate(), getPresentPeriodFinishDate(), productGroup));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(marginSumDaoIml,
                getPastPeriodStartDate(), getPastPeriodFinishDate(), productGroup));
        fillIndicator();
    }

}
