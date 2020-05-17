package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.ExpenseInfoDao;
import com.epam.financial_analytics.dao.ProductGroupSalesDao;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static com.epam.financial_analytics.logic.LogicConstant.*;

public class IndicatorUtil {

    public static double countPercent(long present, long past) {
        double d = (present * HUNDRED_PERCENT / past) - HUNDRED_PERCENT;
        return roundUp(d);
    }

    public static long countPercentOneToAnother(long one, long another) {
        long d = one * (long)HUNDRED_PERCENT / another;
        return d;
    }

    public static long countOneToAnother(long one, long another) {
        long d = one / another;
        return d;
    }

    public static long countOneToAnotherInMonth(long one, long another, int amountOfMonth) {
        long d = one / another / amountOfMonth;
        return d;
    }

    public static long countProfitability(long margin, long sales, long valueAddedTax) {
        long d;
        if (sales != 0) {
            d = margin * (long)HUNDRED_PERCENT/ (sales - valueAddedTax);
        } else {
            d = 0;
        }
        return d;
    }

    public static double roundUp(double sum) {
        sum = sum * HUNDRED_PERCENT;
        double i = Math.round(sum);
        sum = i / HUNDRED_PERCENT;

        return sum;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnit(ReportWithOrganizationDao dao, Date startDate, Date finishDate, String organizationUnitName) {
        List<Report>  list = dao.getByDateAndOrganizationUnit(startDate, finishDate, organizationUnitName);
        Collections.sort(list, Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumList(ReportWithOrganizationDao dao, Date startDate, Date finishDate) {
        List<Report>  list = dao.getByDate(startDate, finishDate);
        Collections.sort(list, Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnitAndExpenseType(ExpenseInfoDao dao, Date startDate, Date finishDate,
                                                                                           String organizationUnitName, String expeneType) {
        List<Report>  list = dao.getByDateAndOrganizationUnitAndExpense(startDate, finishDate, organizationUnitName, expeneType);
        Collections.sort(list, Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListAndExpenseType(ExpenseInfoDao dao, Date startDate, Date finishDate, String expenseType) {
        List<Report>  list = dao.getByDateAndExpense(startDate, finishDate, expenseType);
        Collections.sort(list, Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListWithOrganizationUnitAndProductGroup(ProductGroupSalesDao dao, Date startDate, Date finishDate,
                                                                                       String organizationUnitName, String productGroup) {
        List<Report>  list = dao.getByDateAndOrganizationUnitAndProductGroup(startDate, finishDate, organizationUnitName, productGroup);
        Collections.sort(list, Report.dateSort);
        return list;
    }

    public static List<Report> fillIndicatorSumListAndProductGroup(ProductGroupSalesDao dao, Date startDate, Date finishDate, String expenseType) {
        List<Report>  list = dao.getByDateAndProductGroup(startDate, finishDate, expenseType);
        Collections.sort(list, Report.dateSort);
        return list;
    }


    public static long fillIndicatorSumWithCurrency(List<Report> list, String currencyName, List<CurrencyExchangeRate> currencyList) {
        long indicatorSum = 0;
        int currencyIndex = 0;

        if (currencyName.equals(CURRENCY_KZT)  || currencyName.equals(CURRENCY_RUB)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDate().equals(currencyList.get(currencyIndex).getDate())) {
                    indicatorSum = indicatorSum + (long)(list.get(i).getAmount() * currencyList.get(currencyIndex).getCurrencyExchangeRate());
                } else {
                    currencyIndex++;
                    indicatorSum = indicatorSum + (long)((list.get(i).getAmount() * currencyList.get(currencyIndex).getCurrencyExchangeRate()));
                }
            }
        }

        if (currencyName.equals(CURRENCY_USD)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDate().equals(currencyList.get(currencyIndex).getDate())) {
                    indicatorSum = indicatorSum + (long)(list.get(i).getAmount() / currencyList.get(currencyIndex).getCurrencyExchangeRate());
                } else {
                    currencyIndex++;
                    indicatorSum = indicatorSum + (long)(list.get(i).getAmount() / currencyList.get(currencyIndex).getCurrencyExchangeRate());
                }
            }
        }
        return indicatorSum;
    }

    public static long fillIndicatorSum(List<Report> list) {
        long indicatorSum = 0;

        for (int i = 0; i < list.size(); i++) {
            indicatorSum = indicatorSum + list.get(i).getAmount();
        }
        return indicatorSum;
    }

    public static long fillIndicatorAverageSum(List<Report> list, int amountOfMonths) {
        long indicatorSum = 0;

        for (int i = 0; i < list.size(); i++) {
            indicatorSum = indicatorSum + list.get(i).getAmount();
        }
        return indicatorSum/amountOfMonths;
    }

    public static long fillIndicatorChangingSum(long presentPeriodIndicator, long pastPeriodIndicator){
        long changingOfIndicator = presentPeriodIndicator - pastPeriodIndicator;
        return (changingOfIndicator);
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
}