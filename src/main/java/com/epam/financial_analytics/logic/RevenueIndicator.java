package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.RevenueDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class RevenueIndicator extends Indicator implements Fillable {
    private final RevenueDaoImpl revenueDao = new RevenueDaoImpl();

    public RevenueIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                            Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public RevenueDaoImpl getRevenueDao() {
        return revenueDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getRevenueDao(),
                getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getRevenueDao(),
                getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }
    @Override
    public void fillAllIndicator(){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getRevenueDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getRevenueDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate()));
        fillIndicator();
    }
}
