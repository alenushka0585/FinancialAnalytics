package com.epam.financial_analytics.entity.abstract_classes;

import java.sql.Date;


public abstract class Report {
    private long id;
    private Date date;

    public Report() {
    }

    public Report(Date date) {
        this.date = date;
    }

    public Report(long id, Date date) {
        this.id = id;
        this.date = date;
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

    @Override
    public String toString() {
        return "id:" + id + ", date:" + date;
    }
}
