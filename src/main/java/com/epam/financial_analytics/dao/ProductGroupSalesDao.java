package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;

import java.sql.Date;
import java.util.List;

public interface ProductGroupSalesDao extends ReportWithOrganizationDao<ProductGroupSales> {
    List<ProductGroupSales> getByProductGroup(String productGroup);

    List<ProductGroupSales> getByDateAndProductGroup(Date startDate, Date finishDate, String productGroup);

    List<ProductGroupSales> getByOrganizationUnitAndProductGroup(String organizationUnit, String productGroup);

    List<ProductGroupSales> getByDateAndOrganizationUnitAndProductGroup(Date startDate, Date finishDate, String organizationUnit, String productGroup);
}
