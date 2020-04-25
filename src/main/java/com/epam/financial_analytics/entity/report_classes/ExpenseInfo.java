package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganizationAndCurrency;
import com.epam.financial_analytics.entity.dictionary.*;

import java.sql.Date;

public class ExpenseInfo extends ReportWithOrganizationAndCurrency {
    ExpenseType expenseType;
    private long sum;

    public ExpenseInfo() {
    }

    public ExpenseInfo(long id, Date date, OrganizationUnit organizationUnit, Currency currency, ExpenseType expenseType, long sum) {
        super(id, date, organizationUnit, currency);
        this.expenseType = expenseType;
        this.sum = sum;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "ExpenseInfo " + super.toString() +  ", " + expenseType +
                ", sum=" + sum;
    }
}
