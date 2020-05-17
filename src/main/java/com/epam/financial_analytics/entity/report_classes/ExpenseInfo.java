package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.*;

import java.sql.Date;

public class ExpenseInfo extends ReportWithOrganizationAndCurrency {
    ExpenseType expenseType;

    public ExpenseInfo() {
    }

    public ExpenseInfo(Date date, long amount, OrganizationUnit organizationUnit, Currency currency, ExpenseType expenseType) {
        super(date, amount, organizationUnit, currency);
        this.expenseType = expenseType;
    }

    public ExpenseInfo(long id, Date date, long amount, OrganizationUnit organizationUnit, Currency currency, ExpenseType expenseType) {
        super(id, date, amount, organizationUnit, currency);
        this.expenseType = expenseType;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }


    @Override
    public String toString() {
        return "ExpenseInfo " + super.toString() +  ", " + expenseType +
                ", sum=" + getAmount();
    }
}
