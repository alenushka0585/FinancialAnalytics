package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ExpenseInfoDaoImpl;
import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;

import java.sql.Date;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstants.*;

public class ExpenseIndicator extends Indicator{
    private ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();

    private long presentPeriodAllExpenses;
    private long pastPeriodAllExpenses;
    private long changingOfAllExpenses;
    private double changingOfAllExpensesInPercents;

    private long presentPeriodSalaryExpenses;
    private long pastPeriodSalaryExpenses;
    private long changingOfSalaryExpenses;
    private double changingOfSalaryExpensesInPercents;

    private long presentPeriodFactoryExpenses;
    private long pastPeriodFactoryExpenses;
    private long changingOfFactoryExpenses;
    private double changingOfFactoryExpensesInPercents;

    private long presentPeriodTransportExpenses;
    private long pastPeriodTransportExpenses;
    private long changingOfTransportExpenses;
    private double changingOfTransportExpensesInPercents;

    private long presentPeriodPackageExpenses;
    private long pastPeriodPackageExpenses;
    private long changingOfPackageExpenses;
    private double changingOfPackageExpensesInPercents;

    private long presentPeriodRentExpenses;
    private long pastPeriodRentExpenses;
    private long changingOfRentExpenses;
    private double changingOfRentExpensesInPercents;

    private long presentPeriodOtherExpenses;
    private long pastPeriodOtherExpenses;
    private long changingOfOtherExpenses;
    private double changingOfOtherExpensesInPercents;

    private long presentPeriodPhoneExpenses;
    private long pastPeriodPhoneExpenses;
    private long changingOfPhoneExpenses;
    private double changingOfPhoneExpensesInPercents;

    private long presentPeriodBusinessTripExpenses;
    private long pastPeriodBusinessTripExpenses;
    private long changingOfBusinessTripExpenses;
    private double changingOfBusinessTripExpensesInPercents;

    private long presentPeriodAdvertisementExpenses;
    private long pastPeriodAdvertisementExpenses;
    private long changingOfAdvertisementExpenses;
    private double changingOfAdvertisementExpensesInPercents;

    private long presentPeriodEcquiringExpenses;
    private long pastPeriodEcquiringExpenses;
    private long changingOfEcquiringExpenses;
    private double changingOfEcquiringExpensesInPercents;

    public ExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public long setExpenseSumWithOrganizationUnitPresentPeriod (String organizationUnitName, String expensType) {
        List<ExpenseInfo> expenseInfoList =
                expenseInfoDao.getByDateAndOrganizationUnitAndExpense(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName, expensType);
        long sum = 0;

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(expenseInfoList.get(i).getSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(expenseInfoList.get(i).getSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setExpenseSumWithOrganizationUnitPastPeriod (String organizationUnitName, String expensType) {
        List<ExpenseInfo> expenseInfoList =
                expenseInfoDao.getByDateAndOrganizationUnitAndExpense(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName, expensType);
        long sum = 0;

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(expenseInfoList.get(i).getSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(expenseInfoList.get(i).getSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public void setSalarySum(String organizationUnitName){
        presentPeriodSalaryExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, SALARY);
        pastPeriodSalaryExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, SALARY);
        changingOfSalaryExpenses = presentPeriodSalaryExpenses - pastPeriodSalaryExpenses;
        changingOfSalaryExpensesInPercents = Util.countPercent(presentPeriodSalaryExpenses,pastPeriodSalaryExpenses);
    }

    public void setFactorySum(String organizationUnitName){
        presentPeriodFactoryExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, FACTORY);
        pastPeriodFactoryExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, FACTORY);
        changingOfFactoryExpenses = presentPeriodFactoryExpenses - pastPeriodFactoryExpenses;
        changingOfFactoryExpensesInPercents = Util.countPercent(presentPeriodFactoryExpenses, pastPeriodFactoryExpenses);
    }

    public void setTransportSum(String organizationUnitName){
        presentPeriodTransportExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, TRANSPORT);
        pastPeriodTransportExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, TRANSPORT);
        changingOfTransportExpenses = presentPeriodTransportExpenses - pastPeriodTransportExpenses;
        changingOfTransportExpensesInPercents = Util.countPercent(presentPeriodTransportExpenses,pastPeriodTransportExpenses);
    }

    public void setPackageSum(String organizationUnitName){
        presentPeriodPackageExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, PACKAGE);
        pastPeriodPackageExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, PACKAGE);
        changingOfPackageExpenses = presentPeriodPackageExpenses - pastPeriodPackageExpenses;
        changingOfPackageExpensesInPercents = Util.countPercent(presentPeriodPackageExpenses,pastPeriodPackageExpenses);
    }

    public void setRentSum(String organizationUnitName){
        presentPeriodRentExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, RENT);
        pastPeriodRentExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, RENT);
        changingOfRentExpenses = presentPeriodRentExpenses - pastPeriodRentExpenses;
        changingOfRentExpensesInPercents = Util.countPercent(presentPeriodRentExpenses, pastPeriodRentExpenses);
    }

    public void setOtherSum(String organizationUnitName){
        presentPeriodOtherExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, OTHERS);
        pastPeriodOtherExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, OTHERS);
        changingOfOtherExpenses = presentPeriodOtherExpenses - pastPeriodOtherExpenses;
        changingOfOtherExpensesInPercents = Util.countPercent(presentPeriodOtherExpenses, pastPeriodOtherExpenses);
    }

    public void setPhoneSum(String organizationUnitName){
        presentPeriodPhoneExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, PHONE);
        pastPeriodPhoneExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, PHONE);
        changingOfPhoneExpenses = presentPeriodPhoneExpenses - pastPeriodPhoneExpenses;
        changingOfPhoneExpensesInPercents = Util.countPercent(presentPeriodPhoneExpenses, pastPeriodPhoneExpenses);
    }

    public void setBusinessTripSum(String organizationUnitName){
        presentPeriodBusinessTripExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, BUSINESS_TRIP);
        pastPeriodBusinessTripExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, BUSINESS_TRIP);
        changingOfBusinessTripExpenses = presentPeriodBusinessTripExpenses - pastPeriodBusinessTripExpenses;
        changingOfBusinessTripExpensesInPercents = Util.countPercent(presentPeriodBusinessTripExpenses,pastPeriodBusinessTripExpenses);
    }

    public void setAdvertisementSum(String organizationUnitName){
        presentPeriodAdvertisementExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, ADVERTISEMENT);
        pastPeriodAdvertisementExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, ADVERTISEMENT);
        changingOfAdvertisementExpenses = presentPeriodAdvertisementExpenses - pastPeriodAdvertisementExpenses;
        changingOfAdvertisementExpensesInPercents = Util.countPercent(presentPeriodAdvertisementExpenses,pastPeriodAdvertisementExpenses);
    }

    public void setEcquiringSum(String organizationUnitName){
        presentPeriodEcquiringExpenses = setExpenseSumWithOrganizationUnitPresentPeriod(organizationUnitName, ECQUIRING);
        pastPeriodEcquiringExpenses = setExpenseSumWithOrganizationUnitPastPeriod(organizationUnitName, ECQUIRING);
        changingOfEcquiringExpenses = presentPeriodEcquiringExpenses - pastPeriodEcquiringExpenses;
        changingOfEcquiringExpensesInPercents = Util.countPercent(presentPeriodEcquiringExpenses, pastPeriodEcquiringExpenses);
    }

    public long getPresentPeriodAllExpenses() {
        return presentPeriodAllExpenses;
    }

    public void setAllExpenses() {
        presentPeriodAllExpenses = presentPeriodSalaryExpenses + presentPeriodFactoryExpenses + presentPeriodTransportExpenses + presentPeriodPackageExpenses + presentPeriodRentExpenses +
                presentPeriodOtherExpenses + presentPeriodPhoneExpenses + presentPeriodBusinessTripExpenses + presentPeriodAdvertisementExpenses + presentPeriodEcquiringExpenses;
        pastPeriodAllExpenses = pastPeriodSalaryExpenses + pastPeriodFactoryExpenses + pastPeriodTransportExpenses + pastPeriodPackageExpenses + pastPeriodRentExpenses +
                pastPeriodOtherExpenses + pastPeriodPhoneExpenses + pastPeriodBusinessTripExpenses + pastPeriodAdvertisementExpenses + pastPeriodEcquiringExpenses;

        changingOfAllExpenses = presentPeriodAllExpenses - pastPeriodAllExpenses;
        changingOfAllExpensesInPercents = Util.countPercent(presentPeriodAllExpenses, pastPeriodAllExpenses);
    }

    public long getPastPeriodAllExpenses() {
        return pastPeriodAllExpenses;
    }


    public void setAllWithOrganizationUnit(String organizationUnitName){
        setSalarySum(organizationUnitName);
        setFactorySum(organizationUnitName);
        setTransportSum(organizationUnitName);
        setPackageSum(organizationUnitName);
        setRentSum(organizationUnitName);
        setOtherSum(organizationUnitName);
        setPhoneSum(organizationUnitName);
        setBusinessTripSum(organizationUnitName);
        setAdvertisementSum(organizationUnitName);
        setEcquiringSum(organizationUnitName);
        setAllExpenses();
    }

    public long getPresentPeriodSalaryExpenses() {
        return presentPeriodSalaryExpenses;
    }

    public long getPastPeriodSalaryExpenses() {
        return pastPeriodSalaryExpenses;
    }

    public long getChangingOfSalaryExpenses() {
        return changingOfSalaryExpenses;
    }

    public double getChangingOfSalaryExpensesInPercents() {
        return changingOfSalaryExpensesInPercents;
    }

    public long getPresentPeriodFactoryExpenses() {
        return presentPeriodFactoryExpenses;
    }

    public long getPastPeriodFactoryExpenses() {
        return pastPeriodFactoryExpenses;
    }

    public long getChangingOfFactoryExpenses() {
        return changingOfFactoryExpenses;
    }

    public double getChangingOfFactoryExpensesInPercents() {
        return changingOfFactoryExpensesInPercents;
    }

    public long getPresentPeriodTransportExpenses() {
        return presentPeriodTransportExpenses;
    }

    public long getPastPeriodTransportExpenses() {
        return pastPeriodTransportExpenses;
    }

    public long getChangingOfTransportExpenses() {
        return changingOfTransportExpenses;
    }

    public double getChangingOfTransportExpensesInPercents() {
        return changingOfTransportExpensesInPercents;
    }

    public long getPresentPeriodPackageExpenses() {
        return presentPeriodPackageExpenses;
    }

    public long getPastPeriodPackageExpenses() {
        return pastPeriodPackageExpenses;
    }

    public long getChangingOfPackageExpenses() {
        return changingOfPackageExpenses;
    }

    public double getChangingOfPackageExpensesInPercents() {
        return changingOfPackageExpensesInPercents;
    }

    public long getPresentPeriodRentExpenses() {
        return presentPeriodRentExpenses;
    }

    public long getPastPeriodRentExpenses() {
        return pastPeriodRentExpenses;
    }

    public long getChangingOfRentExpenses() {
        return changingOfRentExpenses;
    }

    public double getChangingOfRentExpensesInPercents() {
        return changingOfRentExpensesInPercents;
    }

    public long getPresentPeriodOtherExpenses() {
        return presentPeriodOtherExpenses;
    }

    public long getPastPeriodOtherExpenses() {
        return pastPeriodOtherExpenses;
    }

    public long getChangingOfOtherExpenses() {
        return changingOfOtherExpenses;
    }

    public double getChangingOfOtherExpensesInPercents() {
        return changingOfOtherExpensesInPercents;
    }

    public long getPresentPeriodPhoneExpenses() {
        return presentPeriodPhoneExpenses;
    }

    public long getPastPeriodPhoneExpenses() {
        return pastPeriodPhoneExpenses;
    }

    public long getChangingOfPhoneExpenses() {
        return changingOfPhoneExpenses;
    }

    public double getChangingOfPhoneExpensesInPercents() {
        return changingOfPhoneExpensesInPercents;
    }

    public long getPresentPeriodBusinessTripExpenses() {
        return presentPeriodBusinessTripExpenses;
    }

    public long getPastPeriodBusinessTripExpenses() {
        return pastPeriodBusinessTripExpenses;
    }

    public long getChangingOfBusinessTripExpenses() {
        return changingOfBusinessTripExpenses;
    }

    public double getChangingOfBusinessTripExpensesInPercents() {
        return changingOfBusinessTripExpensesInPercents;
    }

    public long getPresentPeriodAdvertisementExpenses() {
        return presentPeriodAdvertisementExpenses;
    }

    public long getPastPeriodAdvertisementExpenses() {
        return pastPeriodAdvertisementExpenses;
    }

    public long getChangingOfAdvertisementExpenses() {
        return changingOfAdvertisementExpenses;
    }

    public double getChangingOfAdvertisementExpensesInPercents() {
        return changingOfAdvertisementExpensesInPercents;
    }

    public long getPresentPeriodEcquiringExpenses() {
        return presentPeriodEcquiringExpenses;
    }

    public long getPastPeriodEcquiringExpenses() {
        return pastPeriodEcquiringExpenses;
    }

    public long getChangingOfEcquiringExpenses() {
        return changingOfEcquiringExpenses;
    }

    public double getChangingOfEcquiringExpensesInPercents() {
        return changingOfEcquiringExpensesInPercents;
    }

    public long getChangingOfAllExpenses() {
        return changingOfAllExpenses;
    }

    public double getChangingOfAllExpensesInPercents() {
        return changingOfAllExpensesInPercents;
    }
}
