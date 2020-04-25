package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;

import java.sql.Date;


public abstract class ReportWithOrganization extends Report {
    OrganizationUnit organizationUnit;

    public ReportWithOrganization() {
    }

    public ReportWithOrganization(long id, Date date, OrganizationUnit organizationUnit) {
        super(id, date);
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
