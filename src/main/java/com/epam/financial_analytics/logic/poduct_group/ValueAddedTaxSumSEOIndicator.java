package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.SEO;

public class ValueAddedTaxSumSEOIndicator extends ValueAddedTaxSumProductGroupIndicator implements Fillable {
    public ValueAddedTaxSumSEOIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getValueAddedTaxSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, SEO));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup(getValueAddedTaxSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, SEO));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getValueAddedTaxSumDaoIml(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(), SEO));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndProductGroup(getValueAddedTaxSumDaoIml(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(), SEO));
        fillIndicator();
    }
}
