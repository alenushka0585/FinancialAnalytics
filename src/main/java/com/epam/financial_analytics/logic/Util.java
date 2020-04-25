package com.epam.financial_analytics.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.epam.financial_analytics.logic.LogicConstants.HUNDRED_PERCENTS;

public class Util {

    public static double HUNDRED_PERCENT = 100;

    public static double  countPercent(long present, long past){
        double d = (present * HUNDRED_PERCENT / past) - HUNDRED_PERCENT;
        return roundUp(d);
    }

    public static double  countPercentOneToAnother(long one, long another){
        double d = (double)one / (double)another * HUNDRED_PERCENT;
        return roundUp(d);
    }

    public static double  countProfitability(long margin, long sales, long valueAddedTax){
        double d;
        if(sales != 0) {
             d = (double)margin / (double)(sales - valueAddedTax) * HUNDRED_PERCENT;
             d = roundUp(d);
        } else {
            d = 0;
        }
        return  d;
    }

    public static double  roundUp(double sum){
        sum = sum * 100;
        int i = (int) Math.round(sum);
        sum = (double)i / 100;

        return sum;
    }
}
