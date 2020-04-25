package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.report_classes.*;

import java.sql.Date;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstants.*;

public class BasicIndicator extends Indicator {
    private ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();
    private RevenueDaoImpl revenueDao = new RevenueDaoImpl();
    private SquareMetresAndTonnsSalesDaoImpl squareMetresAndTonnsSalesDao = new SquareMetresAndTonnsSalesDaoImpl();
    private MetallProcessingDaoImpl metallProcessingDao = new MetallProcessingDaoImpl();
    private ProductGroupSalesDaoImpl productGroupSalesDao = new ProductGroupSalesDaoImpl();
    private NumberOfStuffDaoImpl numberOfStuffDao = new NumberOfStuffDaoImpl();
    private LabourCostDaoImpl labourCostDao = new LabourCostDaoImpl();

    private ProductGroupIndicator productGroupIndicator;
    private ExpenseIndicator expenseIndicator;

    private long presentPeriodRevenue;
    private long pastPeriodRevenue;
    private long changingOfRevenue;
    private double changingOfRevenueInPercents;

    private long presentPeriodSquareMetresSales;
    private long pastPeriodSquareMetresSales;
    private long changingOfSquareMetresSales;
    private double changingOfSquareMetresSalesInPercents;

    private long presentPeriodTonnsSales;
    private long pastPeriodTonnsSales;
    private long changingOfTonnsSales;
    private double changingOfTonnsSalesInPercents;

    private long presentPeriodMetallProcessing;
    private long pastPeriodMetallProcessing;
    private long changingOfMetallProcessing;
    private double changingOfMetallProcessingInPercents;

    private double presentPeriodPercentOfExpenseToRevenue;
    private double pastPeriodPercentOfExpenseToRevenue;
    private double changingOfPercentOfExpenseToRevenue;

    private long presentPeriodMarginOnSquareMetre;
    private long pastPeriodMarginOnSquareMetre;
    private long changingOfMarginOnSquareMetre;
    private double changingOfMarginOnSquareMetreInPercents;

    private long presentPeriodMarginOnTonn;
    private long pastPeriodMarginOnTonn;
    private long changingOfMarginOnTonn;
    private double changingOfMarginOnTonnInPercents;

    private long presentPeriodMarginOnEmployeeinMonth;
    private long pastPeriodMarginOnEmployeeinMonth;
    private long changingOfMarginOnEmployeeinMonth;
    private double changingOfMarginOnEmployeeInPercents;

    private long presentPeriodNumberOfStuff;
    private long pastPeriodNumberOfStuff;

    private long presentPeriodLabourCost;
    private long pastPeriodLabourCost;

    private long presentPeriodLabourCostOnEmployeeInMonth;
    private long pastPeriodLabourCostOnEmployeeInMonth;
    private long changingOfLabourCostOnEmployeeInMonth;
    private double changingOfLabourCostOnEmployeeInPercents;

    private long presentPeriodLabourCostOnSquareMetre;
    private long pastPeriodLabourCostOnSquareMetre;
    private long changingOfLabourCostOnSquareMetre;
    private double changingOfLabourCostOnSquareMetreInPercents;

    private long presentPeriodLabourCostOnTonn;
    private long pastPeriodLabourCostOnTonn;
    private long changingOfLabourCostOnTonn;
    private double changingOfLabourCostOnTonnInPercents;

    public BasicIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName){
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        productGroupIndicator = new ProductGroupIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        expenseIndicator = new ExpenseIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    public void setPercentOfExpenseToRevenue(){
        presentPeriodPercentOfExpenseToRevenue = Util.countPercentOneToAnother(expenseIndicator.getPresentPeriodAllExpenses(),presentPeriodRevenue);
        pastPeriodPercentOfExpenseToRevenue = Util.countPercentOneToAnother(expenseIndicator.getPastPeriodAllExpenses(),pastPeriodRevenue);
        changingOfPercentOfExpenseToRevenue = presentPeriodPercentOfExpenseToRevenue - pastPeriodPercentOfExpenseToRevenue;
    }

    public void setMarginOnSquareMetres(){
        presentPeriodMarginOnSquareMetre = productGroupIndicator.getPresentPeriodAllMargin() / presentPeriodSquareMetresSales;
        pastPeriodMarginOnSquareMetre = productGroupIndicator.getPastPeriodAllMargin() / pastPeriodSquareMetresSales;
        changingOfMarginOnSquareMetre = presentPeriodMarginOnSquareMetre - pastPeriodMarginOnSquareMetre;
        changingOfMarginOnSquareMetreInPercents = Util.countPercent(presentPeriodMarginOnSquareMetre, pastPeriodMarginOnSquareMetre);
    }

    public void setMarginOnTonns(){
        presentPeriodMarginOnTonn = productGroupIndicator.getPresentPeriodAllMargin() / presentPeriodTonnsSales;
        pastPeriodMarginOnTonn = productGroupIndicator.getPastPeriodAllMargin() / pastPeriodTonnsSales;
        changingOfMarginOnTonn = presentPeriodMarginOnTonn - pastPeriodMarginOnTonn;
        changingOfMarginOnTonnInPercents = Util.countPercent(presentPeriodMarginOnTonn,pastPeriodMarginOnTonn);
    }

    public void setMarginOnEmployee(){
        presentPeriodMarginOnEmployeeinMonth = productGroupIndicator.getPresentPeriodAllMargin() / presentPeriodNumberOfStuff / getAmountOfMonths();
        pastPeriodMarginOnEmployeeinMonth = productGroupIndicator.getPastPeriodAllMargin() / pastPeriodNumberOfStuff / getAmountOfMonths();
        changingOfMarginOnEmployeeinMonth = presentPeriodMarginOnEmployeeinMonth - pastPeriodMarginOnEmployeeinMonth;
        changingOfMarginOnEmployeeInPercents = Util.countPercent(presentPeriodMarginOnEmployeeinMonth,pastPeriodMarginOnEmployeeinMonth);
    }

    public void setLabourCostOnEmployee(){
        presentPeriodLabourCostOnEmployeeInMonth = presentPeriodLabourCost / presentPeriodNumberOfStuff / getAmountOfMonths();
        pastPeriodLabourCostOnEmployeeInMonth = pastPeriodLabourCost / pastPeriodNumberOfStuff / getAmountOfMonths();
        changingOfLabourCostOnEmployeeInMonth = presentPeriodLabourCostOnEmployeeInMonth - pastPeriodLabourCostOnEmployeeInMonth;
        changingOfLabourCostOnEmployeeInPercents = Util.countPercent(presentPeriodLabourCostOnEmployeeInMonth,pastPeriodLabourCostOnEmployeeInMonth);
    }

    public void setLabourCostOnSquareMetres(){
        presentPeriodLabourCostOnSquareMetre = presentPeriodLabourCost / presentPeriodSquareMetresSales;
        pastPeriodLabourCostOnSquareMetre = pastPeriodLabourCost / pastPeriodSquareMetresSales;
        changingOfLabourCostOnSquareMetre = presentPeriodLabourCostOnSquareMetre - pastPeriodLabourCostOnSquareMetre;
        changingOfLabourCostOnSquareMetreInPercents = Util.countPercent(presentPeriodLabourCostOnSquareMetre,pastPeriodLabourCostOnSquareMetre);
    }

    public void setLabourCostOnTonn(){
        presentPeriodLabourCostOnTonn = presentPeriodLabourCost / presentPeriodTonnsSales;
        pastPeriodLabourCostOnTonn = pastPeriodLabourCost / pastPeriodTonnsSales;
        changingOfLabourCostOnTonn = presentPeriodLabourCostOnTonn - pastPeriodLabourCostOnTonn;
        changingOfLabourCostOnTonnInPercents = Util.countPercent(presentPeriodLabourCostOnTonn, pastPeriodLabourCostOnTonn);
    }

    public void setRevenueSum(String organizationUnitName) {
        List<Revenue> revenueListPresent = revenueDao.getByDateAndOrganizationUnit(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName);
        List<Revenue> revenueListPast = revenueDao.getByDateAndOrganizationUnit(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName);

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                presentPeriodRevenue = presentPeriodRevenue + (long)(revenueListPresent.get(i).getSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
                pastPeriodRevenue = pastPeriodRevenue + (long)(revenueListPast.get(i).getSum() * getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                presentPeriodRevenue = presentPeriodRevenue + (long)(revenueListPresent.get(i).getSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
                pastPeriodRevenue = pastPeriodRevenue + (long)(revenueListPast.get(i).getSum() / getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        changingOfRevenue = presentPeriodRevenue - pastPeriodRevenue;
        changingOfRevenueInPercents = Util.countPercent(presentPeriodRevenue,pastPeriodRevenue);
    }

    public void setSquareMetreAndTonnesSalesAmount(String organizationUnitName) {
        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesListPresent =
                squareMetresAndTonnsSalesDao.getByDateAndOrganizationUnit(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName);
        for (SquareMetresAndTonnsSales m: squareMetresAndTonnsSalesListPresent){
            presentPeriodSquareMetresSales = presentPeriodSquareMetresSales + m.getSquareMetresAmount();
            presentPeriodTonnsSales = presentPeriodTonnsSales + m.getTonnsAmount();
        }

        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesListPast =
                squareMetresAndTonnsSalesDao.getByDateAndOrganizationUnit(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName);
        for (SquareMetresAndTonnsSales m: squareMetresAndTonnsSalesListPast){
            pastPeriodSquareMetresSales = pastPeriodSquareMetresSales + m.getSquareMetresAmount();
            pastPeriodTonnsSales = pastPeriodTonnsSales + m.getTonnsAmount();
        }

        changingOfSquareMetresSales = presentPeriodSquareMetresSales - pastPeriodSquareMetresSales;
        changingOfSquareMetresSalesInPercents = Util.countPercent(presentPeriodSquareMetresSales, pastPeriodSquareMetresSales);

        changingOfTonnsSales = presentPeriodTonnsSales-pastPeriodTonnsSales;
        changingOfTonnsSalesInPercents = Util.countPercent(presentPeriodTonnsSales,pastPeriodTonnsSales);
    }

    public void setMetallProcessing(String organizationUnitName){
        List<MetallProcessing> metallProcessingListPresent =
                metallProcessingDao.getByDateAndOrganizationUnit(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName);
        for (MetallProcessing m: metallProcessingListPresent){
            presentPeriodMetallProcessing = presentPeriodMetallProcessing + m.getAmount();
        }

        List<MetallProcessing> metallProcessingListPast =
                metallProcessingDao.getByDateAndOrganizationUnit(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName);
        for (MetallProcessing m: metallProcessingListPast){
            pastPeriodMetallProcessing = pastPeriodMetallProcessing + m.getAmount();
        }

        changingOfMetallProcessing = presentPeriodMetallProcessing- pastPeriodMetallProcessing;
        changingOfMetallProcessingInPercents = Util.countPercent(presentPeriodMetallProcessing, pastPeriodMetallProcessing);
    }

    public void setNumberOfStuff(String organizationUnitName){
        List<NumberOfStuff> numberOfStuffListPresent = numberOfStuffDao.getByDateAndOrganizationUnit(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName);
        for (NumberOfStuff m: numberOfStuffListPresent){
            presentPeriodNumberOfStuff = presentPeriodNumberOfStuff + m.getAmount();
        }

        List<NumberOfStuff> numberOfStuffListPast = numberOfStuffDao.getByDateAndOrganizationUnit(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName);
        for (NumberOfStuff m: numberOfStuffListPast){
            pastPeriodNumberOfStuff = pastPeriodNumberOfStuff + m.getAmount();
        }
        presentPeriodNumberOfStuff = presentPeriodNumberOfStuff / getAmountOfMonths();
        pastPeriodNumberOfStuff = pastPeriodNumberOfStuff / getAmountOfMonths();
    }

    public void setLabourCost(String organizationUnitName){
        List<LabourCost> labourCostListPresent = labourCostDao.getByDateAndOrganizationUnit(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName);
        List<LabourCost> labourCostListListPast = labourCostDao.getByDateAndOrganizationUnit(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName);

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                presentPeriodLabourCost = presentPeriodLabourCost + (long)(labourCostListPresent.get(i).getSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
                pastPeriodLabourCost = pastPeriodLabourCost + (long)(labourCostListListPast.get(i).getSum() * getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                presentPeriodLabourCost = presentPeriodLabourCost + (long)(labourCostListPresent.get(i).getSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
                pastPeriodLabourCost = pastPeriodLabourCost + (long)(labourCostListListPast.get(i).getSum() / getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
    }

    public void setAllWithOrganizationUnit(String organizationUnitName){
        productGroupIndicator.setAllWithOrganizationUnit(organizationUnitName);
        expenseIndicator.setAllWithOrganizationUnit(organizationUnitName);
        setRevenueSum(organizationUnitName);
        setSquareMetreAndTonnesSalesAmount(organizationUnitName);
        setMetallProcessing(organizationUnitName);
        setLabourCost(organizationUnitName);
        setNumberOfStuff(organizationUnitName);
        setPercentOfExpenseToRevenue();
        setMarginOnSquareMetres();
        setMarginOnTonns();
        setMarginOnEmployee();
        setLabourCostOnEmployee();
        setLabourCostOnSquareMetres();
        setLabourCostOnTonn();
    }

    public ExpenseInfoDaoImpl getExpenseInfoDao() {
        return expenseInfoDao;
    }

    public long getPresentPeriodRevenue() {
        return presentPeriodRevenue;
    }

    public long getPastPeriodRevenue() {
        return pastPeriodRevenue;
    }

    public long getChangingOfRevenue() {
        return changingOfRevenue;
    }

    public double getChangingOfRevenueInPercents() {
        return changingOfRevenueInPercents;
    }

    public long getPresentPeriodSquareMetresSales() {
        return presentPeriodSquareMetresSales;
    }

    public long getPastPeriodSquareMetresSales() {
        return pastPeriodSquareMetresSales;
    }

    public long getChangingOfSquareMetresSales() {
        return changingOfSquareMetresSales;
    }

    public double getChangingOfSquareMetresSalesInPercents() {
        return changingOfSquareMetresSalesInPercents;
    }

    public long getPresentPeriodTonnsSales() {
        return presentPeriodTonnsSales;
    }

    public long getPastPeriodTonnsSales() {
        return pastPeriodTonnsSales;
    }

    public long getChangingOfTonnsSales() {
        return changingOfTonnsSales;
    }

    public double getChangingOfTonnsSalesInPercents() {
        return changingOfTonnsSalesInPercents;
    }

    public long getPresentPeriodMetallProcessing() {
        return presentPeriodMetallProcessing;
    }

    public long getPastPeriodMetallProcessing() {
        return pastPeriodMetallProcessing;
    }

    public long getChangingOfMetallProcessing() {
        return changingOfMetallProcessing;
    }

    public double getChangingOfMetallProcessingInPercents() {
        return changingOfMetallProcessingInPercents;
    }

    public double getPresentPeriodPercentOfExpenseToRevenue() {
        return presentPeriodPercentOfExpenseToRevenue;
    }

    public double getPastPeriodPercentOfExpenseToRevenue() {
        return pastPeriodPercentOfExpenseToRevenue;
    }

    public double getChangingOfPercentOfExpenseToRevenue() {
        return changingOfPercentOfExpenseToRevenue;
    }

    public long getPresentPeriodMarginOnSquareMetre() {
        return presentPeriodMarginOnSquareMetre;
    }

    public long getPastPeriodMarginOnSquareMetre() {
        return pastPeriodMarginOnSquareMetre;
    }

    public long getChangingOfMarginOnSquareMetre() {
        return changingOfMarginOnSquareMetre;
    }

    public double getChangingOfMarginOnSquareMetreInPercents() {
        return changingOfMarginOnSquareMetreInPercents;
    }

    public long getPresentPeriodMarginOnTonn() {
        return presentPeriodMarginOnTonn;
    }

    public long getPastPeriodMarginOnTonn() {
        return pastPeriodMarginOnTonn;
    }

    public long getChangingOfMarginOnTonn() {
        return changingOfMarginOnTonn;
    }

    public double getChangingOfMarginOnTonnInPercents() {
        return changingOfMarginOnTonnInPercents;
    }

    public long getPresentPeriodMarginOnEmployeeinMonth() {
        return presentPeriodMarginOnEmployeeinMonth;
    }

    public long getPastPeriodMarginOnEmployeeinMonth() {
        return pastPeriodMarginOnEmployeeinMonth;
    }

    public long getChangingOfMarginOnEmployeeinMonth() {
        return changingOfMarginOnEmployeeinMonth;
    }

    public double getChangingOfMarginOnEmployeeInPercents() {
        return changingOfMarginOnEmployeeInPercents;
    }

    public long getPresentPeriodNumberOfStuff() {
        return presentPeriodNumberOfStuff;
    }

    public long getPastPeriodNumberOfStuff() {
        return pastPeriodNumberOfStuff;
    }

    public long getPresentPeriodLabourCost() {
        return presentPeriodLabourCost;
    }

    public long getPastPeriodLabourCost() {
        return pastPeriodLabourCost;
    }

    public long getPresentPeriodLabourCostOnEmployeeInMonth() {
        return presentPeriodLabourCostOnEmployeeInMonth;
    }

    public long getPastPeriodLabourCostOnEmployeeInMonth() {
        return pastPeriodLabourCostOnEmployeeInMonth;
    }

    public long getChangingOfLabourCostOnEmployeeInMonth() {
        return changingOfLabourCostOnEmployeeInMonth;
    }

    public double getChangingOfLabourCostOnEmployeeInPercents() {
        return changingOfLabourCostOnEmployeeInPercents;
    }

    public long getPresentPeriodLabourCostOnSquareMetre() {
        return presentPeriodLabourCostOnSquareMetre;
    }

    public long getPastPeriodLabourCostOnSquareMetre() {
        return pastPeriodLabourCostOnSquareMetre;
    }

    public long getChangingOfLabourCostOnSquareMetre() {
        return changingOfLabourCostOnSquareMetre;
    }

    public double getChangingOfLabourCostOnSquareMetreInPercents() {
        return changingOfLabourCostOnSquareMetreInPercents;
    }

    public long getPresentPeriodLabourCostOnTonn() {
        return presentPeriodLabourCostOnTonn;
    }

    public long getPastPeriodLabourCostOnTonn() {
        return pastPeriodLabourCostOnTonn;
    }

    public long getChangingOfLabourCostOnTonn() {
        return changingOfLabourCostOnTonn;
    }

    public double getChangingOfLabourCostOnTonnInPercents() {
        return changingOfLabourCostOnTonnInPercents;
    }

    public ProductGroupIndicator getProductGroupIndicator() {
        return productGroupIndicator;
    }

    public ExpenseIndicator getExpenseIndicator() {
        return expenseIndicator;
    }
}
