package com.epam.financial_analytics.util;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ActionUtil {
    private static int oneMonth = 1;
    private static int oneYear = 12;

    public static ReportWithOrganizationDao getDao(String kindOfReport){
     ReportWithOrganizationDao dao;
      if (kindOfReport.equals(NUMBER_OF_STUFF)){
          dao = new NumberOfStuffDaoImpl();
      } else if (kindOfReport.equals(LABOUR_COST)){
          dao = new LabourCostDaoImpl();
      } else if (kindOfReport.equals(SALES_OF_SQUARE_METRES)){
          dao = new SalesOfSquareMetresDaoImpl();
      } else if (kindOfReport.equals(SALES_OF_TONS)){
          dao = new SalesOfTonsDaoImpl();
      } else {
          dao = new RevenueDaoImpl();
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
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }

    public static int countAmountOfMonths(Date startDate, Date finishDate) {
        return Period.between(startDate.toLocalDate(), finishDate.toLocalDate()).getMonths() + oneMonth;
    }

    public static Map<Integer, Long> getMapWithCurrency(List<Report> reportList, List<CurrencyExchangeRate> currencyExchangeRateList, String currency){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        long indicatorSum;

        for (int i = 0; i < oneYear; i++){
            if (i < reportList.size()){
                if (currency.equals(CURRENCY_KZT) || currency.equals(CURRENCY_RUB)){
                    indicatorSum = (long)(reportList.get(i).getAmount() * currencyExchangeRateList.get(i).getCurrencyExchangeRate());
                    reportMap.put(i, indicatorSum);
                    totalAmount += indicatorSum;
                }
                if (currency.equals(CURRENCY_USD)){
                    indicatorSum =(long) (reportList.get(i).getAmount() / currencyExchangeRateList.get(i).getCurrencyExchangeRate());
                    reportMap.put(i, indicatorSum);
                    totalAmount += indicatorSum;
                }
            } else {
                reportMap.put(i, 0L);
            }
        }

        reportMap.put(oneYear, totalAmount);
        return reportMap;
    }

    public static Map<Integer, Long> getMap(List<Report> reportList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        long indicatorSum;

        for (int i = 0; i < oneYear; i++){
            if (i < reportList.size()){
                    indicatorSum = reportList.get(i).getAmount();
                    reportMap.put(i, indicatorSum);
                    totalAmount += indicatorSum;
            } else {
                reportMap.put(i, 0L);
            }
        }

        reportMap.put(oneYear, totalAmount);
        return reportMap;
    }

    public static Map<Integer,Long> getTotalMap (Map<String, Map<Integer,Long>> totalReportMap, List<OrganizationUnit> organizationUnitList){
        Map<Integer, Long> reportMap = new HashMap<>();
        long totalAmount = 0L;
        for(int i = 0; i <= oneYear; i++){
            for (OrganizationUnit organizationUnit : organizationUnitList) {
                totalAmount = totalAmount + totalReportMap.get(organizationUnit.getName()).get(i);
            }
            reportMap.put(i, totalAmount);
            totalAmount = 0L;
        }
        return reportMap;
    }
}
