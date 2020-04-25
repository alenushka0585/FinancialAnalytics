package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganization;

import java.sql.Date;

public class SquareMetresAndTonnsSales extends ReportWithOrganization {

    private long squareMetresAmount;
    private long tonnsAmount;

    public SquareMetresAndTonnsSales() {
    }

    public SquareMetresAndTonnsSales(long id, Date date, OrganizationUnit organizationUnit, long squareMetresAmount, long getSquareTonnsAmount) {
        super(id, date, organizationUnit);
        this.squareMetresAmount = squareMetresAmount;
        this.tonnsAmount = getSquareTonnsAmount;
    }

    public long getSquareMetresAmount() {
        return squareMetresAmount;
    }

    public void setSquareMetresAmount(long squareMetresAmount) {
        this.squareMetresAmount = squareMetresAmount;
    }

    public long getTonnsAmount() {
        return tonnsAmount;
    }

    public void setTonnsAmount(long tonnsAmount) {
        this.tonnsAmount = tonnsAmount;
    }

    @Override
    public String toString() {
        return "SquareMetresAndTonnsSales " + super.toString()+
                ", squareMetres=" + squareMetresAmount+ ", tonns=" +tonnsAmount;
    }
}
