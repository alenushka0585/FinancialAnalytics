package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.dao.impl.MarginSumDaoIml;
import com.epam.financial_analytics.logic.Indicator;

import java.sql.Date;

public class MarginSumProductGroupIndicator extends Indicator {
    private MarginSumDaoIml marginSumDaoIml= new MarginSumDaoIml();

    public MarginSumProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public MarginSumDaoIml getMarginSumDaoIml() {
        return marginSumDaoIml;
    }
}
