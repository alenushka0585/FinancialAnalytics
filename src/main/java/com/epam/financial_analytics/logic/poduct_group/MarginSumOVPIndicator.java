package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.OVP;

public class MarginSumOVPIndicator extends MarginSumProductGroupIndicator implements Fillable {


    public MarginSumOVPIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getMarginSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, OVP));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getMarginSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, OVP));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getMarginSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(), OVP));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getMarginSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(), OVP));
        fillIndicator();
    }
}
