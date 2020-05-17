package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;

import java.sql.Date;
import java.util.Comparator;

public class CurrencyExchangeRate{
    long id;
    Date date;
    Currency currency;
    double currencyExchangeRate;

    public CurrencyExchangeRate() {
    }
    public CurrencyExchangeRate(Date date, Currency currency, double currencyExchangeRate) {
        this.date = date;
        this.currency = currency;
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public CurrencyExchangeRate(long id, Date date, Currency currency, double currencyExchangeRate) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.currencyExchangeRate = currencyExchangeRate;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(double currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeRate " + super.toString()+ ", " + currency;
    }

    public static Comparator<CurrencyExchangeRate> dateSort = new Comparator<CurrencyExchangeRate>() {
        @Override
        public int compare(CurrencyExchangeRate o1, CurrencyExchangeRate o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    };
}
