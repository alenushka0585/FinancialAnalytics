package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.logic.expense.*;

import java.sql.Date;

public class TotalExpenseIndicator extends Indicator implements Fillable{

    private SalaryExpenseIndicator salaryExpenseIndicator;
    private FactoryExpenseIndicator factoryExpenseIndicator;
    private TransportExpenseIndicator transportExpenseIndicator;
    private PackageExpenseIndicator packageExpenseIndicator;
    private RentExpenseIndicator rentExpenseIndicator;
    private OthersExpenseIndicator othersExpenseIndicator;
    private PhoneExpenseIndicator phoneExpenseIndicator;
    private BusinessTripExpenseIndicator businessTripExpenseIndicator;
    private AdvertisementExpenseIndicator advertisementExpenseIndicator;
    private EcquaringExpenseIndicator ecquaringExpenseIndicator;

    public TotalExpenseIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        salaryExpenseIndicator = new SalaryExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        factoryExpenseIndicator = new FactoryExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        transportExpenseIndicator = new TransportExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        packageExpenseIndicator = new PackageExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        rentExpenseIndicator = new RentExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        othersExpenseIndicator= new OthersExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        phoneExpenseIndicator = new PhoneExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        businessTripExpenseIndicator = new BusinessTripExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        advertisementExpenseIndicator = new AdvertisementExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        ecquaringExpenseIndicator = new EcquaringExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        salaryExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        factoryExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        transportExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        packageExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        rentExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        othersExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        phoneExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        businessTripExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        advertisementExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        ecquaringExpenseIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);

        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        salaryExpenseIndicator.fillAllIndicator();
        factoryExpenseIndicator.fillAllIndicator();
        transportExpenseIndicator.fillAllIndicator();
        packageExpenseIndicator.fillAllIndicator();
        rentExpenseIndicator.fillAllIndicator();
        othersExpenseIndicator.fillAllIndicator();
        phoneExpenseIndicator.fillAllIndicator();
        businessTripExpenseIndicator.fillAllIndicator();
        advertisementExpenseIndicator.fillAllIndicator();
        ecquaringExpenseIndicator.fillAllIndicator();

        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(fillTotalIndicator(salaryExpenseIndicator.getPresentPeriodIndicator(), factoryExpenseIndicator.getPresentPeriodIndicator(),
                transportExpenseIndicator.getPresentPeriodIndicator(), packageExpenseIndicator.getPresentPeriodIndicator(), rentExpenseIndicator.getPresentPeriodIndicator(),
                othersExpenseIndicator.getPresentPeriodIndicator(), phoneExpenseIndicator.getPresentPeriodIndicator(), businessTripExpenseIndicator.getPresentPeriodIndicator(),
                advertisementExpenseIndicator.getPresentPeriodIndicator(), ecquaringExpenseIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(fillTotalIndicator(salaryExpenseIndicator.getPastPeriodIndicator(), factoryExpenseIndicator.getPastPeriodIndicator(),
                transportExpenseIndicator.getPastPeriodIndicator(), packageExpenseIndicator.getPastPeriodIndicator(), rentExpenseIndicator.getPastPeriodIndicator(),
                othersExpenseIndicator.getPastPeriodIndicator(), phoneExpenseIndicator.getPastPeriodIndicator(), businessTripExpenseIndicator.getPastPeriodIndicator(),
                advertisementExpenseIndicator.getPastPeriodIndicator(), ecquaringExpenseIndicator.getPastPeriodIndicator()));

        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public long fillTotalIndicator (long salaryExpense, long factoryExpense, long transportExpense, long packageExpense, long rentExpense, long othersExpense,
                                      long phoneExpense, long businessTripExpense, long advertisementExpense, long ecquaringExpense){
        long expenseIndicator = salaryExpense + factoryExpense + transportExpense + packageExpense + rentExpense + othersExpense +
                phoneExpense + businessTripExpense + advertisementExpense + ecquaringExpense;
        return expenseIndicator;
    }

    public SalaryExpenseIndicator getSalaryExpenseIndicator() {
        return salaryExpenseIndicator;
    }

    public FactoryExpenseIndicator getFactoryExpenseIndicator() {
        return factoryExpenseIndicator;
    }

    public TransportExpenseIndicator getTransportExpenseIndicator() {
        return transportExpenseIndicator;
    }

    public PackageExpenseIndicator getPackageExpenseIndicator() {
        return packageExpenseIndicator;
    }

    public RentExpenseIndicator getRentExpenseIndicator() {
        return rentExpenseIndicator;
    }

    public OthersExpenseIndicator getOthersExpenseIndicator() {
        return othersExpenseIndicator;
    }

    public PhoneExpenseIndicator getPhoneExpenseIndicator() {
        return phoneExpenseIndicator;
    }

    public BusinessTripExpenseIndicator getBusinessTripExpenseIndicator() {
        return businessTripExpenseIndicator;
    }

    public AdvertisementExpenseIndicator getAdvertisementExpenseIndicator() {
        return advertisementExpenseIndicator;
    }

    public EcquaringExpenseIndicator getEcquaringExpenseIndicator() {
        return ecquaringExpenseIndicator;
    }
}
