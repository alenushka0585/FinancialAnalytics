package com.epam.financial_analytics.util;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ActionUtil {
    private static final int ONE_YEAR = 12;

    public static ReportWithOrganizationDao getDao(String kindOfReport){
     ReportWithOrganizationDao dao;
        switch (kindOfReport) {
            case NUMBER_OF_STUFF:
                dao = new NumberOfStuffDaoImpl();
                break;
            case LABOUR_COST:
                dao = new LabourCostDaoImpl();
                break;
            case SALES_OF_SQUARE_METRES:
                dao = new SalesOfSquareMetresDaoImpl();
                break;
            case SALES_OF_TONS:
                dao = new SalesOfTonsDaoImpl();
                break;
            default:
                dao = new RevenueDaoImpl();
                break;
        }
     return dao;
    }

    public static ReportWithOrganization fillReport
            (String kindOfReport, Date date, long amount, OrganizationUnit organizationUnit, Currency currency){
        ReportWithOrganization report;

        if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)) {
            report = new ReportWithOrganization(date, amount, organizationUnit);
        } else {
            report = new ReportWithOrganizationAndCurrency(date, amount, organizationUnit, currency);
        }
        return report;
    }

    public static String md5Apache(String st) {

        return DigestUtils.md5Hex(st);
    }

    public static Map<Integer, Long> getMapWithCurrency(List<Report> reportList,
                                                        List<CurrencyExchangeRate> currencyExchangeRateList, String currency){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        long indicatorSum = 0L;
        int currencyIndex = 0;

        for (int i = 0; i < ONE_YEAR; i++) {
            if (i < currencyExchangeRateList.size()) {
                if (currency.equals(CURRENCY_KZT) || currency.equals(CURRENCY_RUB)) {
                    for (Report report : reportList) {
                        if (!report.getDate().equals(currencyExchangeRateList.get(currencyIndex).getDate())) {
                            totalAmount += indicatorSum;
                            currencyIndex++;
                            i++;
                            indicatorSum =0L;
                        }
                        indicatorSum = indicatorSum + (long) (report.getAmount() *
                                currencyExchangeRateList.get(currencyIndex).getCurrencyExchangeRate());
                        reportMap.put(i, indicatorSum);
                    }
                    totalAmount += indicatorSum;
                }

                if (currency.equals(CURRENCY_USD)) {
                    for (Report report : reportList) {
                        if (!report.getDate().equals(currencyExchangeRateList.get(currencyIndex).getDate())) {
                            totalAmount += indicatorSum;
                            currencyIndex++;
                            i++;
                            indicatorSum = 0L;
                        }
                        indicatorSum = indicatorSum + (long) (reportList.get(i).getAmount() /
                                currencyExchangeRateList.get(currencyIndex).getCurrencyExchangeRate());
                        reportMap.put(i, indicatorSum);
                    }
                    totalAmount += indicatorSum;
                }
            } else {
                reportMap.put(i, 0L);
            }
        }

        reportMap.put(ONE_YEAR, totalAmount);
        return reportMap;
    }

    public static Map<Integer, Long> getMap(List<Report> reportList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        long indicatorSum;

        for (int i = 0; i < ONE_YEAR; i++){
            if (i < reportList.size()){
                    indicatorSum = reportList.get(i).getAmount();
                    reportMap.put(i, indicatorSum);
                    totalAmount += indicatorSum;
            } else {
                reportMap.put(i, 0L);
            }
        }

        reportMap.put(ONE_YEAR, totalAmount);
        return reportMap;
    }

    public static Map<Integer,Long> getTotalMapForOrganizationUnit
            (Map<String, Map<Integer,Long>> totalReportMap, List<OrganizationUnit> organizationUnitList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        for(int i = 0; i <= ONE_YEAR; i++){
            for (OrganizationUnit organizationUnit : organizationUnitList) {
                totalAmount = totalAmount + totalReportMap.get(organizationUnit.getName()).get(i);
            }
            reportMap.put(i, totalAmount);
            totalAmount = 0L;
        }
        return reportMap;
    }

    public static Map<Integer,Long> getTotalMapForExpenses
            (Map<String, Map<Integer,Long>> totalExpenseMap,
             List<ExpenseType> expenseTypeList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;

        for(int i = 0; i <= ONE_YEAR; i++){
            for (ExpenseType expenseType : expenseTypeList) {
                totalAmount = totalAmount + totalExpenseMap.get(expenseType.getName()).get(i);
            }
            reportMap.put(i, totalAmount);
            totalAmount = 0L;
        }
        return reportMap;
    }

    public static Map<Integer,Long> getTotalMapForProductGroup
            (Map<String, Map<Integer,Long>> productGroupMap,
             List<ProductGroup> productGroupList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;

        for(int i = 0; i <= ONE_YEAR; i++){
            for (ProductGroup productGroup : productGroupList) {
                totalAmount = totalAmount + productGroupMap.get(productGroup.getName()).get(i);
            }
            reportMap.put(i, totalAmount);
            totalAmount = 0L;
        }
        return reportMap;
    }
}
