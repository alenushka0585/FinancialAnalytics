package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.dao.impl.MarginSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;

import java.sql.Date;

public abstract class MarginSumProductGroupIndicator extends Indicator {
    private final MarginSumDaoIml marginSumDaoIml= new MarginSumDaoIml();

    public MarginSumProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                          Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public MarginSumDaoIml getMarginSumDaoIml() {
        return marginSumDaoIml;
    }
}
