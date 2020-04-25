package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.abstract_classes.Report;

import java.sql.Date;

public class CurrencyExchangeRate extends Report {
    Currency currency;
    private double exchangeRate;

    public CurrencyExchangeRate() {
    }
    public CurrencyExchangeRate(Date date, Currency currency, double exchangeRate) {
        super(date);
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    public CurrencyExchangeRate(long id, Date date, Currency currency, double exchangeRate) {
        super(id, date);
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeRate " + super.toString() +
                ", " + currency +
                ", exchangeRate:" + exchangeRate;
    }
}
