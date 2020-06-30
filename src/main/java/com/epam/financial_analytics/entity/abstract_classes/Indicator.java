package com.epam.financial_analytics.entity.abstract_classes;

import com.epam.financial_analytics.dao.impl.CurrencyExchangeRateDaoImpl;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;
import java.time.Period;
import java.util.List;

public abstract class Indicator {
    private Date presentPeriodStartDate;
    private final Date presentPeriodFinishDate;
    private final Date pastPeriodStartDate;
    private final Date pastPeriodFinishDate;

    private Period presentPeriod;
    private Period pastPeriod;
    private int amountOfMonths;
    private final int oneMonth = 1;

    private long presentPeriodIndicator;
    private long pastPeriodIndicator;
    private long changingOfIndicator;
    private double changingOfIndicatorInPercents;

    private final String currencyName;

    private List<CurrencyExchangeRate> presentPeriodCurrencyList;
    private List<CurrencyExchangeRate> pastPeriodCurrencyList;

    private List<Report> presentPeriodIndicatorList;
    private List<Report> pastPeriodIndicatorList;

    private final CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();

    public Indicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        this.presentPeriodStartDate = presentPeriodStartDate;
        this.presentPeriodFinishDate = presentPeriodFinishDate;
        this.pastPeriodStartDate = pastPeriodStartDate;
        this.pastPeriodFinishDate = pastPeriodFinishDate;
        this.currencyName = currencyName;

        fillAllPeriods();
    }

    public void fillPeriod(){
        presentPeriod = Period.between(getPresentPeriodStartDate().toLocalDate(), getPresentPeriodFinishDate().toLocalDate());
        pastPeriod = Period.between(getPastPeriodStartDate().toLocalDate(), getPastPeriodFinishDate().toLocalDate());
    }

    public void fillAmountOfMonths() {
        int present = presentPeriod.getMonths() + oneMonth;
        int past = pastPeriod.getMonths() + oneMonth;

        if (present==past) {
            setAmountOfMonths(pastPeriod.getMonths() + oneMonth);
        }
    }

    public void fillPresentPeriodCurrencyList() {
        setPresentPeriodCurrencyList(currencyExchangeRateDao.getByCurrencyAndDate(currencyName, presentPeriodStartDate, presentPeriodFinishDate));
        getPresentPeriodCurrencyList().sort(CurrencyExchangeRate.dateSort);
    }

    public void fillPastPeriodCurrencyList() {
        setPastPeriodCurrencyList(currencyExchangeRateDao.getByCurrencyAndDate(currencyName, pastPeriodStartDate, pastPeriodFinishDate));
        getPastPeriodCurrencyList().sort(CurrencyExchangeRate.dateSort);
    }

    public void setPresentPeriodCurrencyList(List<CurrencyExchangeRate> presentPeriodCurrencyList) {
        this.presentPeriodCurrencyList = presentPeriodCurrencyList;
    }

    public void setPastPeriodCurrencyList(List<CurrencyExchangeRate> pastPeriodCurrencyList) {
        this.pastPeriodCurrencyList = pastPeriodCurrencyList;
    }

    public void setAmountOfMonths(int amountOfMonths) {
        this.amountOfMonths = amountOfMonths;
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

    public List<CurrencyExchangeRate> getPastPeriodCurrencyList() {
        return pastPeriodCurrencyList;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public int getAmountOfMonths() {
        return amountOfMonths;
    }

    public void setPresentPeriodStartDate(Date presentPeriodStartDate) {
        this.presentPeriodStartDate = presentPeriodStartDate;
    }

    public long getPresentPeriodIndicator() {
        return presentPeriodIndicator;
    }

    public void setPresentPeriodIndicator(long presentPeriodIndicator) {
        this.presentPeriodIndicator = presentPeriodIndicator;
    }

    public long getPastPeriodIndicator() {
        return pastPeriodIndicator;
    }

    public void setPastPeriodIndicator(long pastPeriodIndicator) {
        this.pastPeriodIndicator = pastPeriodIndicator;
    }

    public long getChangingOfIndicator() {
        return changingOfIndicator;
    }

    public void setChangingOfIndicator(long changingOfIndicator) {
        this.changingOfIndicator = changingOfIndicator;
    }

    public double getChangingOfIndicatorInPercents() {
        return changingOfIndicatorInPercents;
    }

    public void setChangingOfIndicatorInPercents(double changingOfIndicatorInPercents) {
        this.changingOfIndicatorInPercents = changingOfIndicatorInPercents;
    }

    public List<Report> getPresentPeriodIndicatorList() {
        return presentPeriodIndicatorList;
    }

    public void setPresentPeriodIndicatorList(List<Report> presentPeriodIndicatorList) {
        this.presentPeriodIndicatorList = presentPeriodIndicatorList;
    }

    public List<Report> getPastPeriodIndicatorList() {
        return pastPeriodIndicatorList;
    }

    public void setPastPeriodIndicatorList(List<Report> pastPeriodIndicatorList) {
        this.pastPeriodIndicatorList = pastPeriodIndicatorList;
    }

    public void fillAllPeriods(){
        fillPresentPeriodCurrencyList();
        fillPastPeriodCurrencyList();
        fillPeriod();
        fillAmountOfMonths();
    }

    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPresentPeriodIndicatorList(), getCurrencyName(), getPresentPeriodCurrencyList()));
        setPastPeriodIndicator(IndicatorUtil.fillIndicatorSumWithCurrency(getPastPeriodIndicatorList(), getCurrencyName(), getPastPeriodCurrencyList()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }
}
