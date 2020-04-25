package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;

import java.sql.Date;

public abstract class ReportWithOrganizationAndCurrency extends ReportWithOrganization {
    Currency currency;

    public ReportWithOrganizationAndCurrency() {
    }

    public ReportWithOrganizationAndCurrency(long id, Date date, OrganizationUnit organizationUnit, Currency currency) {
        super(id, date, organizationUnit);
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
