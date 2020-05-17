package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.LabourCostDaoImpl;
import com.epam.financial_analytics.dao.impl.RevenueDaoImpl;

import java.sql.Date;

public class LabourCostIndicator extends Indicator implements Fillable{

    private LabourCostDaoImpl labourCostDao = new LabourCostDaoImpl();

    public LabourCostIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public LabourCostDaoImpl getLabourCostDao() {
        return labourCostDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getLabourCostDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getLabourCostDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }
    @Override
    public void fillAllIndicator(){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getLabourCostDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getLabourCostDao(),getPastPeriodStartDate(),getPastPeriodFinishDate()));
        fillIndicator();
    }
}
