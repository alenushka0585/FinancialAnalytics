package com.epam.financial_analytics.entity.report_classes;

import java.sql.Date;
import java.util.Comparator;


public class Report {
    private long id;
    private Date date;
    private long amount;

    public Report() {
    }

    public Report(Date date) {
        this.date = date;
    }

    public Report(Date date, long amount) {
        this.date = date;
        this.amount = amount;
    }

    public Report(long id, Date date, long amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "id:" + id + ", date:" + date + ", amount:" + amount;
    }

    public static Comparator<Report> dateSort = Comparator.comparing(Report::getDate);
}
