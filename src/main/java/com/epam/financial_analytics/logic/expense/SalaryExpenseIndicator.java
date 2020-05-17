package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.logic.Fillable;
import com.epam.financial_analytics.logic.Indicator;
import com.epam.financial_analytics.logic.IndicatorUtil;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstant.SALARY;

public class SalaryExpenseIndicator extends Indicator implements Fillable {
    private ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();

    public SalaryExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public ExpenseInfoDaoImpl getExpenseInfoDao() {
        return expenseInfoDao;
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),
                getPresentPeriodFinishDate(),organizationUnitName, SALARY));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),
                getPastPeriodFinishDate(),organizationUnitName, SALARY));
        fillIndicator();
    }

    @Override
    public void fillAllIndicator(){
        setPresentPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPresentPeriodStartDate(),getPresentPeriodFinishDate(), SALARY));
        setPastPeriodIndicatorList(IndicatorUtil.fillIndicatorSumListAndExpenseType(getExpenseInfoDao(),getPastPeriodStartDate(),getPastPeriodFinishDate(), SALARY));
        fillIndicator();
    }
}
