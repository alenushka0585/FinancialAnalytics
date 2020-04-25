package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganization;

import java.sql.Date;

public class MetallProcessing extends ReportWithOrganization {
    private long amount;

    public MetallProcessing() {
    }

    public MetallProcessing(long id, Date date, OrganizationUnit organizationUnit, long amount) {
        super(id, date, organizationUnit);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MetallProcessing " + super.toString()+
                ", amount=" + amount;
    }
}
