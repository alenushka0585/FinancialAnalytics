package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.SalesOfSquareMetresDaoImpl;
import com.epam.financial_analytics.dao.impl.SalesOfTonsDaoImpl;

import java.sql.Date;

public class SalesOfTonsIndicator extends Indicator implements Fillable{

    public SalesOfTonsDaoImpl tonsDao = new SalesOfTonsDaoImpl();

    public SalesOfTonsIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public SalesOfTonsDaoImpl getTonsDao() {
        return tonsDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getTonsDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getTonsDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getTonsDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getTonsDao(),getPastPeriodStartDate(),getPastPeriodFinishDate()));
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
