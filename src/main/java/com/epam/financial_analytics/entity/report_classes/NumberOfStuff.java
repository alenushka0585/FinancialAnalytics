package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganization;

import java.sql.Date;

public class NumberOfStuff extends ReportWithOrganization {
    private long amount;

    public NumberOfStuff() {
    }

    public NumberOfStuff(long id, Date date, OrganizationUnit organizationUnit, long amount) {
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
        return "NumberOfStuff " + super.toString()+
                ", amount=" + amount;
    }
}
