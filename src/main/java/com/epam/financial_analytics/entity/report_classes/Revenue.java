package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganizationAndCurrency;
import com.epam.financial_analytics.logic.Util;

import java.sql.Date;

public class Revenue extends ReportWithOrganizationAndCurrency {
    private long sum;

    public Revenue() {
    }

    public Revenue(long id, Date date, OrganizationUnit organizationUnit, Currency currency, long sum) {
        super(id, date, organizationUnit, currency);
        this.sum = sum;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Revenue " + super.toString() + ", sum=" + sum;
    }
}
