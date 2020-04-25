package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ProductGroupSalesDaoImpl;
import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;

import java.sql.Date;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstants.*;

public class ProductGroupIndicator extends Indicator {
    private ProductGroupSalesDaoImpl productGroupSalesDao = new ProductGroupSalesDaoImpl();
    private List<ProductGroupSales> productGroupSalesList;

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

    public ProductGroupIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }
    
    public long setProductGroupSalesSumWithOrganizationPresentPeriod(String organizationUnitName, String productGroupName) {
        List<ProductGroupSales> productGroupSalesListPresent =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName, productGroupName);
        long sum = 0;

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPresent.get(i).getSalesSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                sum = sum + (long)(productGroupSalesListPresent.get(i).getSalesSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setProductGroupMarginSumWithOrganizationPresentPeriod(String organizationUnitName, String productGroupName) {
        List<ProductGroupSales> productGroupSalesListPresent =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName, productGroupName);
        long sum = 0;

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPresent.get(i).getMarginSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {

                sum = sum + (long)(productGroupSalesListPresent.get(i).getMarginSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setProductGroupVATSumWithOrganizationPresentPeriod(String organizationUnitName, String productGroupName) {
        List<ProductGroupSales> productGroupSalesListPresent =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPresentPeriodStartDate(), getPresentPeriodFinishDate(), organizationUnitName, productGroupName);
        long sum = 0;

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPresent.get(i).getValueAddedTaxSum() * getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                sum = sum + (long)(productGroupSalesListPresent.get(i).getValueAddedTaxSum() / getPresentPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setProductGroupSalesSumWithOrganizationPastPeriod(String organizationUnitName, String productGroupName) {
        long sum = 0;
        List<ProductGroupSales> productGroupSalesListPast =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName, productGroupName);

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getSalesSum() * getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getSalesSum() / getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setProductGroupMarginSumWithOrganizationPastPeriod(String organizationUnitName, String productGroupName) {
        long sum = 0;
        List<ProductGroupSales> productGroupSalesListPast =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName, productGroupName);

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getMarginSum() * getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getMarginSum() / getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }

    public long setProductGroupVATSumWithOrganizationPastPeriod(String organizationUnitName, String productGroupName) {
        long sum = 0;
        List<ProductGroupSales> productGroupSalesListPast =
                productGroupSalesDao.getByDateAndOrganizationUnitAndProductGroup(getPastPeriodStartDate(), getPastPeriodFinishDate(), organizationUnitName, productGroupName);

        if (getCurrencyName() == getCurrencyKzt() || getCurrencyName() == getCurrencyRub()) {
            for (int i = 0; i < getAmountOfMonths(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getValueAddedTaxSum() * getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }

        if (getCurrencyName() == getCurrencyUsd()) {
            for (int i = 0; i < getPresentPeriodCurrencyList().size(); i++) {
                sum = sum + (long)(productGroupSalesListPast.get(i).getValueAddedTaxSum() / getPastPeriodCurrencyList().get(i).getExchangeRate());
            }
        }
        return sum;
    }
    public void setOVPSalesSum(String organizationUnitName){
        presentPeriodOVPSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,OVP);
        presentPeriodOVPMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, OVP);
        presentPeriodOVPValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, OVP);

        pastPeriodOVPSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,OVP);
        pastPeriodOVPMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, OVP);
        pastPeriodOVPValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, OVP);

        changingOfOVPSales = presentPeriodOVPSales-pastPeriodOVPSales;
        changingOfOVPSalesInPercents = Util.countPercent(presentPeriodOVPSales,pastPeriodOVPSales);

        changingOfOVPMargin = presentPeriodOVPMargin-pastPeriodOVPMargin;
        changingOfOVPMarginInPercents = Util.countPercent(presentPeriodOVPMargin,pastPeriodOVPMargin);


        presentPeriodOVPProfitability = Util.countProfitability(presentPeriodOVPMargin, presentPeriodOVPSales, presentPeriodOVPValueAddedTax);
        pastPeriodOVPProfitability = Util.countProfitability(pastPeriodOVPMargin, pastPeriodOVPSales, pastPeriodOVPValueAddedTax);;

        changingOfOVPProfitability = presentPeriodOVPProfitability - pastPeriodOVPProfitability;
    }

    public void setTSPSalesSum(String organizationUnitName){
        presentPeriodTSPSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,TSP);
        presentPeriodTSPMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, TSP);
        presentPeriodTSPValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, TSP);

        pastPeriodTSPSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,TSP);
        pastPeriodTSPMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, TSP);
        pastPeriodTSPValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, TSP);

        changingOfTSPSales = presentPeriodTSPSales-pastPeriodTSPSales;
        changingOfTSPSalesInPercents = Util.countPercent(presentPeriodTSPSales,pastPeriodTSPSales);

        changingOfTSPMargin = presentPeriodTSPMargin-pastPeriodTSPMargin;
        changingOfTSPMarginInPercents = Util.countPercent(presentPeriodTSPMargin, pastPeriodTSPMargin);

        presentPeriodTSPProfitability = Util.countProfitability(presentPeriodTSPMargin, presentPeriodTSPSales, presentPeriodTSPValueAddedTax);
        pastPeriodTSPProfitability = Util.countProfitability(pastPeriodTSPMargin, pastPeriodTSPSales, pastPeriodTSPValueAddedTax);
        changingOfTSPProfitability = presentPeriodTSPProfitability - pastPeriodTSPProfitability;
    }

    public void setVSSalesSum(String organizationUnitName){
        presentPeriodVSSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,VS);
        presentPeriodVSMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, VS);
        presentPeriodVSValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, VS);

        pastPeriodVSSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,VS);
        pastPeriodVSMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, VS);
        pastPeriodVSValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, VS);

        changingOfVSSales = presentPeriodVSSales-pastPeriodVSSales;
        changingOfVSSalesInPercents = Util.countPercent(presentPeriodVSSales, pastPeriodVSSales);

        changingOfVSMargin = presentPeriodVSMargin-pastPeriodVSMargin;
        changingOfVSMarginInPercents = Util.countPercent(presentPeriodVSMargin,pastPeriodVSMargin);

        presentPeriodVSProfitability = Util.countProfitability(presentPeriodVSMargin, presentPeriodVSSales, presentPeriodVSValueAddedTax);
        pastPeriodVSProfitability = Util.countProfitability(pastPeriodVSMargin, pastPeriodVSSales, pastPeriodVSValueAddedTax);
        changingOfVSProfitability = presentPeriodVSProfitability - pastPeriodVSProfitability;
    }

    public void setSEOSalesSum(String organizationUnitName){
        presentPeriodSEOSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,SEO);
        presentPeriodSEOMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, SEO);
        presentPeriodSEOValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, SEO);

        pastPeriodSEOSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,SEO);
        pastPeriodSEOMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, SEO);
        pastPeriodSEOValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, SEO);

        changingOfSEOSales = presentPeriodSEOSales-pastPeriodSEOSales;
        changingOfSEOSalesInPercents = Util.countPercent(presentPeriodSEOSales, pastPeriodSEOSales);

        changingOfSEOMargin = presentPeriodSEOMargin-pastPeriodSEOMargin;
        changingOfSEOMarginInPercents = Util.countPercent(presentPeriodSEOMargin, pastPeriodSEOMargin);

        presentPeriodSEOProfitability = Util.countProfitability(presentPeriodSEOMargin, presentPeriodSEOSales, presentPeriodSEOValueAddedTax);
        pastPeriodSEOProfitability = Util.countProfitability(pastPeriodSEOMargin, pastPeriodSEOSales, pastPeriodSEOValueAddedTax);
        changingOfSEOProfitability = presentPeriodSEOProfitability - pastPeriodSEOProfitability;
    }

    public void setENKSalesSum(String organizationUnitName){
        presentPeriodENKSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,ENK);
        presentPeriodENKMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, ENK);
        presentPeriodENKValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, ENK);

        pastPeriodENKSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,ENK);
        pastPeriodENKMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, ENK);
        pastPeriodENKValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, ENK);

        changingOfENKSales = presentPeriodENKSales-pastPeriodENKSales;
        changingOfENKSalesInPercents = Util.countPercent(presentPeriodENKSales, pastPeriodENKSales);

        changingOfENKMargin = presentPeriodENKMargin-pastPeriodENKMargin;
        changingOfENKMarginInPercents = Util.countPercent(presentPeriodENKMargin,pastPeriodENKMargin);

        presentPeriodENKProfitability = Util.countProfitability(presentPeriodENKMargin, presentPeriodENKSales, presentPeriodENKValueAddedTax);
        pastPeriodENKProfitability = Util.countProfitability(pastPeriodENKMargin, pastPeriodENKSales, pastPeriodENKValueAddedTax);
        changingOfENKProfitability = presentPeriodENKProfitability - pastPeriodENKProfitability;
    }

    public void setEBKSalesSum(String organizationUnitName){
        presentPeriodEBKSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,EBK);
        presentPeriodEBKMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, EBK);
        presentPeriodEBKValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, EBK);

        pastPeriodEBKSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,EBK);
        pastPeriodEBKMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, EBK);
        pastPeriodEBKValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, EBK);

        changingOfEBKSales = presentPeriodEBKSales-pastPeriodEBKSales;
        changingOfEBKSalesInPercents = Util.countPercent(presentPeriodEBKSales, pastPeriodEBKSales);

        changingOfEBKMargin = presentPeriodEBKMargin-pastPeriodEBKMargin;
        changingOfEBKMarginInPercents = Util.countPercent(presentPeriodEBKMargin, pastPeriodEBKMargin);

        presentPeriodEBKProfitability = Util.countProfitability(presentPeriodEBKMargin, presentPeriodEBKSales, presentPeriodEBKValueAddedTax);
        pastPeriodEBKProfitability = Util.countProfitability(pastPeriodEBKMargin, pastPeriodEBKSales, pastPeriodEBKValueAddedTax);
        changingOfEBKProfitability = presentPeriodEBKProfitability - pastPeriodEBKProfitability;
    }

    public void setSPPSSalesSum(String organizationUnitName){
        presentPeriodSPPSSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,SPPS);
        presentPeriodSPPSMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, SPPS);
        presentPeriodSPPSValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, SPPS);

        pastPeriodSPPSSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,SPPS);
        pastPeriodSPPSMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, SPPS);
        pastPeriodSPPSValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, SPPS);

        changingOfSPPSSales = presentPeriodSPPSSales-pastPeriodSPPSSales;
        changingOfSPPSSalesInPercents = Util.countPercent(presentPeriodSPPSSales, pastPeriodSPPSSales);

        changingOfSPPSMargin = presentPeriodSPPSMargin-pastPeriodSPPSMargin;
        changingOfSPPSMarginInPercents = Util.countPercent(presentPeriodSPPSMargin, pastPeriodSPPSMargin);

        presentPeriodSPPSProfitability = Util.countProfitability(presentPeriodSPPSMargin, presentPeriodSPPSSales, presentPeriodSPPSValueAddedTax);
        pastPeriodSPPSProfitability = Util.countProfitability(pastPeriodSPPSMargin, pastPeriodSPPSSales, pastPeriodSPPSValueAddedTax);
        changingOfSPPSProfitability = presentPeriodSPPSProfitability - pastPeriodSPPSProfitability;
    }

    public void setFKSalesSum(String organizationUnitName){
        presentPeriodFKSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,FK);
        presentPeriodFKMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, FK);
        presentPeriodFKValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, FK);

        pastPeriodFKSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,FK);
        pastPeriodFKMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, FK);
        pastPeriodFKValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, FK);

        changingOfFKSales = presentPeriodFKSales-pastPeriodFKSales;
        changingOfFKSalesInPercents = Util.countPercent(presentPeriodFKSales, pastPeriodFKSales);

        changingOfFKMargin = presentPeriodFKMargin-pastPeriodFKMargin;
        changingOfFKMarginInPercents = Util.countPercent(presentPeriodFKMargin, pastPeriodFKMargin);

        presentPeriodFKProfitability = Util.countProfitability(presentPeriodFKMargin, presentPeriodFKSales, presentPeriodFKValueAddedTax);
        pastPeriodFKProfitability = Util.countProfitability(pastPeriodFKMargin, pastPeriodFKSales, pastPeriodFKValueAddedTax);
        changingOfFKProfitability = presentPeriodFKProfitability - pastPeriodFKProfitability;
    }

    public void setOthersSalesSum(String organizationUnitName){
        presentPeriodOthersSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,OTHER);
        presentPeriodOthersMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, OTHER);
        presentPeriodOthersValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, OTHER);

        pastPeriodOthersSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,OTHER);
        pastPeriodOthersMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, OTHER);
        pastPeriodOthersValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, OTHER);

        changingOfOthersSales = presentPeriodOthersSales-pastPeriodOthersSales;
        changingOfOthersSalesInPercents = Util.countPercent(presentPeriodOthersSales, pastPeriodOthersSales);

        changingOfOthersMargin = presentPeriodOthersMargin-pastPeriodOthersMargin;
        changingOfOthersMarginInPercents = Util.countPercent(presentPeriodOthersMargin, pastPeriodOthersMargin);

        presentPeriodOthersProfitability = Util.countProfitability(presentPeriodOthersMargin, presentPeriodOthersSales, presentPeriodOthersValueAddedTax);
        pastPeriodOthersProfitability = Util.countProfitability(pastPeriodOthersMargin, pastPeriodOthersSales, pastPeriodOthersValueAddedTax);
        changingOfOthersProfitability = presentPeriodOthersProfitability - pastPeriodOthersProfitability;
    }

    public void setGoodsSalesSum(String organizationUnitName){
        presentPeriodGoodsSales = setProductGroupSalesSumWithOrganizationPresentPeriod(organizationUnitName,GOODS);
        presentPeriodGoodsMargin = setProductGroupMarginSumWithOrganizationPresentPeriod(organizationUnitName, GOODS);
        presentPeriodGoodsValueAddedTax = setProductGroupVATSumWithOrganizationPresentPeriod(organizationUnitName, GOODS);

        pastPeriodGoodsSales = setProductGroupSalesSumWithOrganizationPastPeriod(organizationUnitName,GOODS);
        pastPeriodGoodsMargin = setProductGroupMarginSumWithOrganizationPastPeriod(organizationUnitName, GOODS);
        pastPeriodGoodsValueAddedTax = setProductGroupVATSumWithOrganizationPastPeriod(organizationUnitName, GOODS);

        changingOfGoodsSales = presentPeriodGoodsSales-pastPeriodGoodsSales;
        changingOfGoodsSalesInPercents = Util.countPercent(presentPeriodGoodsSales, pastPeriodGoodsSales);

        changingOfGoodsMargin = presentPeriodGoodsMargin-pastPeriodGoodsMargin;
        changingOfGoodsMarginInPercents = Util.countPercent(presentPeriodGoodsMargin, pastPeriodGoodsMargin);

        presentPeriodGoodsProfitability = Util.countProfitability(presentPeriodGoodsMargin, presentPeriodGoodsSales, presentPeriodGoodsValueAddedTax);
        pastPeriodGoodsProfitability = Util.countProfitability(pastPeriodGoodsMargin, pastPeriodGoodsSales, pastPeriodGoodsValueAddedTax);
        changingOfGoodsProfitability = presentPeriodGoodsProfitability - pastPeriodGoodsProfitability;
    }

    public void setProductionSalesSum(){
        presentPeriodProductionSales = presentPeriodOVPSales + presentPeriodTSPSales + presentPeriodVSSales + presentPeriodSEOSales + presentPeriodENKSales +
                presentPeriodEBKSales + presentPeriodSPPSSales + presentPeriodFKSales + presentPeriodOthersSales;

        presentPeriodProductionMargin = presentPeriodOVPMargin + presentPeriodTSPMargin + presentPeriodVSMargin + presentPeriodSEOMargin + presentPeriodENKMargin +
                presentPeriodEBKMargin + presentPeriodSPPSMargin + presentPeriodFKMargin + presentPeriodOthersMargin;

        presentPeriodProductionValueAddedTax = presentPeriodOVPValueAddedTax + presentPeriodTSPValueAddedTax + presentPeriodVSValueAddedTax +
                presentPeriodSEOValueAddedTax + presentPeriodENKValueAddedTax + presentPeriodEBKValueAddedTax +
                presentPeriodSPPSValueAddedTax + presentPeriodFKValueAddedTax + presentPeriodOthersValueAddedTax;

        pastPeriodProductionSales = pastPeriodOVPSales + pastPeriodTSPSales + pastPeriodVSSales + pastPeriodSEOSales + pastPeriodENKSales +
                pastPeriodEBKSales + pastPeriodSPPSSales + pastPeriodFKSales + pastPeriodOthersSales;

        pastPeriodProductionMargin = pastPeriodOVPMargin + pastPeriodTSPMargin + pastPeriodVSMargin + pastPeriodSEOMargin + pastPeriodENKMargin +
                pastPeriodEBKMargin + pastPeriodSPPSMargin + pastPeriodFKMargin + pastPeriodOthersMargin;

        pastPeriodProductionValueAddedTax = pastPeriodOVPValueAddedTax + pastPeriodTSPValueAddedTax + pastPeriodVSValueAddedTax +
                pastPeriodSEOValueAddedTax + pastPeriodENKValueAddedTax + pastPeriodEBKValueAddedTax +
                pastPeriodSPPSValueAddedTax + pastPeriodFKValueAddedTax + pastPeriodOthersValueAddedTax;

        changingOfProductionSales = presentPeriodProductionSales-pastPeriodProductionSales;
        changingOfProductionSalesInPercents = Util.countPercent(presentPeriodProductionSales,pastPeriodProductionSales);

        changingOfProductionMargin = presentPeriodProductionMargin-pastPeriodProductionMargin;
        changingOfProductionMarginInPercents = Util.countPercent(presentPeriodProductionMargin, pastPeriodProductionMargin);;

        presentPeriodProductionProfitability = Util.countProfitability(presentPeriodProductionMargin, presentPeriodProductionSales, presentPeriodProductionValueAddedTax);
        pastPeriodProductionProfitability = Util.countProfitability(pastPeriodProductionMargin, pastPeriodProductionSales, pastPeriodProductionValueAddedTax);
        changingOfProductionProfitability = presentPeriodProductionProfitability - pastPeriodProductionProfitability;
    }

    public void setAllSalesSum(){
        presentPeriodAllSales = presentPeriodProductionSales + presentPeriodGoodsSales;
        presentPeriodAllMargin = presentPeriodProductionMargin + presentPeriodGoodsMargin;
        presentPeriodAllValueAddedTax = presentPeriodProductionValueAddedTax + presentPeriodGoodsValueAddedTax;

        pastPeriodAllSales = pastPeriodProductionSales + pastPeriodGoodsSales;
        pastPeriodAllMargin = pastPeriodProductionMargin + pastPeriodGoodsMargin;
        pastPeriodAllValueAddedTax = pastPeriodProductionValueAddedTax + pastPeriodGoodsValueAddedTax;

        changingOfAllSales = presentPeriodAllSales-pastPeriodAllSales;
        changingOfAllSalesInPercents = (presentPeriodAllSales * HUNDRED_PERCENTS / pastPeriodAllSales) - HUNDRED_PERCENTS;

        changingOfAllMargin = presentPeriodAllMargin-pastPeriodAllMargin;
        changingOfAllMarginInPercents = (presentPeriodAllMargin * HUNDRED_PERCENTS / pastPeriodAllMargin) - HUNDRED_PERCENTS;

        presentPeriodAllProfitability = Util.countProfitability(presentPeriodAllMargin, presentPeriodAllSales, presentPeriodAllValueAddedTax);
        pastPeriodAllProfitability = Util.countProfitability(pastPeriodAllMargin, pastPeriodAllSales, pastPeriodAllValueAddedTax);
        changingOfAllProfitability = presentPeriodAllProfitability - pastPeriodAllProfitability;
    }

    public void setAllWithOrganizationUnit(String organizationUnitName) {
        setOVPSalesSum(organizationUnitName);
        setTSPSalesSum(organizationUnitName);
        setVSSalesSum(organizationUnitName);
        setSEOSalesSum(organizationUnitName);
        setENKSalesSum(organizationUnitName);
        setEBKSalesSum(organizationUnitName);
        setSPPSSalesSum(organizationUnitName);
        setFKSalesSum(organizationUnitName);
        setOthersSalesSum(organizationUnitName);
        setGoodsSalesSum(organizationUnitName);
        setProductionSalesSum();
        setAllSalesSum();
    }

    public double getChangingOfOVPSalesInPercents() {
        return changingOfOVPSalesInPercents;
    }

    public double getChangingOfOVPMarginInPercents() {
        return changingOfOVPMarginInPercents;
    }

    public double getPresentPeriodOVPProfitability() {
        return presentPeriodOVPProfitability;
    }

    public double getChangingOfOVPProfitability() {
        return changingOfOVPProfitability;
    }

    public double getChangingOfTSPSalesInPercents() {
        return changingOfTSPSalesInPercents;
    }

    public double getChangingOfTSPMarginInPercents() {
        return changingOfTSPMarginInPercents;
    }

    public double getPresentPeriodTSPProfitability() {
        return presentPeriodTSPProfitability;
    }

    public double getPresentPeriodGoodsProfitability() {
        return presentPeriodGoodsProfitability;
    }

    public double getChangingOfGoodsProfitability() {
        return changingOfGoodsProfitability;
    }

    public double getChangingOfProductionSalesInPercents() {
        return changingOfProductionSalesInPercents;
    }

    public double getChangingOfProductionMarginInPercents() {
        return changingOfProductionMarginInPercents;
    }

    public double getPresentPeriodProductionProfitability() {
        return presentPeriodProductionProfitability;
    }

    public double getChangingOfProductionProfitability() {
        return changingOfProductionProfitability;
    }

    public double getChangingOfTSPProfitability() {
        return changingOfTSPProfitability;
    }

    public double getChangingOfVSSalesInPercents() {
        return changingOfVSSalesInPercents;
    }

    public double getChangingOfVSMarginInPercents() {
        return changingOfVSMarginInPercents;
    }

    public double getPresentPeriodVSProfitability() {
        return presentPeriodVSProfitability;
    }

    public double getChangingOfVSProfitability() {
        return changingOfVSProfitability;
    }

    public double getChangingOfSEOSalesInPercents() {
        return changingOfSEOSalesInPercents;
    }

    public double getChangingOfSEOMarginInPercents() {
        return changingOfSEOMarginInPercents;
    }

    public double getPresentPeriodSEOProfitability() {
        return presentPeriodSEOProfitability;
    }

    public double getChangingOfSEOProfitability() {
        return changingOfSEOProfitability;
    }

    public double getChangingOfENKSalesInPercents() {
        return changingOfENKSalesInPercents;
    }

    public double getChangingOfENKMarginInPercents() {
        return changingOfENKMarginInPercents;
    }

    public double getPresentPeriodENKProfitability() {
        return presentPeriodENKProfitability;
    }

    public double getChangingOfENKProfitability() {
        return changingOfENKProfitability;
    }

    public double getChangingOfEBKSalesInPercents() {
        return changingOfEBKSalesInPercents;
    }

    public double getChangingOfEBKMarginInPercents() {
        return changingOfEBKMarginInPercents;
    }

    public double getPresentPeriodEBKProfitability() {
        return presentPeriodEBKProfitability;
    }

    public double getChangingOfEBKProfitability() {
        return changingOfEBKProfitability;
    }

    public double getChangingOfSPPSSalesInPercents() {
        return changingOfSPPSSalesInPercents;
    }

    public double getChangingOfSPPSMarginInPercents() {
        return changingOfSPPSMarginInPercents;
    }

    public double getPresentPeriodSPPSProfitability() {
        return presentPeriodSPPSProfitability;
    }

    public double getChangingOfSPPSProfitability() {
        return changingOfSPPSProfitability;
    }

    public double getChangingOfFKSalesInPercents() {
        return changingOfFKSalesInPercents;
    }

    public double getChangingOfFKMarginInPercents() {
        return changingOfFKMarginInPercents;
    }

    public double getPresentPeriodFKProfitability() {
        return presentPeriodFKProfitability;
    }

    public double getChangingOfFKProfitability() {
        return changingOfFKProfitability;
    }

    public double getChangingOfOthersSalesInPercents() {
        return changingOfOthersSalesInPercents;
    }

    public double getChangingOfOthersMarginInPercents() {
        return changingOfOthersMarginInPercents;
    }

    public double getPresentPeriodOthersProfitability() {
        return presentPeriodOthersProfitability;
    }

    public double getChangingOfOthersProfitability() {
        return changingOfOthersProfitability;
    }

    public double getChangingOfGoodsSalesInPercents() {
        return changingOfGoodsSalesInPercents;
    }

    public double getChangingOfGoodsMarginInPercents() {
        return changingOfGoodsMarginInPercents;
    }

    public long getPresentPeriodOVPSales() {
        return presentPeriodOVPSales;
    }

    public long getPastPeriodOVPSales() {
        return pastPeriodOVPSales;
    }

    public long getPresentPeriodOVPMargin() {
        return presentPeriodOVPMargin;
    }

    public long getPastPeriodOVPMargin() {
        return pastPeriodOVPMargin;
    }

    public long getPresentPeriodOVPValueAddedTax() {
        return presentPeriodOVPValueAddedTax;
    }

    public long getPastPeriodOVPValueAddedTax() {
        return pastPeriodOVPValueAddedTax;
    }

    public double getPastPeriodOVPProfitability() {
        return pastPeriodOVPProfitability;
    }

    public long getPresentPeriodTSPSales() {
        return presentPeriodTSPSales;
    }

    public long getPastPeriodTSPSales() {
        return pastPeriodTSPSales;
    }

    public long getPresentPeriodTSPMargin() {
        return presentPeriodTSPMargin;
    }

    public long getPastPeriodTSPMargin() {
        return pastPeriodTSPMargin;
    }

    public long getPresentPeriodTSPValueAddedTax() {
        return presentPeriodTSPValueAddedTax;
    }

    public long getPastPeriodTSPValueAddedTax() {
        return pastPeriodTSPValueAddedTax;
    }

    public double getPastPeriodTSPProfitability() {
        return pastPeriodTSPProfitability;
    }

    public long getPresentPeriodVSSales() {
        return presentPeriodVSSales;
    }

    public long getPastPeriodVSSales() {
        return pastPeriodVSSales;
    }

    public long getPresentPeriodVSMargin() {
        return presentPeriodVSMargin;
    }

    public long getPastPeriodVSMargin() {
        return pastPeriodVSMargin;
    }

    public long getPresentPeriodVSValueAddedTax() {
        return presentPeriodVSValueAddedTax;
    }

    public long getPastPeriodVSValueAddedTax() {
        return pastPeriodVSValueAddedTax;
    }

    public double getPastPeriodVSProfitability() {
        return pastPeriodVSProfitability;
    }

    public long getPresentPeriodSEOSales() {
        return presentPeriodSEOSales;
    }

    public long getPastPeriodSEOSales() {
        return pastPeriodSEOSales;
    }

    public long getPresentPeriodSEOMargin() {
        return presentPeriodSEOMargin;
    }

    public long getPastPeriodSEOMargin() {
        return pastPeriodSEOMargin;
    }

    public long getPresentPeriodSEOValueAddedTax() {
        return presentPeriodSEOValueAddedTax;
    }

    public long getPastPeriodSEOValueAddedTax() {
        return pastPeriodSEOValueAddedTax;
    }

    public double getPastPeriodSEOProfitability() {
        return pastPeriodSEOProfitability;
    }

    public long getPresentPeriodENKSales() {
        return presentPeriodENKSales;
    }

    public long getPastPeriodENKSales() {
        return pastPeriodENKSales;
    }

    public long getPresentPeriodENKMargin() {
        return presentPeriodENKMargin;
    }

    public long getPastPeriodENKMargin() {
        return pastPeriodENKMargin;
    }

    public long getPresentPeriodENKValueAddedTax() {
        return presentPeriodENKValueAddedTax;
    }

    public long getPastPeriodENKValueAddedTax() {
        return pastPeriodENKValueAddedTax;
    }

    public double getPastPeriodENKProfitability() {
        return pastPeriodENKProfitability;
    }

    public long getPresentPeriodEBKSales() {
        return presentPeriodEBKSales;
    }

    public long getPastPeriodEBKSales() {
        return pastPeriodEBKSales;
    }

    public long getPresentPeriodEBKMargin() {
        return presentPeriodEBKMargin;
    }

    public long getPastPeriodEBKMargin() {
        return pastPeriodEBKMargin;
    }

    public long getPresentPeriodEBKValueAddedTax() {
        return presentPeriodEBKValueAddedTax;
    }

    public long getPastPeriodEBKValueAddedTax() {
        return pastPeriodEBKValueAddedTax;
    }

    public double getPastPeriodEBKProfitability() {
        return pastPeriodEBKProfitability;
    }

    public long getPresentPeriodSPPSSales() {
        return presentPeriodSPPSSales;
    }

    public long getPastPeriodSPPSSales() {
        return pastPeriodSPPSSales;
    }

    public long getPresentPeriodSPPSMargin() {
        return presentPeriodSPPSMargin;
    }

    public long getPastPeriodSPPSMargin() {
        return pastPeriodSPPSMargin;
    }

    public long getPresentPeriodSPPSValueAddedTax() {
        return presentPeriodSPPSValueAddedTax;
    }

    public long getPastPeriodSPPSValueAddedTax() {
        return pastPeriodSPPSValueAddedTax;
    }

    public double getPastPeriodSPPSProfitability() {
        return pastPeriodSPPSProfitability;
    }

    public long getPresentPeriodFKSales() {
        return presentPeriodFKSales;
    }

    public long getPastPeriodFKSales() {
        return pastPeriodFKSales;
    }

    public long getPresentPeriodFKMargin() {
        return presentPeriodFKMargin;
    }

    public long getPastPeriodFKMargin() {
        return pastPeriodFKMargin;
    }

    public long getPresentPeriodFKValueAddedTax() {
        return presentPeriodFKValueAddedTax;
    }

    public long getPastPeriodFKValueAddedTax() {
        return pastPeriodFKValueAddedTax;
    }

    public double getPastPeriodFKProfitability() {
        return pastPeriodFKProfitability;
    }

    public long getPresentPeriodOthersSales() {
        return presentPeriodOthersSales;
    }

    public long getPastPeriodOthersSales() {
        return pastPeriodOthersSales;
    }

    public long getPresentPeriodOthersMargin() {
        return presentPeriodOthersMargin;
    }

    public long getPastPeriodOthersMargin() {
        return pastPeriodOthersMargin;
    }

    public long getPresentPeriodOthersValueAddedTax() {
        return presentPeriodOthersValueAddedTax;
    }

    public long getPastPeriodOthersValueAddedTax() {
        return pastPeriodOthersValueAddedTax;
    }

    public double getPastPeriodOthersProfitability() {
        return pastPeriodOthersProfitability;
    }

    public long getPresentPeriodGoodsSales() {
        return presentPeriodGoodsSales;
    }

    public long getPastPeriodGoodsSales() {
        return pastPeriodGoodsSales;
    }

    public long getPresentPeriodGoodsMargin() {
        return presentPeriodGoodsMargin;
    }

    public long getPastPeriodGoodsMargin() {
        return pastPeriodGoodsMargin;
    }

    public long getPresentPeriodGoodsValueAddedTax() {
        return presentPeriodGoodsValueAddedTax;
    }

    public long getPastPeriodGoodsValueAddedTax() {
        return pastPeriodGoodsValueAddedTax;
    }

    public double getPastPeriodGoodsProfitability() {
        return pastPeriodGoodsProfitability;
    }

    public long getPresentPeriodProductionSales() {
        return presentPeriodProductionSales;
    }

    public long getPastPeriodProductionSales() {
        return pastPeriodProductionSales;
    }

    public long getPresentPeriodProductionMargin() {
        return presentPeriodProductionMargin;
    }

    public long getPastPeriodProductionMargin() {
        return pastPeriodProductionMargin;
    }

    public long getPresentPeriodProductionValueAddedTax() {
        return presentPeriodProductionValueAddedTax;
    }

    public long getPastPeriodProductionValueAddedTax() {
        return pastPeriodProductionValueAddedTax;
    }

    public double getPastPeriodProductionProfitability() {
        return pastPeriodProductionProfitability;
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
}
