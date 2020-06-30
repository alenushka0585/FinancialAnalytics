package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class MarginOnSquareMetreIndicator extends Indicator implements Fillable {
    private final TotalMarginIndicator totalMarginIndicator;
    private final SalesOfSquareMetresIndicator salesOfSquareMetresIndicator;

    public MarginOnSquareMetreIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                        Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalMarginIndicator = new TotalMarginIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfSquareMetresIndicator = new SalesOfSquareMetresIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        totalMarginIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfSquareMetresIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        totalMarginIndicator.fillAllIndicator();
        salesOfSquareMetresIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(totalMarginIndicator.getPresentPeriodIndicator(),
                salesOfSquareMetresIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(totalMarginIndicator.getPastPeriodIndicator(),
                salesOfSquareMetresIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public SalesOfSquareMetresIndicator getSalesOfSquareMetresIndicator() {
        return salesOfSquareMetresIndicator;
    }
}
