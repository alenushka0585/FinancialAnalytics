package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;

import java.sql.Date;
import java.util.List;

public interface ReportWithOrganizationDao<M extends ReportWithOrganization> extends ReportDao<M> {
    List<M> getByOrganizationUnit(String organizationUnit);

    List<M> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit);
}
