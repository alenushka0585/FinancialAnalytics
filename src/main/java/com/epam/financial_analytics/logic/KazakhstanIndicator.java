package com.epam.financial_analytics.logic;

import java.sql.Date;

import static com.epam.financial_analytics.logic.LogicConstants.*;

public class KazakhstanIndicator{

    private BasicIndicator basicIndicatorKaraganda;
    private BasicIndicator basicIndicatorAlmaty;
    private BasicIndicator basicIndicatorAtyrau;
    private BasicIndicator basicIndicatorAstana;
    private BasicIndicator basicIndicatorAktobe;
    private BasicIndicator basicIndicatorOskemen;
    private BasicIndicator basicIndicatorShymkent;

    private long presentPeriodNumberOfStuff;
    private long pastPeriodNumberOfStuff;

    private long presentPeriodLabourCost;
    private long pastPeriodLabourCost;

    private long presentPeriodSquareMetresSales;
    private long pastPeriodSquareMetresSales;
    private long changingOfSquareMetresSales;
    private double changingOfSquareMetresSalesInPercents;

    private long presentPeriodTonnsSales;
    private long pastPeriodTonnsSales;
    private long changingOfTonnsSales;
    private double changingOfTonnsSalesInPercents;

    private long presentPeriodOVPSales;
    private long pastPeriodOVPSales;
    private long changingOfOVPSales;
    private double changingOfOVPSalesInPercents;
    private long presentPeriodOVPMargin;
    private long pastPeriodOVPMargin;
    private long changingOfOVPMargin;
    private double changingOfOVPMarginInPercents;
    private long presentPeriodOVPValueAddedTax;
    private long pastPeriodOVPValueAddedTax;
    private long changingOfOVPValueAddedTax;
    private double changingOfOVPValueAddedTaxInPercents;
    private double presentPeriodOVPProfitability;
    private double pastPeriodOVPProfitability;
    private double changingOfOVPProfitability;

    private long presentPeriodTSPSales;
    private long pastPeriodTSPSales;
    private long changingOfTSPSales;
    private double changingOfTSPSalesInPercents;
    private long presentPeriodTSPMargin;
    private long pastPeriodTSPMargin;
    private long changingOfTSPMargin;
    private double changingOfTSPMarginInPercents;
    private long presentPeriodTSPValueAddedTax;
    private long pastPeriodTSPValueAddedTax;
    private long changingOfTSPValueAddedTax;
    private double changingOfTSPValueAddedTaxInPercents;
    private double presentPeriodTSPProfitability;
    private double pastPeriodTSPProfitability;
    private double changingOfTSPProfitability;

    private long presentPeriodVSSales;
    private long pastPeriodVSSales;
    private long changingOfVSSales;
    private double changingOfVSSalesInPercents;
    private long presentPeriodVSMargin;
    private long pastPeriodVSMargin;
    private long changingOfVSMargin;
    private double changingOfVSMarginInPercents;
    private long presentPeriodVSValueAddedTax;
    private long pastPeriodVSValueAddedTax;
    private long changingOfVSValueAddedTax;
    private double changingOfVSValueAddedTaxInPercents;
    private double presentPeriodVSProfitability;
    private double pastPeriodVSProfitability;
    private double changingOfVSProfitability;

    private long presentPeriodSEOSales;
    private long pastPeriodSEOSales;
    private long changingOfSEOSales;
    private double changingOfSEOSalesInPercents;
    private long presentPeriodSEOMargin;
    private long pastPeriodSEOMargin;
    private long changingOfSEOMargin;
    private double changingOfSEOMarginInPercents;
    private long presentPeriodSEOValueAddedTax;
    private long pastPeriodSEOValueAddedTax;
    private long changingOfSEOValueAddedTax;
    private double changingOfSEOValueAddedTaxInPercents;
    private double presentPeriodSEOProfitability;
    private double pastPeriodSEOProfitability;
    private double changingOfSEOProfitability;

    private long presentPeriodENKSales;
    private long pastPeriodENKSales;
    private long changingOfENKSales;
    private double changingOfENKSalesInPercents;
    private long presentPeriodENKMargin;
    private long pastPeriodENKMargin;
    private long changingOfENKMargin;
    private double changingOfENKMarginInPercents;
    private long presentPeriodENKValueAddedTax;
    private long pastPeriodENKValueAddedTax;
    private long changingOfENKValueAddedTax;
    private double changingOfENKValueAddedTaxInPercents;
    private double presentPeriodENKProfitability;
    private double pastPeriodENKProfitability;
    private double changingOfENKProfitability;

    private long presentPeriodEBKSales;
    private long pastPeriodEBKSales;
    private long changingOfEBKSales;
    private double changingOfEBKSalesInPercents;
    private long presentPeriodEBKMargin;
    private long pastPeriodEBKMargin;
    private long changingOfEBKMargin;
    private double changingOfEBKMarginInPercents;
    private long presentPeriodEBKValueAddedTax;
    private long pastPeriodEBKValueAddedTax;
    private long changingOfEBKValueAddedTax;
    private double changingOfEBKValueAddedTaxInPercents;
    private double presentPeriodEBKProfitability;
    private double pastPeriodEBKProfitability;
    private double changingOfEBKProfitability;

    private long presentPeriodSPPSSales;
    private long pastPeriodSPPSSales;
    private long changingOfSPPSSales;
    private double changingOfSPPSSalesInPercents;
    private long presentPeriodSPPSMargin;
    private long pastPeriodSPPSMargin;
    private long changingOfSPPSMargin;
    private double changingOfSPPSMarginInPercents;
    private long presentPeriodSPPSValueAddedTax;
    private long pastPeriodSPPSValueAddedTax;
    private long changingOfSPPSValueAddedTax;
    private double changingOfSPPSValueAddedTaxInPercents;
    private double presentPeriodSPPSProfitability;
    private double pastPeriodSPPSProfitability;
    private double changingOfSPPSProfitability;

    private long presentPeriodFKSales;
    private long pastPeriodFKSales;
    private long changingOfFKSales;
    private double changingOfFKSalesInPercents;
    private long presentPeriodFKMargin;
    private long pastPeriodFKMargin;
    private long changingOfFKMargin;
    private double changingOfFKMarginInPercents;
    private long presentPeriodFKValueAddedTax;
    private long pastPeriodFKValueAddedTax;
    private long changingOfFKValueAddedTax;
    private double changingOfFKValueAddedTaxInPercents;
    private double presentPeriodFKProfitability;
    private double pastPeriodFKProfitability;
    private double changingOfFKProfitability;

    private long presentPeriodOthersSales;
    private long pastPeriodOthersSales;
    private long changingOfOthersSales;
    private double changingOfOthersSalesInPercents;
    private long presentPeriodOthersMargin;
    private long pastPeriodOthersMargin;
    private long changingOfOthersMargin;
    private double changingOfOthersMarginInPercents;
    private long presentPeriodOthersValueAddedTax;
    private long pastPeriodOthersValueAddedTax;
    private long changingOfOthersValueAddedTax;
    private double changingOfOthersValueAddedTaxInPercents;
    private double presentPeriodOthersProfitability;
    private double pastPeriodOthersProfitability;
    private double changingOfOthersProfitability;

    private long presentPeriodGoodsSales;
    private long pastPeriodGoodsSales;
    private long changingOfGoodsSales;
    private double changingOfGoodsSalesInPercents;
    private long presentPeriodGoodsMargin;
    private long pastPeriodGoodsMargin;
    private long changingOfGoodsMargin;
    private double changingOfGoodsMarginInPercents;
    private long presentPeriodGoodsValueAddedTax;
    private long pastPeriodGoodsValueAddedTax;
    private long changingOfGoodsValueAddedTax;
    private double changingOfGoodsValueAddedTaxInPercents;
    private double presentPeriodGoodsProfitability;
    private double pastPeriodGoodsProfitability;
    private double changingOfGoodsProfitability;

    private long presentPeriodProductionSales;
    private long pastPeriodProductionSales;
    private long changingOfProductionSales;
    private double changingOfProductionSalesInPercents;
    private long presentPeriodProductionMargin;
    private long pastPeriodProductionMargin;
    private long changingOfProductionMargin;
    private double changingOfProductionMarginInPercents;
    private long presentPeriodProductionValueAddedTax;
    private long pastPeriodProductionValueAddedTax;
    private long changingOfProductionValueAddedTax;
    private double changingOfProductionValueAddedTaxInPercents;
    private double presentPeriodProductionProfitability;
    private double pastPeriodProductionProfitability;
    private double changingOfProductionProfitability;

    private long presentPeriodAllSales;
    private long pastPeriodAllSales;
    private long changingOfAllSales;
    private double changingOfAllSalesInPercents;
    private long presentPeriodAllMargin;
    private long pastPeriodAllMargin;
    private long changingOfAllMargin;
    private double changingOfAllMarginInPercents;
    private long presentPeriodAllValueAddedTax;
    private long pastPeriodAllValueAddedTax;
    private long changingOfAllValueAddedTax;
    private double changingOfAllValueAddedTaxInPercents;
    private double presentPeriodAllProfitability;
    private double pastPeriodAllProfitability;
    private double changingOfAllProfitability;

    private long presentPeriodRevenue;
    private long pastPeriodRevenue;
    private long changingOfRevenue;
    private double changingOfRevenueInPercents;

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

    private long presentPeriodLabourCostOnEmployeeInMonth;
    private long pastPeriodLabourCostOnEmployeeInMonth;
    private long changingOfLabourCostOnEmployeeInMonth;
    private double changingOfLabourCostOnEmployeeInPercents;

    private long presentPeriodLabourCostOnSquareMetre;
    private long pastPeriodLabourCostOnSquareMetre;
    private long changingOfLabourCostOnSquareMetre;
    private double changingOfLabourCostOnSquareMetreInPercents;

    private double presentPeriodLabourCostOnTonn;
    private double pastPeriodLabourCostOnTonn;
    private double changingOfLabourCostOnTonn;
    private double changingOfLabourCostOnTonnInPercents;

    public KazakhstanIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        basicIndicatorKaraganda = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorAlmaty = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorAtyrau = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorAstana = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorAktobe = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorOskemen = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        basicIndicatorShymkent = new BasicIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);

        basicIndicatorKaraganda.setAllWithOrganizationUnit(KARAGANDA);
        basicIndicatorAlmaty.setAllWithOrganizationUnit(ALMATY);
        basicIndicatorAtyrau.setAllWithOrganizationUnit(ATYRAU);
        basicIndicatorAstana.setAllWithOrganizationUnit(ASTANA);
        basicIndicatorAktobe.setAllWithOrganizationUnit(AKTOBE);
        basicIndicatorOskemen.setAllWithOrganizationUnit(OSKEMEN);
        basicIndicatorShymkent.setAllWithOrganizationUnit(SHYMKENT);
    }

    public void setNumberOfStuff() {
        presentPeriodNumberOfStuff = basicIndicatorKaraganda.getPresentPeriodNumberOfStuff() + basicIndicatorAlmaty.getPresentPeriodNumberOfStuff() +
                basicIndicatorAtyrau.getPresentPeriodNumberOfStuff() + basicIndicatorAstana.getPresentPeriodNumberOfStuff() + basicIndicatorAktobe.getPresentPeriodNumberOfStuff() +
                basicIndicatorOskemen.getPresentPeriodNumberOfStuff() + basicIndicatorShymkent.getPresentPeriodNumberOfStuff();

        pastPeriodNumberOfStuff = basicIndicatorKaraganda.getPastPeriodNumberOfStuff() + basicIndicatorAlmaty.getPastPeriodNumberOfStuff() +
                basicIndicatorAtyrau.getPastPeriodNumberOfStuff() + basicIndicatorAstana.getPastPeriodNumberOfStuff() + basicIndicatorAktobe.getPastPeriodNumberOfStuff() +
                basicIndicatorOskemen.getPastPeriodNumberOfStuff() + basicIndicatorShymkent.getPastPeriodNumberOfStuff();
    }

    public void setLabourCost() {
        presentPeriodLabourCost = basicIndicatorKaraganda.getPresentPeriodLabourCost() + basicIndicatorAlmaty.getPresentPeriodLabourCost() +
                basicIndicatorAtyrau.getPresentPeriodLabourCost() + basicIndicatorAstana.getPresentPeriodLabourCost() + basicIndicatorAktobe.getPresentPeriodLabourCost() +
                basicIndicatorOskemen.getPresentPeriodLabourCost() + basicIndicatorShymkent.getPresentPeriodLabourCost();

        pastPeriodLabourCost = basicIndicatorKaraganda.getPastPeriodLabourCost() + basicIndicatorAlmaty.getPastPeriodLabourCost() +
                basicIndicatorAtyrau.getPastPeriodLabourCost() + basicIndicatorAstana.getPastPeriodLabourCost() + basicIndicatorAktobe.getPastPeriodLabourCost() +
                basicIndicatorOskemen.getPastPeriodLabourCost() + basicIndicatorShymkent.getPastPeriodLabourCost();
    }

    public void setSquareMetreAndTonnesSalesAmount() {
        presentPeriodSquareMetresSales = basicIndicatorKaraganda.getPresentPeriodSquareMetresSales() + basicIndicatorAlmaty.getPresentPeriodSquareMetresSales() +
                basicIndicatorAtyrau.getPresentPeriodSquareMetresSales() + basicIndicatorAstana.getPresentPeriodSquareMetresSales() + basicIndicatorAktobe.getPresentPeriodSquareMetresSales() +
                basicIndicatorOskemen.getPresentPeriodSquareMetresSales() + basicIndicatorShymkent.getPresentPeriodSquareMetresSales();

        pastPeriodSquareMetresSales = basicIndicatorKaraganda.getPastPeriodSquareMetresSales() + basicIndicatorAlmaty.getPastPeriodSquareMetresSales() +
                basicIndicatorAtyrau.getPastPeriodSquareMetresSales() + basicIndicatorAstana.getPastPeriodSquareMetresSales() + basicIndicatorAktobe.getPastPeriodSquareMetresSales() +
                basicIndicatorOskemen.getPastPeriodSquareMetresSales() + basicIndicatorShymkent.getPastPeriodSquareMetresSales();

        changingOfSquareMetresSales = presentPeriodSquareMetresSales - pastPeriodSquareMetresSales;
        changingOfSquareMetresSalesInPercents = (presentPeriodSquareMetresSales * HUNDRED_PERCENTS / pastPeriodSquareMetresSales) - HUNDRED_PERCENTS;

        presentPeriodTonnsSales = basicIndicatorKaraganda.getPresentPeriodTonnsSales() + basicIndicatorAlmaty.getPresentPeriodTonnsSales() +
                basicIndicatorAtyrau.getPresentPeriodTonnsSales() + basicIndicatorAstana.getPresentPeriodTonnsSales() + basicIndicatorAktobe.getPresentPeriodTonnsSales() +
                basicIndicatorOskemen.getPresentPeriodTonnsSales() + basicIndicatorShymkent.getPresentPeriodTonnsSales();

        pastPeriodTonnsSales = basicIndicatorKaraganda.getPastPeriodTonnsSales() + basicIndicatorAlmaty.getPastPeriodTonnsSales() +
                basicIndicatorAtyrau.getPastPeriodTonnsSales() + basicIndicatorAstana.getPastPeriodTonnsSales() + basicIndicatorAktobe.getPastPeriodTonnsSales() +
                basicIndicatorOskemen.getPastPeriodTonnsSales() + basicIndicatorShymkent.getPastPeriodTonnsSales();

        changingOfTonnsSales = presentPeriodTonnsSales - pastPeriodTonnsSales;
        changingOfTonnsSalesInPercents = (presentPeriodTonnsSales * HUNDRED_PERCENTS / pastPeriodTonnsSales) - HUNDRED_PERCENTS;
    }

    public void setGoodsSalesSum() {
        presentPeriodGoodsSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodGoodsSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodGoodsSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodGoodsSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodGoodsSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodGoodsSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodGoodsSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodGoodsSales();
        pastPeriodGoodsSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodGoodsSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodGoodsSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodGoodsSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodGoodsSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodGoodsSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodGoodsSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodGoodsSales();
        changingOfGoodsSales = presentPeriodGoodsSales - pastPeriodGoodsSales;
        changingOfGoodsSalesInPercents = (presentPeriodGoodsSales * HUNDRED_PERCENTS / pastPeriodGoodsSales) - HUNDRED_PERCENTS;

        presentPeriodGoodsMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodGoodsMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodGoodsMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodGoodsMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodGoodsMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodGoodsMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodGoodsMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodGoodsMargin();
        pastPeriodGoodsMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodGoodsMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodGoodsMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodGoodsMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodGoodsMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodGoodsMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodGoodsMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodGoodsMargin();
        changingOfGoodsMargin = presentPeriodGoodsMargin - pastPeriodGoodsMargin;
        changingOfGoodsMarginInPercents = (presentPeriodGoodsMargin * HUNDRED_PERCENTS / pastPeriodGoodsMargin) - HUNDRED_PERCENTS;

        presentPeriodGoodsValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodGoodsValueAddedTax();
        pastPeriodGoodsValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodGoodsValueAddedTax();
        changingOfGoodsValueAddedTax = presentPeriodGoodsValueAddedTax - pastPeriodGoodsValueAddedTax;
        changingOfGoodsValueAddedTaxInPercents = (presentPeriodGoodsValueAddedTax * HUNDRED_PERCENTS / pastPeriodGoodsValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodGoodsSales != 0) {
            presentPeriodGoodsProfitability = (double)presentPeriodGoodsMargin / (double)(presentPeriodGoodsSales - presentPeriodGoodsValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodGoodsProfitability = 0;
        }
        if(pastPeriodGoodsSales != 0) {
            pastPeriodGoodsProfitability = (double)pastPeriodGoodsMargin / (double)(pastPeriodGoodsSales - pastPeriodGoodsValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodGoodsProfitability = 0;
        }
        changingOfGoodsProfitability = presentPeriodGoodsProfitability - pastPeriodGoodsProfitability;
    }

    public void setProductionSalesSum() {
        presentPeriodProductionSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodProductionSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodProductionSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodProductionSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodProductionSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodProductionSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodProductionSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodProductionSales();
        pastPeriodProductionSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodProductionSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodProductionSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodProductionSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodProductionSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodProductionSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodProductionSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodProductionSales();
        changingOfProductionSales = presentPeriodProductionSales - pastPeriodProductionSales;
        changingOfProductionSalesInPercents = (presentPeriodProductionSales * HUNDRED_PERCENTS / pastPeriodProductionSales) - HUNDRED_PERCENTS;

        presentPeriodProductionMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodProductionMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodProductionMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodProductionMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodProductionMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodProductionMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodProductionMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodProductionMargin();
        pastPeriodProductionMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodProductionMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodProductionMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodProductionMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodProductionMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodProductionMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodProductionMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodProductionMargin();
        changingOfProductionMargin = presentPeriodProductionMargin - pastPeriodProductionMargin;
        changingOfProductionMarginInPercents = (presentPeriodProductionMargin * HUNDRED_PERCENTS / pastPeriodProductionMargin) - HUNDRED_PERCENTS;

        presentPeriodProductionValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodProductionValueAddedTax();
        pastPeriodProductionValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodProductionValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodProductionValueAddedTax();
        changingOfProductionValueAddedTax = presentPeriodProductionValueAddedTax - pastPeriodProductionValueAddedTax;
        changingOfProductionValueAddedTaxInPercents = (presentPeriodProductionValueAddedTax * HUNDRED_PERCENTS / pastPeriodProductionValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodProductionSales != 0) {
            presentPeriodProductionProfitability = (double)presentPeriodProductionMargin / (double)(presentPeriodProductionSales - presentPeriodProductionValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodProductionProfitability = 0;
        }
        if(pastPeriodProductionSales != 0) {
            pastPeriodProductionProfitability = (double)pastPeriodProductionMargin / (double)(pastPeriodProductionSales - pastPeriodProductionValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodProductionProfitability = 0;
        }
        changingOfProductionProfitability = presentPeriodProductionProfitability - pastPeriodProductionProfitability;
    }

    public void setAllSalesSum() {
        presentPeriodAllSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodAllSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodAllSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodAllSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodAllSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodAllSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodAllSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodAllSales();
        pastPeriodAllSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodAllSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodAllSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodAllSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodAllSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodAllSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodAllSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodAllSales();
        changingOfAllSales = presentPeriodAllSales - pastPeriodAllSales;
        changingOfAllSalesInPercents = (presentPeriodAllSales * HUNDRED_PERCENTS / pastPeriodAllSales) - HUNDRED_PERCENTS;

        presentPeriodAllMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodAllMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodAllMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodAllMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodAllMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodAllMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodAllMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodAllMargin();
        pastPeriodAllMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodAllMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodAllMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodAllMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodAllMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodAllMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodAllMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodAllMargin();
        changingOfAllMargin = presentPeriodAllMargin - pastPeriodAllMargin;
        changingOfAllMarginInPercents = (presentPeriodAllMargin * HUNDRED_PERCENTS / pastPeriodAllMargin) - HUNDRED_PERCENTS;

        presentPeriodAllValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodAllValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodAllValueAddedTax();
        pastPeriodAllValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodAllValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodAllValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodAllValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodAllValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodAllValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodAllValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodAllValueAddedTax();
        changingOfAllValueAddedTax = presentPeriodAllValueAddedTax - pastPeriodAllValueAddedTax;
        changingOfAllValueAddedTaxInPercents = (presentPeriodAllValueAddedTax * HUNDRED_PERCENTS / pastPeriodAllValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodAllSales != 0) {
            presentPeriodAllProfitability = (double)presentPeriodAllMargin / (double)(presentPeriodAllSales - presentPeriodAllValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodAllProfitability = 0;
        }
        if(pastPeriodAllSales != 0) {
            pastPeriodAllProfitability = (double)pastPeriodAllMargin / (double)(pastPeriodAllSales - pastPeriodAllValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodAllProfitability = 0;
        }
        changingOfAllProfitability = presentPeriodAllProfitability - pastPeriodAllProfitability;
    }

    public void setOVPSalesSum() {
        presentPeriodOVPSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOVPSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOVPSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOVPSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOVPSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodOVPSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodOVPSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOVPSales();
        pastPeriodOVPSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOVPSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOVPSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOVPSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOVPSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOVPSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOVPSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOVPSales();
        changingOfOVPSales = presentPeriodOVPSales - pastPeriodOVPSales;
        changingOfOVPSalesInPercents = (presentPeriodOVPSales * HUNDRED_PERCENTS / pastPeriodOVPSales) - HUNDRED_PERCENTS;

        presentPeriodOVPMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOVPMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOVPMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOVPMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOVPMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodOVPMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodOVPMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOVPMargin();
        pastPeriodOVPMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOVPMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOVPMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOVPMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOVPMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOVPMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOVPMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOVPMargin();
        changingOfOVPMargin = presentPeriodOVPMargin - pastPeriodOVPMargin;
        changingOfOVPMarginInPercents = (presentPeriodOVPMargin * HUNDRED_PERCENTS / pastPeriodOVPMargin) - HUNDRED_PERCENTS;

        presentPeriodOVPValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOVPValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOVPValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOVPValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOVPValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOVPValueAddedTax();
        pastPeriodOVPValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOVPValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOVPValueAddedTax();
        changingOfOVPValueAddedTax = presentPeriodOVPValueAddedTax - pastPeriodOVPValueAddedTax;
        changingOfOVPValueAddedTaxInPercents = (presentPeriodOVPValueAddedTax * HUNDRED_PERCENTS / pastPeriodOVPValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodOVPSales != 0) {
            presentPeriodOVPProfitability = (double)presentPeriodOVPMargin / (double)(presentPeriodOVPSales - presentPeriodOVPValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodOVPProfitability = 0;
        }
        if(pastPeriodOVPSales != 0) {
            pastPeriodOVPProfitability = (double)pastPeriodOVPMargin / (double)(pastPeriodOVPSales - pastPeriodOVPValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodOVPProfitability = 0;
        }
        changingOfOVPProfitability = presentPeriodOVPProfitability - pastPeriodOVPProfitability;
    }

    public void setTSPSalesSum() {
        presentPeriodTSPSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodTSPSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodTSPSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodTSPSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodTSPSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodTSPSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodTSPSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodTSPSales();
        pastPeriodTSPSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodTSPSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodTSPSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodTSPSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodTSPSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodTSPSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodTSPSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodTSPSales();
        changingOfTSPSales = presentPeriodTSPSales - pastPeriodTSPSales;
        changingOfTSPSalesInPercents = (presentPeriodTSPSales * HUNDRED_PERCENTS / pastPeriodTSPSales) - HUNDRED_PERCENTS;

        presentPeriodTSPMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodTSPMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodTSPMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodTSPMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodTSPMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodTSPMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodTSPMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodTSPMargin();
        pastPeriodTSPMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodTSPMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodTSPMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodTSPMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodTSPMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodTSPMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodTSPMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodTSPMargin();
        changingOfTSPMargin = presentPeriodTSPMargin - pastPeriodTSPMargin;
        changingOfTSPMarginInPercents = (presentPeriodTSPMargin * HUNDRED_PERCENTS / pastPeriodTSPMargin) - HUNDRED_PERCENTS;

        presentPeriodTSPValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodTSPValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodTSPValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodTSPValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodTSPValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodTSPValueAddedTax();
        pastPeriodTSPValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodTSPValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodTSPValueAddedTax();
        changingOfTSPValueAddedTax = presentPeriodTSPValueAddedTax - pastPeriodTSPValueAddedTax;
        changingOfTSPValueAddedTaxInPercents = (presentPeriodTSPValueAddedTax * HUNDRED_PERCENTS / pastPeriodTSPValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodTSPSales != 0) {
            presentPeriodTSPProfitability = (double)presentPeriodTSPMargin / (double)(presentPeriodTSPSales - presentPeriodTSPValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodTSPProfitability = 0;
        }
        if(pastPeriodTSPSales != 0) {
            pastPeriodTSPProfitability = (double)pastPeriodTSPMargin / (double)(pastPeriodTSPSales - pastPeriodTSPValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodTSPProfitability = 0;
        }
        changingOfTSPProfitability = presentPeriodTSPProfitability - pastPeriodTSPProfitability;
    }

    public void setVSSalesSum() {
        presentPeriodVSSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodVSSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodVSSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodVSSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodVSSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodVSSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodVSSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodVSSales();
        pastPeriodVSSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodVSSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodVSSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodVSSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodVSSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodVSSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodVSSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodVSSales();
        changingOfVSSales = presentPeriodVSSales - pastPeriodVSSales;
        changingOfVSSalesInPercents = (presentPeriodVSSales * HUNDRED_PERCENTS / pastPeriodVSSales) - HUNDRED_PERCENTS;

        presentPeriodVSMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodVSMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodVSMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodVSMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodVSMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodVSMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodVSMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodVSMargin();
        pastPeriodVSMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodVSMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodVSMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodVSMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodVSMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodVSMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodVSMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodVSMargin();
        changingOfVSMargin = presentPeriodVSMargin - pastPeriodVSMargin;
        changingOfVSMarginInPercents = (presentPeriodVSMargin * HUNDRED_PERCENTS / pastPeriodVSMargin) - HUNDRED_PERCENTS;

        presentPeriodVSValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodVSValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodVSValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodVSValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodVSValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodVSValueAddedTax();
        pastPeriodVSValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodVSValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodVSValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodVSValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodVSValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodVSValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodVSValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodVSValueAddedTax();
        changingOfVSValueAddedTax = presentPeriodVSValueAddedTax - pastPeriodVSValueAddedTax;
        changingOfVSValueAddedTaxInPercents = (presentPeriodVSValueAddedTax * HUNDRED_PERCENTS / pastPeriodVSValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodVSSales != 0) {
            presentPeriodVSProfitability = (double)presentPeriodVSMargin / (double)(presentPeriodVSSales - presentPeriodVSValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodVSProfitability = 0;
        }
        if(pastPeriodVSSales != 0) {
            pastPeriodVSProfitability = (double)pastPeriodVSMargin / (double)(pastPeriodVSSales - pastPeriodVSValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodVSProfitability = 0;
        }
        changingOfVSProfitability = presentPeriodVSProfitability - pastPeriodVSProfitability;
    }

    public void setSEOSalesSum() {
        presentPeriodSEOSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSEOSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSEOSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSEOSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSEOSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodSEOSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodSEOSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSEOSales();
        pastPeriodSEOSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSEOSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSEOSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSEOSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSEOSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSEOSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSEOSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSEOSales();
        changingOfSEOSales = presentPeriodSEOSales - pastPeriodSEOSales;
        changingOfSEOSalesInPercents = (presentPeriodSEOSales * HUNDRED_PERCENTS / pastPeriodSEOSales) - HUNDRED_PERCENTS;

        presentPeriodSEOMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSEOMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSEOMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSEOMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSEOMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodSEOMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodSEOMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSEOMargin();
        pastPeriodSEOMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSEOMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSEOMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSEOMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSEOMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSEOMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSEOMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSEOMargin();
        changingOfSEOMargin = presentPeriodSEOMargin - pastPeriodSEOMargin;
        changingOfSEOMarginInPercents = (presentPeriodSEOMargin * HUNDRED_PERCENTS / pastPeriodSEOMargin) - HUNDRED_PERCENTS;

        presentPeriodSEOValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSEOValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSEOValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSEOValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSEOValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSEOValueAddedTax();
        pastPeriodSEOValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSEOValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSEOValueAddedTax();
        changingOfSEOValueAddedTax = presentPeriodSEOValueAddedTax - pastPeriodSEOValueAddedTax;
        changingOfSEOValueAddedTaxInPercents = (presentPeriodSEOValueAddedTax * HUNDRED_PERCENTS / pastPeriodSEOValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodSEOSales != 0) {
            presentPeriodSEOProfitability = (double)presentPeriodSEOMargin / (double)(presentPeriodSEOSales - presentPeriodSEOValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodSEOProfitability = 0;
        }
        if(pastPeriodSEOSales != 0) {
            pastPeriodSEOProfitability = (double)pastPeriodSEOMargin / (double)(pastPeriodSEOSales - pastPeriodSEOValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodSEOProfitability = 0;
        }
        changingOfSEOProfitability = presentPeriodSEOProfitability - pastPeriodSEOProfitability;
    }

    public void setENKSalesSum() {
        presentPeriodENKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodENKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodENKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodENKSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodENKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodENKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodENKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodENKSales();
        pastPeriodENKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodENKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodENKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodENKSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodENKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodENKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodENKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodENKSales();
        changingOfENKSales = presentPeriodENKSales - pastPeriodENKSales;
        changingOfENKSalesInPercents = (presentPeriodENKSales * HUNDRED_PERCENTS / pastPeriodENKSales) - HUNDRED_PERCENTS;

        presentPeriodENKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodENKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodENKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodENKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodENKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodENKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodENKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodENKMargin();
        pastPeriodENKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodENKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodENKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodENKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodENKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodENKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodENKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodENKMargin();
        changingOfENKMargin = presentPeriodENKMargin - pastPeriodENKMargin;
        changingOfENKMarginInPercents = (presentPeriodENKMargin * HUNDRED_PERCENTS / pastPeriodENKMargin) - HUNDRED_PERCENTS;

        presentPeriodENKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodENKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodENKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodENKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodENKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodENKValueAddedTax();
        pastPeriodENKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodENKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodENKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodENKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodENKValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodENKValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodENKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodENKValueAddedTax();
        changingOfENKValueAddedTax = presentPeriodENKValueAddedTax - pastPeriodENKValueAddedTax;
        changingOfENKValueAddedTaxInPercents = (presentPeriodENKValueAddedTax * HUNDRED_PERCENTS / pastPeriodENKValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodENKSales != 0) {
            presentPeriodENKProfitability = (double)presentPeriodENKMargin / (double)(presentPeriodENKSales - presentPeriodENKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodENKProfitability = 0;
        }
        if(pastPeriodENKSales != 0) {
            pastPeriodENKProfitability = (double)pastPeriodENKMargin / (double)(pastPeriodENKSales - pastPeriodENKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodENKProfitability = 0;
        }
        changingOfENKProfitability = presentPeriodENKProfitability - pastPeriodENKProfitability;
    }

    public void setEBKSalesSum() {
        presentPeriodEBKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodEBKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodEBKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodEBKSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodEBKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodEBKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodEBKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodEBKSales();
        pastPeriodEBKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodEBKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodEBKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodEBKSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodEBKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodEBKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodEBKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodEBKSales();
        changingOfEBKSales = presentPeriodEBKSales - pastPeriodEBKSales;
        changingOfEBKSalesInPercents = (presentPeriodEBKSales * HUNDRED_PERCENTS / pastPeriodEBKSales) - HUNDRED_PERCENTS;

        presentPeriodEBKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodEBKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodEBKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodEBKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodEBKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodEBKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodEBKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodEBKMargin();
        pastPeriodEBKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodEBKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodEBKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodEBKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodEBKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodEBKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodEBKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodEBKMargin();
        changingOfEBKMargin = presentPeriodEBKMargin - pastPeriodEBKMargin;
        changingOfEBKMarginInPercents = (presentPeriodEBKMargin * HUNDRED_PERCENTS / pastPeriodEBKMargin) - HUNDRED_PERCENTS;

        presentPeriodEBKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodEBKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodEBKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodEBKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodEBKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodEBKValueAddedTax();
        pastPeriodEBKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodEBKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodEBKValueAddedTax();
        changingOfEBKValueAddedTax = presentPeriodEBKValueAddedTax - pastPeriodEBKValueAddedTax;
        changingOfEBKValueAddedTaxInPercents = (presentPeriodEBKValueAddedTax * HUNDRED_PERCENTS / pastPeriodEBKValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodEBKSales != 0) {
            presentPeriodEBKProfitability = (double)presentPeriodEBKMargin / (double)(presentPeriodEBKSales - presentPeriodEBKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodEBKProfitability = 0;
        }
        if(pastPeriodEBKSales != 0) {
            pastPeriodEBKProfitability = (double)pastPeriodEBKMargin / (double)(pastPeriodEBKSales - pastPeriodEBKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodEBKProfitability = 0;
        }
        changingOfEBKProfitability = presentPeriodEBKProfitability - pastPeriodEBKProfitability;
    }

    public void setSPPSSalesSum() {
        presentPeriodSPPSSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSPPSSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSPPSSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSPPSSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSPPSSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodSPPSSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodSPPSSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSPPSSales();
        pastPeriodSPPSSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSPPSSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSPPSSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSPPSSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSPPSSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSPPSSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSPPSSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSPPSSales();
        changingOfSPPSSales = presentPeriodSPPSSales - pastPeriodSPPSSales;
        changingOfSPPSSalesInPercents = (presentPeriodSPPSSales * HUNDRED_PERCENTS / pastPeriodSPPSSales) - HUNDRED_PERCENTS;

        presentPeriodSPPSMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSPPSMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSPPSMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSPPSMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSPPSMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodSPPSMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodSPPSMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSPPSMargin();
        pastPeriodSPPSMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSPPSMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSPPSMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSPPSMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSPPSMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSPPSMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSPPSMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSPPSMargin();
        changingOfSPPSMargin = presentPeriodSPPSMargin - pastPeriodSPPSMargin;
        changingOfSPPSMarginInPercents = (presentPeriodSPPSMargin * HUNDRED_PERCENTS / pastPeriodSPPSMargin) - HUNDRED_PERCENTS;

        presentPeriodSPPSValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodSPPSValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodSPPSValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodSPPSValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodSPPSValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodSPPSValueAddedTax();
        pastPeriodSPPSValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodSPPSValueAddedTax();
        changingOfSPPSValueAddedTax = presentPeriodSPPSValueAddedTax - pastPeriodSPPSValueAddedTax;
        changingOfSPPSValueAddedTaxInPercents = (presentPeriodSPPSValueAddedTax * HUNDRED_PERCENTS / pastPeriodSPPSValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodSPPSSales != 0) {
            presentPeriodSPPSProfitability = (double)presentPeriodSPPSMargin / (double)(presentPeriodSPPSSales - presentPeriodSPPSValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodSPPSProfitability = 0;
        }
        if(pastPeriodSPPSSales != 0) {
            pastPeriodSPPSProfitability = (double)pastPeriodSPPSMargin / (double)(pastPeriodSPPSSales - pastPeriodSPPSValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodSPPSProfitability = 0;
        }
        changingOfSPPSProfitability = presentPeriodSPPSProfitability - pastPeriodSPPSProfitability;
    }

    public void setFKSalesSum() {
        presentPeriodFKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodFKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodFKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodFKSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodFKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodFKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodFKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodFKSales();
        pastPeriodFKSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodFKSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodFKSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodFKSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodFKSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodFKSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodFKSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodFKSales();
        changingOfFKSales = presentPeriodFKSales - pastPeriodFKSales;
        changingOfFKSalesInPercents = (presentPeriodFKSales * HUNDRED_PERCENTS / pastPeriodFKSales) - HUNDRED_PERCENTS;

        presentPeriodFKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodFKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodFKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodFKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodFKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodFKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodFKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodFKMargin();
        pastPeriodFKMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodFKMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodFKMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodFKMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodFKMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodFKMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodFKMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodFKMargin();
        changingOfFKMargin = presentPeriodFKMargin - pastPeriodFKMargin;
        changingOfFKMarginInPercents = (presentPeriodFKMargin * HUNDRED_PERCENTS / pastPeriodFKMargin) - HUNDRED_PERCENTS;

        presentPeriodFKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodFKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodFKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodFKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodFKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodFKValueAddedTax();
        pastPeriodFKValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodFKValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodFKValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodFKValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodFKValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodFKValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodFKValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodFKValueAddedTax();
        changingOfFKValueAddedTax = presentPeriodFKValueAddedTax - pastPeriodFKValueAddedTax;
        changingOfFKValueAddedTaxInPercents = (presentPeriodFKValueAddedTax * HUNDRED_PERCENTS / pastPeriodFKValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodFKSales != 0) {
            presentPeriodFKProfitability = (double)presentPeriodFKMargin / (double)(presentPeriodFKSales - presentPeriodFKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodFKProfitability = 0;
        }
        if(pastPeriodFKSales != 0) {
            pastPeriodFKProfitability = (double)pastPeriodFKMargin / (double)(pastPeriodFKSales - pastPeriodFKValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodFKProfitability = 0;
        }
        changingOfFKProfitability = presentPeriodFKProfitability - pastPeriodFKProfitability;
    }


    public void setOthersSalesSum() {
        presentPeriodOthersSales = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOthersSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOthersSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOthersSales() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOthersSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodOthersSales() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodOthersSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOthersSales();
        pastPeriodOthersSales = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOthersSales() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOthersSales() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOthersSales() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOthersSales() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOthersSales() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOthersSales() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOthersSales();
        changingOfOthersSales = presentPeriodOthersSales - pastPeriodOthersSales;
        changingOfOthersSalesInPercents = (presentPeriodOthersSales * HUNDRED_PERCENTS / pastPeriodOthersSales) - HUNDRED_PERCENTS;

        presentPeriodOthersMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOthersMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOthersMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOthersMargin() + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOthersMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodOthersMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodOthersMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOthersMargin();
        pastPeriodOthersMargin = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOthersMargin() + basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOthersMargin() +
                basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOthersMargin() + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOthersMargin() +
                basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOthersMargin() + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOthersMargin() +
                basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOthersMargin();
        changingOfOthersMargin = presentPeriodOthersMargin - pastPeriodOthersMargin;
        changingOfOthersMarginInPercents = (presentPeriodOthersMargin * HUNDRED_PERCENTS / pastPeriodOthersMargin) - HUNDRED_PERCENTS;

        presentPeriodOthersValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPresentPeriodOthersValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodOthersValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodOthersValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodOthersValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodOthersValueAddedTax();
        pastPeriodOthersValueAddedTax = basicIndicatorKaraganda.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() +
                basicIndicatorAlmaty.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() +
                basicIndicatorAstana.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() +
                basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodOthersValueAddedTax() + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodOthersValueAddedTax();
        changingOfOthersValueAddedTax = presentPeriodOthersValueAddedTax - pastPeriodOthersValueAddedTax;
        changingOfOthersValueAddedTaxInPercents = (presentPeriodOthersValueAddedTax * HUNDRED_PERCENTS / pastPeriodOthersValueAddedTax) - HUNDRED_PERCENTS;

        if(presentPeriodOthersSales != 0) {
            presentPeriodOthersProfitability = (double)presentPeriodOthersMargin / (double)(presentPeriodOthersSales - presentPeriodOthersValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            presentPeriodOthersProfitability = 0;
        }
        if(pastPeriodOthersSales != 0) {
            pastPeriodOthersProfitability = (double)pastPeriodOthersMargin / (double)(pastPeriodOthersSales - pastPeriodOthersValueAddedTax) * HUNDRED_PERCENTS;
        } else {
            pastPeriodOthersProfitability = 0;
        }
        changingOfOthersProfitability = presentPeriodOthersProfitability - pastPeriodOthersProfitability;
    }

//    public void setRevenueSum(){
//        presentPeriodRevenue = basicIndicatorKaraganda.getPresentPeriodRevenue() + basicIndicatorAlmaty.getPresentPeriodRevenue() +
//                basicIndicatorAtyrau.getPresentPeriodRevenue() + basicIndicatorAstana.getPresentPeriodRevenue() + basicIndicatorAktobe.getPresentPeriodRevenue() +
//                basicIndicatorOskemen.getPresentPeriodRevenue() + basicIndicatorShymkent.getPresentPeriodRevenue();
//
//        pastPeriodRevenue = basicIndicatorKaraganda.getPastPeriodRevenue() + basicIndicatorAlmaty.getPastPeriodRevenue() +
//                basicIndicatorAtyrau.getPastPeriodRevenue() + basicIndicatorAstana.getPastPeriodRevenue() + basicIndicatorAktobe.getPastPeriodRevenue() +
//                basicIndicatorOskemen.getPastPeriodRevenue() + basicIndicatorShymkent.getPastPeriodRevenue();
//
//        changingOfRevenue = presentPeriodRevenue - pastPeriodRevenue;
//        changingOfRevenueInPercents = (presentPeriodRevenue * HUNDRED_PERCENTS / pastPeriodRevenue) - HUNDRED_PERCENTS;
//    }

    public void setSalarySum() {
        presentPeriodSalaryExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodSalaryExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodSalaryExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodSalaryExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodSalaryExpenses() + basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodSalaryExpenses() +
                basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodSalaryExpenses() + basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodSalaryExpenses();

        pastPeriodSalaryExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodSalaryExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodSalaryExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodSalaryExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodSalaryExpenses() + basicIndicatorAktobe.getExpenseIndicator().getPastPeriodSalaryExpenses() +
                basicIndicatorOskemen.getExpenseIndicator().getPastPeriodSalaryExpenses() + basicIndicatorShymkent.getExpenseIndicator().getPastPeriodSalaryExpenses();

        changingOfSalaryExpenses = presentPeriodSalaryExpenses - pastPeriodSalaryExpenses;
        changingOfSalaryExpensesInPercents = (presentPeriodSalaryExpenses * HUNDRED_PERCENTS / pastPeriodSalaryExpenses) - HUNDRED_PERCENTS;
    }

    public void setFactorySum() {
        presentPeriodFactoryExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodFactoryExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodFactoryExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodFactoryExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodFactoryExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodFactoryExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodFactoryExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodFactoryExpenses();

        pastPeriodFactoryExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodFactoryExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodFactoryExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodFactoryExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodFactoryExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodFactoryExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodFactoryExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodFactoryExpenses();

        changingOfFactoryExpenses = presentPeriodFactoryExpenses - pastPeriodFactoryExpenses;
        changingOfFactoryExpensesInPercents = (presentPeriodFactoryExpenses * HUNDRED_PERCENTS / pastPeriodFactoryExpenses) - HUNDRED_PERCENTS;
    }

    public void setTransportSum() {
        presentPeriodTransportExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodTransportExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodTransportExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodTransportExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodTransportExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodTransportExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodTransportExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodTransportExpenses();

        pastPeriodTransportExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodTransportExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodTransportExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodTransportExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodTransportExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodTransportExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodTransportExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodTransportExpenses();

        changingOfTransportExpenses = presentPeriodTransportExpenses - pastPeriodTransportExpenses;
        changingOfTransportExpensesInPercents = (presentPeriodTransportExpenses * HUNDRED_PERCENTS / pastPeriodTransportExpenses) - HUNDRED_PERCENTS;
    }

    public void setPackageSum() {
        presentPeriodPackageExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodPackageExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodPackageExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodPackageExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodPackageExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodPackageExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodPackageExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodPackageExpenses();

        pastPeriodPackageExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodPackageExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodPackageExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodPackageExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodPackageExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodPackageExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodPackageExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodPackageExpenses();

        changingOfPackageExpenses = presentPeriodPackageExpenses - pastPeriodPackageExpenses;
        changingOfPackageExpensesInPercents = (presentPeriodPackageExpenses * HUNDRED_PERCENTS / pastPeriodPackageExpenses) - HUNDRED_PERCENTS;
    }

    public void setRentSum() {
        presentPeriodRentExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodRentExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodRentExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodRentExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodRentExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodRentExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodRentExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodRentExpenses();

        pastPeriodRentExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodRentExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodRentExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodRentExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodRentExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodRentExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodRentExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodRentExpenses();

        changingOfRentExpenses = presentPeriodRentExpenses - pastPeriodRentExpenses;
        changingOfRentExpensesInPercents = (presentPeriodRentExpenses * HUNDRED_PERCENTS / pastPeriodRentExpenses) - HUNDRED_PERCENTS;
    }

    public void setOtherSum() {
        presentPeriodOtherExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodOtherExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodOtherExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodOtherExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodOtherExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodOtherExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodOtherExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodOtherExpenses();

        pastPeriodOtherExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodOtherExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodOtherExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodOtherExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodOtherExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodOtherExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodOtherExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodOtherExpenses();

        changingOfOtherExpenses = presentPeriodOtherExpenses - pastPeriodOtherExpenses;
        changingOfOtherExpensesInPercents = (presentPeriodOtherExpenses * HUNDRED_PERCENTS / pastPeriodOtherExpenses) - HUNDRED_PERCENTS;
    }

    public void setPhoneSum() {
        presentPeriodPhoneExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodPhoneExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodPhoneExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodPhoneExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodPhoneExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodPhoneExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodPhoneExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodPhoneExpenses();

        pastPeriodPhoneExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodPhoneExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodPhoneExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodPhoneExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodPhoneExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodPhoneExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodPhoneExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodPhoneExpenses();

        changingOfPhoneExpenses = presentPeriodPhoneExpenses - pastPeriodPhoneExpenses;
        changingOfPhoneExpensesInPercents = (presentPeriodPhoneExpenses * HUNDRED_PERCENTS / pastPeriodPhoneExpenses) - HUNDRED_PERCENTS;
    }

    public void setBusinessTripSum() {
        presentPeriodBusinessTripExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodBusinessTripExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodBusinessTripExpenses();

        pastPeriodBusinessTripExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodBusinessTripExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodBusinessTripExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodBusinessTripExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodBusinessTripExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodBusinessTripExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodBusinessTripExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodBusinessTripExpenses();

        changingOfBusinessTripExpenses = presentPeriodBusinessTripExpenses - pastPeriodBusinessTripExpenses;
        changingOfBusinessTripExpensesInPercents = (presentPeriodBusinessTripExpenses * HUNDRED_PERCENTS / pastPeriodBusinessTripExpenses) - HUNDRED_PERCENTS;
    }

    public void setAdvertisementSum() {
        presentPeriodAdvertisementExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodAdvertisementExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodAdvertisementExpenses();

        pastPeriodAdvertisementExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodAdvertisementExpenses() +
                basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodAdvertisementExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodAdvertisementExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodAdvertisementExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodAdvertisementExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodAdvertisementExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodAdvertisementExpenses();

        changingOfAdvertisementExpenses = presentPeriodAdvertisementExpenses - pastPeriodAdvertisementExpenses;
        changingOfAdvertisementExpensesInPercents = (presentPeriodAdvertisementExpenses * HUNDRED_PERCENTS / pastPeriodAdvertisementExpenses) - HUNDRED_PERCENTS;
    }

    public void setEcquiringSum() {
        presentPeriodEcquiringExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodEcquiringExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodEcquiringExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodEcquiringExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodEcquiringExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodEcquiringExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodEcquiringExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodEcquiringExpenses();

        pastPeriodEcquiringExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodEcquiringExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodEcquiringExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodEcquiringExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodEcquiringExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodEcquiringExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodEcquiringExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodEcquiringExpenses();

        changingOfEcquiringExpenses = presentPeriodEcquiringExpenses - pastPeriodEcquiringExpenses;
        changingOfEcquiringExpensesInPercents = (presentPeriodEcquiringExpenses * HUNDRED_PERCENTS / pastPeriodEcquiringExpenses) - HUNDRED_PERCENTS;
    }

    public void setAllExpenses() {
        presentPeriodAllExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPresentPeriodAllExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodAllExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPresentPeriodAllExpenses() + basicIndicatorAstana.getExpenseIndicator().getPresentPeriodAllExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPresentPeriodAllExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPresentPeriodAllExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPresentPeriodAllExpenses();

        pastPeriodAllExpenses = basicIndicatorKaraganda.getExpenseIndicator().getPastPeriodAllExpenses() + basicIndicatorAlmaty.getExpenseIndicator().getPastPeriodAllExpenses() +
                basicIndicatorAtyrau.getExpenseIndicator().getPastPeriodAllExpenses() + basicIndicatorAstana.getExpenseIndicator().getPastPeriodAllExpenses() +
                basicIndicatorAktobe.getExpenseIndicator().getPastPeriodAllExpenses() + basicIndicatorOskemen.getExpenseIndicator().getPastPeriodAllExpenses() +
                basicIndicatorShymkent.getExpenseIndicator().getPastPeriodAllExpenses();

        changingOfAllExpenses = presentPeriodAllExpenses - pastPeriodAllExpenses;
        changingOfAllExpensesInPercents = (presentPeriodAllExpenses * HUNDRED_PERCENTS / pastPeriodAllExpenses) - HUNDRED_PERCENTS;
    }

    public void setPercentOfExpenseToRevenue() {
        presentPeriodPercentOfExpenseToRevenue = (double)presentPeriodAllExpenses / (double)presentPeriodRevenue * HUNDRED_PERCENTS;
        pastPeriodPercentOfExpenseToRevenue = (double)pastPeriodAllExpenses / (double)pastPeriodRevenue * HUNDRED_PERCENTS;
        changingOfPercentOfExpenseToRevenue = presentPeriodPercentOfExpenseToRevenue - pastPeriodPercentOfExpenseToRevenue;
    }

    public void setMarginOnSquareMetres() {
        presentPeriodMarginOnSquareMetre = presentPeriodAllMargin / presentPeriodSquareMetresSales;
        pastPeriodMarginOnSquareMetre = pastPeriodAllMargin / pastPeriodSquareMetresSales;
        changingOfMarginOnSquareMetre = presentPeriodMarginOnSquareMetre - pastPeriodMarginOnSquareMetre;
        changingOfMarginOnSquareMetreInPercents = (presentPeriodMarginOnSquareMetre * HUNDRED_PERCENTS / pastPeriodMarginOnSquareMetre) - HUNDRED_PERCENTS;
    }

    public void setMarginOnTonns() {
        presentPeriodMarginOnTonn = presentPeriodAllMargin / presentPeriodTonnsSales;
        pastPeriodMarginOnTonn = pastPeriodAllMargin / pastPeriodTonnsSales;
        changingOfMarginOnTonn = presentPeriodMarginOnTonn - pastPeriodMarginOnTonn;
        changingOfMarginOnTonnInPercents = (presentPeriodMarginOnTonn * HUNDRED_PERCENTS / pastPeriodMarginOnTonn) - HUNDRED_PERCENTS;
    }

    public void setMarginOnEmployee() {
        presentPeriodMarginOnEmployeeinMonth = presentPeriodAllMargin / presentPeriodNumberOfStuff / basicIndicatorAktobe.getAmountOfMonths();
        pastPeriodMarginOnEmployeeinMonth = pastPeriodAllMargin / pastPeriodNumberOfStuff / basicIndicatorAktobe.getAmountOfMonths();

        changingOfMarginOnEmployeeinMonth = presentPeriodMarginOnEmployeeinMonth - pastPeriodMarginOnEmployeeinMonth;
        changingOfMarginOnEmployeeInPercents = (presentPeriodMarginOnEmployeeinMonth * HUNDRED_PERCENTS / pastPeriodMarginOnEmployeeinMonth) - HUNDRED_PERCENTS;
    }

    public void setLabourCostOnEmployee() {
        presentPeriodLabourCostOnEmployeeInMonth = presentPeriodLabourCost / presentPeriodNumberOfStuff / basicIndicatorAktobe.getAmountOfMonths();
        pastPeriodLabourCostOnEmployeeInMonth = pastPeriodLabourCost / pastPeriodNumberOfStuff / basicIndicatorAktobe.getAmountOfMonths();

        changingOfLabourCostOnEmployeeInMonth = presentPeriodLabourCostOnEmployeeInMonth - pastPeriodLabourCostOnEmployeeInMonth;
        changingOfLabourCostOnEmployeeInPercents = (presentPeriodLabourCostOnEmployeeInMonth * HUNDRED_PERCENTS / pastPeriodLabourCostOnEmployeeInMonth) - HUNDRED_PERCENTS;
    }

    public void setLabourCostOnSquareMetres() {
        presentPeriodLabourCostOnSquareMetre = presentPeriodLabourCost / presentPeriodSquareMetresSales;
        pastPeriodLabourCostOnSquareMetre = pastPeriodLabourCost / pastPeriodSquareMetresSales;
        changingOfLabourCostOnSquareMetre = presentPeriodLabourCostOnSquareMetre - pastPeriodLabourCostOnSquareMetre;
        changingOfLabourCostOnSquareMetreInPercents = (presentPeriodLabourCostOnSquareMetre * HUNDRED_PERCENTS / pastPeriodLabourCostOnSquareMetre) - HUNDRED_PERCENTS;
    }

    public void setLabourCostOnTonn() {
        presentPeriodLabourCostOnTonn = (double)presentPeriodLabourCost / (double)presentPeriodTonnsSales;
        pastPeriodLabourCostOnTonn = (double)pastPeriodLabourCost / (double)pastPeriodTonnsSales;

        changingOfLabourCostOnTonn = presentPeriodLabourCostOnTonn - pastPeriodLabourCostOnTonn;
        changingOfLabourCostOnTonnInPercents = (presentPeriodLabourCostOnTonn * HUNDRED_PERCENTS / pastPeriodLabourCostOnTonn) - HUNDRED_PERCENTS;
    }

    public void setMetallProcessing() {
        presentPeriodMetallProcessing = basicIndicatorKaraganda.getPresentPeriodMetallProcessing() + basicIndicatorAlmaty.getPresentPeriodMetallProcessing() +
                basicIndicatorAtyrau.getPresentPeriodMetallProcessing() + basicIndicatorAstana.getPresentPeriodMetallProcessing() +
                basicIndicatorAktobe.getPresentPeriodMetallProcessing() + basicIndicatorOskemen.getPresentPeriodMetallProcessing() +
                basicIndicatorShymkent.getPresentPeriodMetallProcessing();

        pastPeriodMetallProcessing = basicIndicatorKaraganda.getPastPeriodMetallProcessing() + basicIndicatorAlmaty.getPastPeriodMetallProcessing() +
                basicIndicatorAtyrau.getPastPeriodMetallProcessing() + basicIndicatorAstana.getPastPeriodMetallProcessing() +
                basicIndicatorAktobe.getPastPeriodMetallProcessing() + basicIndicatorOskemen.getPastPeriodMetallProcessing() +
                basicIndicatorShymkent.getPastPeriodMetallProcessing();

        changingOfMetallProcessing = presentPeriodMetallProcessing - pastPeriodMetallProcessing;
        changingOfMetallProcessingInPercents = (presentPeriodMetallProcessing * HUNDRED_PERCENTS / pastPeriodMetallProcessing) - HUNDRED_PERCENTS;
    }

    public void setAll(){
        setNumberOfStuff();
        setLabourCost();
        setSquareMetreAndTonnesSalesAmount();
        setOVPSalesSum();
        setTSPSalesSum();
        setVSSalesSum();
        setSEOSalesSum();
        setENKSalesSum();
        setEBKSalesSum();
        setSPPSSalesSum();
        setFKSalesSum();
        setOthersSalesSum();
        setGoodsSalesSum();
        setProductionSalesSum();
        setAllSalesSum();
//        setRevenueSum();
        setSalarySum();
        setFactorySum();
        setTransportSum();
        setPackageSum();
        setRentSum();
        setOtherSum();
        setPhoneSum();
        setBusinessTripSum();
        setAdvertisementSum();
        setEcquiringSum();
        setAllExpenses();
        setMetallProcessing();
        setPercentOfExpenseToRevenue();
        setMarginOnSquareMetres();
        setMarginOnTonns();
        setMarginOnEmployee();
        setLabourCostOnEmployee();
        setLabourCostOnSquareMetres();
        setLabourCostOnTonn();
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

    public long getPresentPeriodOVPSales() {
        return presentPeriodOVPSales;
    }

    public long getPastPeriodOVPSales() {
        return pastPeriodOVPSales;
    }

    public long getChangingOfOVPSales() {
        return changingOfOVPSales;
    }

    public double getChangingOfOVPSalesInPercents() {
        return changingOfOVPSalesInPercents;
    }

    public long getPresentPeriodOVPMargin() {
        return presentPeriodOVPMargin;
    }

    public long getPastPeriodOVPMargin() {
        return pastPeriodOVPMargin;
    }

    public long getChangingOfOVPMargin() {
        return changingOfOVPMargin;
    }

    public double getChangingOfOVPMarginInPercents() {
        return changingOfOVPMarginInPercents;
    }

    public long getPresentPeriodOVPValueAddedTax() {
        return presentPeriodOVPValueAddedTax;
    }

    public long getPastPeriodOVPValueAddedTax() {
        return pastPeriodOVPValueAddedTax;
    }

    public long getChangingOfOVPValueAddedTax() {
        return changingOfOVPValueAddedTax;
    }

    public double getChangingOfOVPValueAddedTaxInPercents() {
        return changingOfOVPValueAddedTaxInPercents;
    }

    public double getPresentPeriodOVPProfitability() {
        return presentPeriodOVPProfitability;
    }

    public double getPastPeriodOVPProfitability() {
        return pastPeriodOVPProfitability;
    }

    public double getChangingOfOVPProfitability() {
        return changingOfOVPProfitability;
    }

    public long getPresentPeriodTSPSales() {
        return presentPeriodTSPSales;
    }

    public long getPastPeriodTSPSales() {
        return pastPeriodTSPSales;
    }

    public long getChangingOfTSPSales() {
        return changingOfTSPSales;
    }

    public double getChangingOfTSPSalesInPercents() {
        return changingOfTSPSalesInPercents;
    }

    public long getPresentPeriodTSPMargin() {
        return presentPeriodTSPMargin;
    }

    public long getPastPeriodTSPMargin() {
        return pastPeriodTSPMargin;
    }

    public long getChangingOfTSPMargin() {
        return changingOfTSPMargin;
    }

    public double getChangingOfTSPMarginInPercents() {
        return changingOfTSPMarginInPercents;
    }

    public long getPresentPeriodTSPValueAddedTax() {
        return presentPeriodTSPValueAddedTax;
    }

    public long getPastPeriodTSPValueAddedTax() {
        return pastPeriodTSPValueAddedTax;
    }

    public long getChangingOfTSPValueAddedTax() {
        return changingOfTSPValueAddedTax;
    }

    public double getChangingOfTSPValueAddedTaxInPercents() {
        return changingOfTSPValueAddedTaxInPercents;
    }

    public double getPresentPeriodTSPProfitability() {
        return presentPeriodTSPProfitability;
    }

    public double getPastPeriodTSPProfitability() {
        return pastPeriodTSPProfitability;
    }

    public double getChangingOfTSPProfitability() {
        return changingOfTSPProfitability;
    }

    public long getPresentPeriodVSSales() {
        return presentPeriodVSSales;
    }

    public long getPastPeriodVSSales() {
        return pastPeriodVSSales;
    }

    public long getChangingOfVSSales() {
        return changingOfVSSales;
    }

    public double getChangingOfVSSalesInPercents() {
        return changingOfVSSalesInPercents;
    }

    public long getPresentPeriodVSMargin() {
        return presentPeriodVSMargin;
    }

    public long getPastPeriodVSMargin() {
        return pastPeriodVSMargin;
    }

    public long getChangingOfVSMargin() {
        return changingOfVSMargin;
    }

    public double getChangingOfVSMarginInPercents() {
        return changingOfVSMarginInPercents;
    }

    public long getPresentPeriodVSValueAddedTax() {
        return presentPeriodVSValueAddedTax;
    }

    public long getPastPeriodVSValueAddedTax() {
        return pastPeriodVSValueAddedTax;
    }

    public long getChangingOfVSValueAddedTax() {
        return changingOfVSValueAddedTax;
    }

    public double getChangingOfVSValueAddedTaxInPercents() {
        return changingOfVSValueAddedTaxInPercents;
    }

    public double getPresentPeriodVSProfitability() {
        return presentPeriodVSProfitability;
    }

    public double getPastPeriodVSProfitability() {
        return pastPeriodVSProfitability;
    }

    public double getChangingOfVSProfitability() {
        return changingOfVSProfitability;
    }

    public long getPresentPeriodSEOSales() {
        return presentPeriodSEOSales;
    }

    public long getPastPeriodSEOSales() {
        return pastPeriodSEOSales;
    }

    public long getChangingOfSEOSales() {
        return changingOfSEOSales;
    }

    public double getChangingOfSEOSalesInPercents() {
        return changingOfSEOSalesInPercents;
    }

    public long getPresentPeriodSEOMargin() {
        return presentPeriodSEOMargin;
    }

    public long getPastPeriodSEOMargin() {
        return pastPeriodSEOMargin;
    }

    public long getChangingOfSEOMargin() {
        return changingOfSEOMargin;
    }

    public double getChangingOfSEOMarginInPercents() {
        return changingOfSEOMarginInPercents;
    }

    public long getPresentPeriodSEOValueAddedTax() {
        return presentPeriodSEOValueAddedTax;
    }

    public long getPastPeriodSEOValueAddedTax() {
        return pastPeriodSEOValueAddedTax;
    }

    public long getChangingOfSEOValueAddedTax() {
        return changingOfSEOValueAddedTax;
    }

    public double getChangingOfSEOValueAddedTaxInPercents() {
        return changingOfSEOValueAddedTaxInPercents;
    }

    public double getPresentPeriodSEOProfitability() {
        return presentPeriodSEOProfitability;
    }

    public double getPastPeriodSEOProfitability() {
        return pastPeriodSEOProfitability;
    }

    public double getChangingOfSEOProfitability() {
        return changingOfSEOProfitability;
    }

    public long getPresentPeriodENKSales() {
        return presentPeriodENKSales;
    }

    public long getPastPeriodENKSales() {
        return pastPeriodENKSales;
    }

    public long getChangingOfENKSales() {
        return changingOfENKSales;
    }

    public double getChangingOfENKSalesInPercents() {
        return changingOfENKSalesInPercents;
    }

    public long getPresentPeriodENKMargin() {
        return presentPeriodENKMargin;
    }

    public long getPastPeriodENKMargin() {
        return pastPeriodENKMargin;
    }

    public long getChangingOfENKMargin() {
        return changingOfENKMargin;
    }

    public double getChangingOfENKMarginInPercents() {
        return changingOfENKMarginInPercents;
    }

    public long getPresentPeriodENKValueAddedTax() {
        return presentPeriodENKValueAddedTax;
    }

    public long getPastPeriodENKValueAddedTax() {
        return pastPeriodENKValueAddedTax;
    }

    public long getChangingOfENKValueAddedTax() {
        return changingOfENKValueAddedTax;
    }

    public double getChangingOfENKValueAddedTaxInPercents() {
        return changingOfENKValueAddedTaxInPercents;
    }

    public double getPresentPeriodENKProfitability() {
        return presentPeriodENKProfitability;
    }

    public double getPastPeriodENKProfitability() {
        return pastPeriodENKProfitability;
    }

    public double getChangingOfENKProfitability() {
        return changingOfENKProfitability;
    }

    public long getPresentPeriodEBKSales() {
        return presentPeriodEBKSales;
    }

    public long getPastPeriodEBKSales() {
        return pastPeriodEBKSales;
    }

    public long getChangingOfEBKSales() {
        return changingOfEBKSales;
    }

    public double getChangingOfEBKSalesInPercents() {
        return changingOfEBKSalesInPercents;
    }

    public long getPresentPeriodEBKMargin() {
        return presentPeriodEBKMargin;
    }

    public long getPastPeriodEBKMargin() {
        return pastPeriodEBKMargin;
    }

    public long getChangingOfEBKMargin() {
        return changingOfEBKMargin;
    }

    public double getChangingOfEBKMarginInPercents() {
        return changingOfEBKMarginInPercents;
    }

    public long getPresentPeriodEBKValueAddedTax() {
        return presentPeriodEBKValueAddedTax;
    }

    public long getPastPeriodEBKValueAddedTax() {
        return pastPeriodEBKValueAddedTax;
    }

    public long getChangingOfEBKValueAddedTax() {
        return changingOfEBKValueAddedTax;
    }

    public double getChangingOfEBKValueAddedTaxInPercents() {
        return changingOfEBKValueAddedTaxInPercents;
    }

    public double getPresentPeriodEBKProfitability() {
        return presentPeriodEBKProfitability;
    }

    public double getPastPeriodEBKProfitability() {
        return pastPeriodEBKProfitability;
    }

    public double getChangingOfEBKProfitability() {
        return changingOfEBKProfitability;
    }

    public long getPresentPeriodSPPSSales() {
        return presentPeriodSPPSSales;
    }

    public long getPastPeriodSPPSSales() {
        return pastPeriodSPPSSales;
    }

    public long getChangingOfSPPSSales() {
        return changingOfSPPSSales;
    }

    public double getChangingOfSPPSSalesInPercents() {
        return changingOfSPPSSalesInPercents;
    }

    public long getPresentPeriodSPPSMargin() {
        return presentPeriodSPPSMargin;
    }

    public long getPastPeriodSPPSMargin() {
        return pastPeriodSPPSMargin;
    }

    public long getChangingOfSPPSMargin() {
        return changingOfSPPSMargin;
    }

    public double getChangingOfSPPSMarginInPercents() {
        return changingOfSPPSMarginInPercents;
    }

    public long getPresentPeriodSPPSValueAddedTax() {
        return presentPeriodSPPSValueAddedTax;
    }

    public long getPastPeriodSPPSValueAddedTax() {
        return pastPeriodSPPSValueAddedTax;
    }

    public long getChangingOfSPPSValueAddedTax() {
        return changingOfSPPSValueAddedTax;
    }

    public double getChangingOfSPPSValueAddedTaxInPercents() {
        return changingOfSPPSValueAddedTaxInPercents;
    }

    public double getPresentPeriodSPPSProfitability() {
        return presentPeriodSPPSProfitability;
    }

    public double getPastPeriodSPPSProfitability() {
        return pastPeriodSPPSProfitability;
    }

    public double getChangingOfSPPSProfitability() {
        return changingOfSPPSProfitability;
    }

    public long getPresentPeriodFKSales() {
        return presentPeriodFKSales;
    }

    public long getPastPeriodFKSales() {
        return pastPeriodFKSales;
    }

    public long getChangingOfFKSales() {
        return changingOfFKSales;
    }

    public double getChangingOfFKSalesInPercents() {
        return changingOfFKSalesInPercents;
    }

    public long getPresentPeriodFKMargin() {
        return presentPeriodFKMargin;
    }

    public long getPastPeriodFKMargin() {
        return pastPeriodFKMargin;
    }

    public long getChangingOfFKMargin() {
        return changingOfFKMargin;
    }

    public double getChangingOfFKMarginInPercents() {
        return changingOfFKMarginInPercents;
    }

    public long getPresentPeriodFKValueAddedTax() {
        return presentPeriodFKValueAddedTax;
    }

    public long getPastPeriodFKValueAddedTax() {
        return pastPeriodFKValueAddedTax;
    }

    public long getChangingOfFKValueAddedTax() {
        return changingOfFKValueAddedTax;
    }

    public double getChangingOfFKValueAddedTaxInPercents() {
        return changingOfFKValueAddedTaxInPercents;
    }

    public double getPresentPeriodFKProfitability() {
        return presentPeriodFKProfitability;
    }

    public double getPastPeriodFKProfitability() {
        return pastPeriodFKProfitability;
    }

    public double getChangingOfFKProfitability() {
        return changingOfFKProfitability;
    }

    public long getPresentPeriodOthersSales() {
        return presentPeriodOthersSales;
    }

    public long getPastPeriodOthersSales() {
        return pastPeriodOthersSales;
    }

    public long getChangingOfOthersSales() {
        return changingOfOthersSales;
    }

    public double getChangingOfOthersSalesInPercents() {
        return changingOfOthersSalesInPercents;
    }

    public long getPresentPeriodOthersMargin() {
        return presentPeriodOthersMargin;
    }

    public long getPastPeriodOthersMargin() {
        return pastPeriodOthersMargin;
    }

    public long getChangingOfOthersMargin() {
        return changingOfOthersMargin;
    }

    public double getChangingOfOthersMarginInPercents() {
        return changingOfOthersMarginInPercents;
    }

    public long getPresentPeriodOthersValueAddedTax() {
        return presentPeriodOthersValueAddedTax;
    }

    public long getPastPeriodOthersValueAddedTax() {
        return pastPeriodOthersValueAddedTax;
    }

    public long getChangingOfOthersValueAddedTax() {
        return changingOfOthersValueAddedTax;
    }

    public double getChangingOfOthersValueAddedTaxInPercents() {
        return changingOfOthersValueAddedTaxInPercents;
    }

    public double getPresentPeriodOthersProfitability() {
        return presentPeriodOthersProfitability;
    }

    public double getPastPeriodOthersProfitability() {
        return pastPeriodOthersProfitability;
    }

    public double getChangingOfOthersProfitability() {
        return changingOfOthersProfitability;
    }

    public long getPresentPeriodGoodsSales() {
        return presentPeriodGoodsSales;
    }

    public long getPastPeriodGoodsSales() {
        return pastPeriodGoodsSales;
    }

    public long getChangingOfGoodsSales() {
        return changingOfGoodsSales;
    }

    public double getChangingOfGoodsSalesInPercents() {
        return changingOfGoodsSalesInPercents;
    }

    public long getPresentPeriodGoodsMargin() {
        return presentPeriodGoodsMargin;
    }

    public long getPastPeriodGoodsMargin() {
        return pastPeriodGoodsMargin;
    }

    public long getChangingOfGoodsMargin() {
        return changingOfGoodsMargin;
    }

    public double getChangingOfGoodsMarginInPercents() {
        return changingOfGoodsMarginInPercents;
    }

    public long getPresentPeriodGoodsValueAddedTax() {
        return presentPeriodGoodsValueAddedTax;
    }

    public long getPastPeriodGoodsValueAddedTax() {
        return pastPeriodGoodsValueAddedTax;
    }

    public long getChangingOfGoodsValueAddedTax() {
        return changingOfGoodsValueAddedTax;
    }

    public double getChangingOfGoodsValueAddedTaxInPercents() {
        return changingOfGoodsValueAddedTaxInPercents;
    }

    public double getPresentPeriodGoodsProfitability() {
        return presentPeriodGoodsProfitability;
    }

    public double getPastPeriodGoodsProfitability() {
        return pastPeriodGoodsProfitability;
    }

    public double getChangingOfGoodsProfitability() {
        return changingOfGoodsProfitability;
    }

    public long getPresentPeriodProductionSales() {
        return presentPeriodProductionSales;
    }

    public long getPastPeriodProductionSales() {
        return pastPeriodProductionSales;
    }

    public long getChangingOfProductionSales() {
        return changingOfProductionSales;
    }

    public double getChangingOfProductionSalesInPercents() {
        return changingOfProductionSalesInPercents;
    }

    public long getPresentPeriodProductionMargin() {
        return presentPeriodProductionMargin;
    }

    public long getPastPeriodProductionMargin() {
        return pastPeriodProductionMargin;
    }

    public long getChangingOfProductionMargin() {
        return changingOfProductionMargin;
    }

    public double getChangingOfProductionMarginInPercents() {
        return changingOfProductionMarginInPercents;
    }

    public long getPresentPeriodProductionValueAddedTax() {
        return presentPeriodProductionValueAddedTax;
    }

    public long getPastPeriodProductionValueAddedTax() {
        return pastPeriodProductionValueAddedTax;
    }

    public long getChangingOfProductionValueAddedTax() {
        return changingOfProductionValueAddedTax;
    }

    public double getChangingOfProductionValueAddedTaxInPercents() {
        return changingOfProductionValueAddedTaxInPercents;
    }

    public double getPresentPeriodProductionProfitability() {
        return presentPeriodProductionProfitability;
    }

    public double getPastPeriodProductionProfitability() {
        return pastPeriodProductionProfitability;
    }

    public double getChangingOfProductionProfitability() {
        return changingOfProductionProfitability;
    }

    public long getPresentPeriodAllSales() {
        return presentPeriodAllSales;
    }

    public long getPastPeriodAllSales() {
        return pastPeriodAllSales;
    }

    public long getChangingOfAllSales() {
        return changingOfAllSales;
    }

    public double getChangingOfAllSalesInPercents() {
        return changingOfAllSalesInPercents;
    }

    public long getPresentPeriodAllMargin() {
        return presentPeriodAllMargin;
    }

    public long getPastPeriodAllMargin() {
        return pastPeriodAllMargin;
    }

    public long getChangingOfAllMargin() {
        return changingOfAllMargin;
    }

    public double getChangingOfAllMarginInPercents() {
        return changingOfAllMarginInPercents;
    }

    public long getPresentPeriodAllValueAddedTax() {
        return presentPeriodAllValueAddedTax;
    }

    public long getPastPeriodAllValueAddedTax() {
        return pastPeriodAllValueAddedTax;
    }

    public long getChangingOfAllValueAddedTax() {
        return changingOfAllValueAddedTax;
    }

    public double getChangingOfAllValueAddedTaxInPercents() {
        return changingOfAllValueAddedTaxInPercents;
    }

    public double getPresentPeriodAllProfitability() {
        return presentPeriodAllProfitability;
    }

    public double getPastPeriodAllProfitability() {
        return pastPeriodAllProfitability;
    }

    public double getChangingOfAllProfitability() {
        return changingOfAllProfitability;
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

    public long getPresentPeriodAllExpenses() {
        return presentPeriodAllExpenses;
    }

    public long getPastPeriodAllExpenses() {
        return pastPeriodAllExpenses;
    }

    public long getChangingOfAllExpenses() {
        return changingOfAllExpenses;
    }

    public double getChangingOfAllExpensesInPercents() {
        return changingOfAllExpensesInPercents;
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

    public double getPresentPeriodLabourCostOnTonn() {
        return presentPeriodLabourCostOnTonn;
    }

    public double getPastPeriodLabourCostOnTonn() {
        return pastPeriodLabourCostOnTonn;
    }

    public double getChangingOfLabourCostOnTonn() {
        return changingOfLabourCostOnTonn;
    }

    public double getChangingOfLabourCostOnTonnInPercents() {
        return changingOfLabourCostOnTonnInPercents;
    }
}
