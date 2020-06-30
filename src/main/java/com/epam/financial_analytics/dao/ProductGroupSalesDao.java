package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;

import java.sql.Date;
import java.util.List;

public interface ProductGroupSalesDao<R extends ProductGroupSales> extends ReportDao<R> {
    List<R> getByProductGroup(String productGroup);

    List<R> getByDateAndProductGroup(Date startDate, Date finishDate, String productGroup);

    List<R> getByOrganizationUnitAndProductGroup(String organizationUnit, String productGroup);

    List<R> getByDateAndOrganizationUnitAndProductGroup(Date startDate, Date finishDate, String organizationUnit, String productGroup);
}
