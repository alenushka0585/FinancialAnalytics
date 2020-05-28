package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.dao.impl.SalesSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;

import java.sql.Date;

public abstract class SalesSumProductGroupIndicator extends Indicator {
    private SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();

    public SalesSumProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                         Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public SalesSumDaoIml getSalesSumDaoIml() {
        return salesSumDaoIml;
    }
}
