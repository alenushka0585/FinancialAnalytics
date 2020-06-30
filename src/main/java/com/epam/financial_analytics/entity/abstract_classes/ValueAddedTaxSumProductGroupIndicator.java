package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.dao.impl.ValueAddedTaxSumDaoIml;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;

import java.sql.Date;

public abstract class ValueAddedTaxSumProductGroupIndicator extends Indicator {
    private final ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml= new ValueAddedTaxSumDaoIml();

    public ValueAddedTaxSumProductGroupIndicator(Date presentPeriodStartDate,
                                                 Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public ValueAddedTaxSumDaoIml getValueAddedTaxSumDaoIml() {
        return valueAddedTaxSumDaoIml;
    }
}
