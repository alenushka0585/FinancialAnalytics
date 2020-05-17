package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;

import java.sql.Date;

public class ReportWithOrganizationAndCurrency extends ReportWithOrganization{
    Currency currency;

    public ReportWithOrganizationAndCurrency() {
    }

    public ReportWithOrganizationAndCurrency(Date date, long amount, OrganizationUnit organizationUnit, Currency currency) {
        super(date, amount, organizationUnit);
        this.currency = currency;
    }

    public ReportWithOrganizationAndCurrency(long id, Date date, long amount, OrganizationUnit organizationUnit, Currency currency) {
        super(id, date, amount, organizationUnit);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + currency;
    }
}
