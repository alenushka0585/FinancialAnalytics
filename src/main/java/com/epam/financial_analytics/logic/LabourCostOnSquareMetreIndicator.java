package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class LabourCostOnSquareMetreIndicator extends Indicator implements Fillable {
    private final LabourCostIndicator labourCostIndicator;
    private final SalesOfSquareMetresIndicator salesOfSquareMetresIndicator;

    public LabourCostOnSquareMetreIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                            Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostIndicator = new LabourCostIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salesOfSquareMetresIndicator = new SalesOfSquareMetresIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        labourCostIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        salesOfSquareMetresIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        labourCostIndicator.fillAllIndicator();
        salesOfSquareMetresIndicator.fillAllIndicator();
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countOneToAnother(labourCostIndicator.getPresentPeriodIndicator(),
                salesOfSquareMetresIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countOneToAnother(labourCostIndicator.getPastPeriodIndicator(),
                salesOfSquareMetresIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
