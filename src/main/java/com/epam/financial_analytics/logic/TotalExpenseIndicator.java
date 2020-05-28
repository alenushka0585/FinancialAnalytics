package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ExpenseTypeDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalExpenseIndicator extends Indicator implements Fillable {
    private ExpenseTypeDaoImpl expenseTypeDao = new ExpenseTypeDaoImpl();
    private Map<String, ExpenseIndicator> expenseInfoMap = new HashMap<>();
    private List<ExpenseType> expenseTypeList;

    public TotalExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                 Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        expenseTypeList = expenseTypeDao.getAll();
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ExpenseType expenseType : expenseTypeList) {
            ExpenseIndicator expenseIndicator = new ExpenseIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            expenseIndicator.fillAllIndicatorWithOrganizationUnitAndExpenseType(organizationUnitName, expenseType.getName());
            expenseInfoMap.put(expenseType.getName(), expenseIndicator);

            presentPeriodTotalIndicator+=expenseIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=expenseIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    @Override
    public void fillAllIndicator() {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ExpenseType expenseType : expenseTypeList) {
            ExpenseIndicator expenseIndicator = new ExpenseIndicator
                    (getPresentPeriodStartDate(), getPresentPeriodFinishDate(), getPastPeriodStartDate(), getPastPeriodFinishDate(), getCurrencyName());

            expenseIndicator.fillAllIndicatorAndExpenseType(expenseType.getName());
            expenseInfoMap.put(expenseType.getName(), expenseIndicator);

            presentPeriodTotalIndicator+=expenseIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=expenseIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public Map<String, ExpenseIndicator> getExpenseInfoMap() {
        return expenseInfoMap;
    }
}