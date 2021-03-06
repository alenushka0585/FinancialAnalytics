package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class MarginOnTonsIndicator extends Indicator implements Fillable {
    private final TotalMarginIndicator totalMarginIndicator;
    private final SalesOfTonsIndicator salesOfTonsIndicator;

    public MarginOnTonsIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                 Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalMarginIndicator = new TotalMarginIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfTonsIndicator = new SalesOfTonsIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        totalMarginIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfTonsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        totalMarginIndicator.fillAllIndicator();
        salesOfTonsIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(totalMarginIndicator.getPresentPeriodIndicator(),
                salesOfTonsIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(totalMarginIndicator.getPastPeriodIndicator(),
                salesOfTonsIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public SalesOfTonsIndicator getSalesOfTonsIndicator() {
        return salesOfTonsIndicator;
    }
}
