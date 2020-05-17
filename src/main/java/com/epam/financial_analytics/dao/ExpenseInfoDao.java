package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;

import java.sql.Date;
import java.util.List;

public interface ExpenseInfoDao<M extends ExpenseInfo> extends ReportDao<M> {
    List<M> getByExpense(String expenseType);

    List<M> getByDateAndExpense(Date startDate, Date finishDate, String expenseType);

    List<M> getByOrganizationUnitAndExpense(String organizationUnit, String expense);

    List<M> getByDateAndOrganizationUnitAndExpense(Date startDate, Date finishDate, String organizationUnit, String expense);
}
