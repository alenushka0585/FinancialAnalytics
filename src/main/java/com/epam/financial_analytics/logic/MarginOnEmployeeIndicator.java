package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class MarginOnEmployeeIndicator extends Indicator implements Fillable {
    private final TotalMarginIndicator totalMarginIndicator;
    private final NumberOfStuffIndicator numberOfStuffIndicator;

    public MarginOnEmployeeIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                     Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalMarginIndicator = new TotalMarginIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        numberOfStuffIndicator = new NumberOfStuffIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        totalMarginIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        numberOfStuffIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        totalMarginIndicator.fillAllIndicator();
        numberOfStuffIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(totalMarginIndicator.getPresentPeriodIndicator(),
                numberOfStuffIndicator.getPresentPeriodIndicator(),getAmountOfMonths()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(totalMarginIndicator.getPastPeriodIndicator(),
                numberOfStuffIndicator.getPastPeriodIndicator(), getAmountOfMonths()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(),
                getPastPeriodIndicator()));
    }
}
