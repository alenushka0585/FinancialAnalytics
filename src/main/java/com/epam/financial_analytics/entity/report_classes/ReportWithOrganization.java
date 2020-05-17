package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.Report;

import java.sql.Date;


public class ReportWithOrganization extends Report {
    OrganizationUnit organizationUnit;

    public ReportWithOrganization() {
    }

    public ReportWithOrganization(Date date, long amount, OrganizationUnit organizationUnit) {
        super(date, amount);
        this.organizationUnit = organizationUnit;
    }
    public ReportWithOrganization(long id, Date date, long amount, OrganizationUnit organizationUnit) {
        super(id, date, amount);
        this.organizationUnit = organizationUnit;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + organizationUnit;
    }
}
