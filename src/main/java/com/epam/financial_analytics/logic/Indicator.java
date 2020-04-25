package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import java.sql.Date;
import java.time.Period;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstants.*;

public abstract class Indicator {
    private Date presentPeriodStartDate;
    private Date presentPeriodFinishDate;
    private Date pastPeriodStartDate;
    private Date pastPeriodFinishDate;

    private Period presentPeriod;
    private Period pastPeriod;
    private int amountOfMonths;
    private int oneMonth = 1;

    private String currencyName;

    private List<CurrencyExchangeRate> presentPeriodCurrencyList;
    private List<CurrencyExchangeRate> pastPeriodCurrencyList;

    private CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();

    public Indicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        this.presentPeriodStartDate = presentPeriodStartDate;
        this.presentPeriodFinishDate = presentPeriodFinishDate;
        this.pastPeriodStartDate = pastPeriodStartDate;
        this.pastPeriodFinishDate = pastPeriodFinishDate;
        this.currencyName = currencyName;

        setAllPeriods();
    }

    public void setPeriod(){
        presentPeriod = Period.between(getPresentPeriodStartDate().toLocalDate(), getPresentPeriodFinishDate().toLocalDate());
        pastPeriod = Period.between(getPastPeriodStartDate().toLocalDate(), getPastPeriodFinishDate().toLocalDate());
    }

    public void setAmountOfMonths() {
        int present = presentPeriod.getMonths() + oneMonth;
        int past = pastPeriod.getMonths() + oneMonth;

        if (present==past) {
            amountOfMonths = pastPeriod.getMonths() + oneMonth;
        }
    }

    public Date getPresentPeriodStartDate() {
        return presentPeriodStartDate;
    }

    public Date getPresentPeriodFinishDate() {
        return presentPeriodFinishDate;
    }

    public Date getPastPeriodStartDate() {
        return pastPeriodStartDate;
    }

    public Date getPastPeriodFinishDate() {
        return pastPeriodFinishDate;
    }

    public List<CurrencyExchangeRate> getPresentPeriodCurrencyList() {
        return presentPeriodCurrencyList;
    }

    public void setPresentPeriodCurrencyList() {
        this.presentPeriodCurrencyList = currencyExchangeRateDao.getByCurrencyAndDate(currencyName, presentPeriodStartDate, presentPeriodFinishDate);
    }

    public List<CurrencyExchangeRate> getPastPeriodCurrencyList() {
        return pastPeriodCurrencyList;
    }

    public void setPastPeriodCurrencyList() {
        this.pastPeriodCurrencyList = currencyExchangeRateDao.getByCurrencyAndDate(currencyName, pastPeriodStartDate, pastPeriodFinishDate);
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public static String getCurrencyKzt() {
        return CURRENCY_KZT;
    }

    public static String getCurrencyUsd() {
        return CURRENCY_USD;
    }

    public static String getCurrencyRub() {
        return CURRENCY_RUB;
    }

    public int getAmountOfMonths() {
        return amountOfMonths;
    }

    public void setAllPeriods(){
        setPresentPeriodCurrencyList();
        setPastPeriodCurrencyList();
        setPeriod();
        setAmountOfMonths();
    }
}
