package com.epam.financial_analytics.logic.expense;

import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;
import com.epam.financial_analytics.logic.Indicator;

import java.sql.Date;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstant.*;

public abstract class ExpenseIndicator extends Indicator {
    private ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();

    public ExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public ExpenseInfoDaoImpl getExpenseInfoDao() {
        return expenseInfoDao;
    }
}
