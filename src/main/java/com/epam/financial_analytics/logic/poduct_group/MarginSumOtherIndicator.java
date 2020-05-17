package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.OTHER;

public class MarginSumOtherIndicator extends MarginSumProductGroupIndicator implements Fillable {

    public MarginSumOtherIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getMarginSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, OTHER));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getMarginSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, OTHER));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getMarginSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(), OTHER));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getMarginSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(), OTHER));
        fillIndicator();
    }
}
