package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.NumberOfStuffDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class NumberOfStuffIndicator extends Indicator implements Fillable {

    private final NumberOfStuffDaoImpl numberOfStuffDao = new NumberOfStuffDaoImpl();

    public NumberOfStuffIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                  Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public NumberOfStuffDaoImpl getNumberOfStuffDao() {
        return numberOfStuffDao;
    }



    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getNumberOfStuffDao(),
                getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getNumberOfStuffDao(),
                getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getNumberOfStuffDao(),
                getPresentPeriodStartDate(),getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getNumberOfStuffDao(),
                getPastPeriodStartDate(),getPastPeriodFinishDate()));
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorAverageSum(getPresentPeriodIndicatorList(), getAmountOfMonths()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorAverageSum(getPastPeriodIndicatorList(), getAmountOfMonths()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(),
                getPastPeriodIndicator()));
    }
}
