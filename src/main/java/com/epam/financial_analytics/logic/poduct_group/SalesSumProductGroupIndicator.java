package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.dao.impl.SalesSumDaoIml;
import com.epam.financial_analytics.logic.Indicator;

import java.sql.Date;

public class SalesSumProductGroupIndicator extends Indicator {
    private SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();

    public SalesSumProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public SalesSumDaoIml getSalesSumDaoIml() {
        return salesSumDaoIml;
    }
}
