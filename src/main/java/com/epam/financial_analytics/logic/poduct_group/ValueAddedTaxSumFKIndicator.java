package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.FK;

public class ValueAddedTaxSumFKIndicator extends ValueAddedTaxSumProductGroupIndicator implements Fillable {
    public ValueAddedTaxSumFKIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getValueAddedTaxSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, FK));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getValueAddedTaxSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, FK));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getValueAddedTaxSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(), FK));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getValueAddedTaxSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(), FK));
        fillIndicator();
    }
}
