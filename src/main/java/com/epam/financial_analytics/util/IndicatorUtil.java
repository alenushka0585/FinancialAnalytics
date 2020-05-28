package com.epam.financial_analytics.util;

import com.epam.financial_analytics.dao.ExpenseInfoDao;
import com.epam.financial_analytics.dao.ProductGroupSalesDao;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import java.sql.Date;
import java.util.List;


public class IndicatorUtil {
    public static final double HUNDRED_PERCENT = 100;
    public static final String CURRENCY_KZT = "KZT";
    public static final String CURRENCY_USD = "USD";
    public static final String CURRENCY_RUB = "RUB";

    public static double countPercent(long present, long past) {
        double percent;
        if (past < 0){
            percent = HUNDRED_PERCENT - (present * HUNDRED_PERCENT / past);
        } else {
            percent = (present * HUNDRED_PERCENT / past) - HUNDRED_PERCENT;
        }
        return roundUp(percent);
    }

    public static long countPercentOneToAnother(long one, long another) {
        return one * (long)HUNDRED_PERCENT / another;
    }

    public static long countOneToAnother(long one, long another) {
        return one / another;
    }

    public static long countOneToAnotherInMonth(long one, long another, int amountOfMonth) {
        return one / another / amountOfMonth;
    }

    public static long countProfitability(long margin, long sales, long valueAddedTax) {
        long profitability;
        if (sales != 0) {
            profitability = margin * (long)HUNDRED_PERCENT/ (sales - valueAddedTax);
        } else {
            profitability = 0;
        }
        return profitability;
    }

    public static double roundUp(double sum) {
        sum = sum * HUNDRED_PERCENT;
        double roundedSum = Math.round(sum);
        sum = roundedSum / HUNDRED_PERCENT;

        return sum;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnit
            (ReportWithOrganizationDao dao, Date startDate, Date finishDate, String organizationUnitName) {
        List<Report>  list = dao.getByDateAndOrganizationUnit(startDate, finishDate, organizationUnitName);
        list.sort(Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumList(ReportWithOrganizationDao dao, Date startDate, Date finishDate) {
        List<Report>  list = dao.getByDate(startDate, finishDate);
        list.sort(Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnitAndExpenseType
            (ExpenseInfoDao dao, Date startDate, Date finishDate, String organizationUnitName, String expeneType) {
        List<Report>  list = dao.getByDateAndOrganizationUnitAndExpense(startDate, finishDate, organizationUnitName, expeneType);
        list.sort(Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListAndExpenseType
            (ExpenseInfoDao dao, Date startDate, Date finishDate, String expenseType) {
        List<Report>  list = dao.getByDateAndExpense(startDate, finishDate, expenseType);
        list.sort(Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnitAndProductGroup
            (ProductGroupSalesDao dao, Date startDate, Date finishDate, String organizationUnitName, String productGroup) {
        List<Report>  list = dao.getByDateAndOrganizationUnitAndProductGroup(startDate, finishDate, organizationUnitName, productGroup);
        list.sort(Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListAndProductGroup
            (ProductGroupSalesDao dao, Date startDate, Date finishDate, String expenseType) {
        List<Report>  list = dao.getByDateAndProductGroup(startDate, finishDate, expenseType);
        list.sort(Report.dateSort);
        return list;
    }

    public static long fillIndicatorSumWithCurrency
            (List<Report> list, String currencyName, List<CurrencyExchangeRate> currencyList) {
        long indicatorSum = 0;
        int currencyIndex = 0;

        if (currencyName.equals(CURRENCY_KZT)  || currencyName.equals(CURRENCY_RUB)) {
            for (Report report : list) {
                if (!report.getDate().equals(currencyList.get(currencyIndex).getDate())) {
                    currencyIndex++;
                }
                indicatorSum = indicatorSum + (long) (report.getAmount() * currencyList.get(currencyIndex).getCurrencyExchangeRate());
            }
        }

        if (currencyName.equals(CURRENCY_USD)) {
            for (Report report : list) {
                if (!report.getDate().equals(currencyList.get(currencyIndex).getDate())) {
                    currencyIndex++;
                }
                indicatorSum = indicatorSum + (long) (report.getAmount() / currencyList.get(currencyIndex).getCurrencyExchangeRate());
            }
        }
        return indicatorSum;
    }

    public static long fillIndicatorSum(List<Report> list) {
        long indicatorSum = 0;

        for (Report report : list) {
            indicatorSum = indicatorSum + report.getAmount();
        }
        return indicatorSum;
    }

    public static long fillIndicatorAverageSum(List<Report> list, int amountOfMonths) {
        long indicatorSum = 0;

        for (Report report : list) {
            indicatorSum = indicatorSum + report.getAmount();
        }
        return indicatorSum/amountOfMonths;
    }

    public static long fillIndicatorChangingSum(long presentPeriodIndicator, long pastPeriodIndicator){
        return (presentPeriodIndicator - pastPeriodIndicator);
    }

    public static double fillIndicatorChangingInPercent(long presentPeriodIndicator, long pastPeriodIndicator){
        double changingOfIndicatorInPercent;

        if (presentPeriodIndicator == 0){
            changingOfIndicatorInPercent = -100;
        } else  if (pastPeriodIndicator == 0) {
            changingOfIndicatorInPercent = 100;
        } else {
            changingOfIndicatorInPercent = IndicatorUtil.countPercent(presentPeriodIndicator, pastPeriodIndicator);
        }
        return changingOfIndicatorInPercent;
    }

    public static long fillTotalIndicator(long ... indicators){
        long total = 0L;
        for (long indicator : indicators){
            total+=indicator;
        }
        return total;
    }
}