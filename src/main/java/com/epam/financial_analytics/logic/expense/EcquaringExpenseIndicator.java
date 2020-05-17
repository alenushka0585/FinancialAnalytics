package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.ECQUIRING;

public class EcquaringExpenseIndicator extends ExpenseIndicator implements Fillable {
    public EcquaringExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, ECQUIRING));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, ECQUIRING));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(), ECQUIRING));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(), ECQUIRING));
        fillIndicator();
    }
}
