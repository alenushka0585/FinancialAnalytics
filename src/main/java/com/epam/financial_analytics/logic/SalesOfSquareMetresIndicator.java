package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.SalesOfSquareMetresDaoImpl;

import java.sql.Date;

public class SalesOfSquareMetresIndicator extends Indicator implements Fillable{

    public SalesOfSquareMetresDaoImpl salesOfSquareMetresDao = new SalesOfSquareMetresDaoImpl();

    public SalesOfSquareMetresIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public SalesOfSquareMetresDaoImpl getSalesOfSquareMetresDao() {
        return salesOfSquareMetresDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getSalesOfSquareMetresDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getSalesOfSquareMetresDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getSalesOfSquareMetresDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getSalesOfSquareMetresDao(),getPastPeriodStartDate(),getPastPeriodFinishDate()));
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorSum(getPresentPeriodIndicatorList()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorSum(getPastPeriodIndicatorList()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
