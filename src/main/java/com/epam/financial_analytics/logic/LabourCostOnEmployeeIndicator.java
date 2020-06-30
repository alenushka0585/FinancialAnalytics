package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class LabourCostOnEmployeeIndicator extends Indicator implements Fillable {
    private final LabourCostIndicator labourCostIndicator;
    private final NumberOfStuffIndicator numberOfStuffIndicator;

    public LabourCostOnEmployeeIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                         Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostIndicator = new LabourCostIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        numberOfStuffIndicator = new NumberOfStuffIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        labourCostIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        numberOfStuffIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        labourCostIndicator.fillAllIndicator();
        numberOfStuffIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(labourCostIndicator.getPresentPeriodIndicator(),
                numberOfStuffIndicator.getPresentPeriodIndicator(),getAmountOfMonths()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnotherInMonth(labourCostIndicator.getPastPeriodIndicator(),
                numberOfStuffIndicator.getPastPeriodIndicator(), getAmountOfMonths()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
