package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.MetalProcessingDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;

public class MetalProcessingIndicator extends Indicator implements Fillable {
    private MetalProcessingDaoImpl metalProcessingDao = new MetalProcessingDaoImpl();

    public MetalProcessingIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                    Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public MetalProcessingDaoImpl getMetalProcessingDao() {
        return metalProcessingDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getMetalProcessingDao(),
                getPresentPeriodStartDate(),getPresentPeriodFinishDate(),organizationUnitName));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnit(getMetalProcessingDao(),
                getPastPeriodStartDate(),getPastPeriodFinishDate(),organizationUnitName));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getMetalProcessingDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate()));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumList(getMetalProcessingDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate()));
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorSum(getPresentPeriodIndicatorList()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorSum(getPastPeriodIndicatorList()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(),
                getPastPeriodIndicator()));
    }
}
