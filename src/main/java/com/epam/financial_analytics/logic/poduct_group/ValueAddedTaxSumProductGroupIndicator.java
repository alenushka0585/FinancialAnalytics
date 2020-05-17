package com.epam.financial_analytics.logic.poduct_group;

import com.epam.financial_analytics.dao.impl.ValueAddedTaxSumDaoIml;
import com.epam.financial_analytics.logic.Indicator;

import java.sql.Date;

public class ValueAddedTaxSumProductGroupIndicator extends Indicator {
    private ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml= new ValueAddedTaxSumDaoIml();

    public ValueAddedTaxSumProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public ValueAddedTaxSumDaoIml getValueAddedTaxSumDaoIml() {
        return valueAddedTaxSumDaoIml;
    }
}
