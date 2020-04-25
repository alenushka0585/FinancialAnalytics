package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;

import java.sql.Date;
import java.util.List;

public interface ExpenseInfoDao extends ReportWithOrganizationDao<ExpenseInfo> {
    List<ExpenseInfo> getByExpense(String expenseType);

    List<ExpenseInfo> getByDateAndExpense(Date startDate, Date finishDate, String expenseType);

    List<ExpenseInfo> getByOrganizationUnitAndExpense(String organizationUnit, String expense);

    List<ExpenseInfo> getByDateAndOrganizationUnitAndExpense(Date startDate, Date finishDate, String organizationUnit, String expense);
}
