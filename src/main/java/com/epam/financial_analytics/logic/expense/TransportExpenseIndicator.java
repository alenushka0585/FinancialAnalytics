package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.IndicatorUtil;
import com.epam.financial_analytics.logic.expense.ExpenseIndicator;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.TRANSPORT;

public class TransportExpenseIndicator extends ExpenseIndicator implements Fillable {

    public TransportExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, TRANSPORT));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, TRANSPORT));
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPresentPeriodIndicatorList(), getCurrencyName(), getPresentPeriodCurrencyList()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPastPeriodIndicatorList(), getCurrencyName(), getPastPeriodCurrencyList()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    @Override
    public void fillAllIndicator() {
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(), TRANSPORT));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(), TRANSPORT));
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPresentPeriodIndicatorList(), getCurrencyName(), getPresentPeriodCurrencyList()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPastPeriodIndicatorList(), getCurrencyName(), getPastPeriodCurrencyList()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
