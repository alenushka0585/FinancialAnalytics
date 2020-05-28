package com.epam.financial_analytics.logic;

import com.epam.financial_analytics.dao.impl.ProductGroupDaoImpl;
import com.epam.financial_analytics.entity.abstract_classes.Fillable;
import com.epam.financial_analytics.entity.abstract_classes.Indicator;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;
import com.epam.financial_analytics.util.IndicatorUtil;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalProfitabilityIndicator extends Indicator implements Fillable {
    private TotalSalesIndicator totalSalesIndicator;
    private TotalValueAddedTaxIndicator totalValueAddedTaxIndicator;
    private TotalMarginIndicator totalMarginIndicator;
    private Map<String, ProfitabilityIndicator> profitabilityIndicatorMap = new HashMap<>();
    private ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private List<ProductGroup> productGroupList;

    public TotalProfitabilityIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                       Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalSalesIndicator = new TotalSalesIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalValueAddedTaxIndicator = new TotalValueAddedTaxIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        totalMarginIndicator = new TotalMarginIndicator
                (presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        productGroupList = productGroupDao.getAll();
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        totalSalesIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        totalValueAddedTaxIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        totalMarginIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);

        for (ProductGroup productGroup : productGroupList) {
            ProfitabilityIndicator profitabilityIndicator = new ProfitabilityIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            profitabilityIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup.getName());
            profitabilityIndicatorMap.put(productGroup.getName(), profitabilityIndicator);
        }
        fillIndicator();
    }

    @Override
    public void fillAllIndicator() {
        totalSalesIndicator.fillAllIndicator();
        totalValueAddedTaxIndicator.fillAllIndicator();
        totalMarginIndicator.fillAllIndicator();

        for (ProductGroup productGroup : productGroupList) {
            ProfitabilityIndicator profitabilityIndicator = new ProfitabilityIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            profitabilityIndicator.fillAllIndicatorAndProductGroup(productGroup.getName());
            profitabilityIndicatorMap.put(productGroup.getName(), profitabilityIndicator);
        }
        fillIndicator();
    }

    @Override
    public void fillIndicator() {
        setPresentPeriodIndicator(IndicatorUtil.countProfitability(totalMarginIndicator.getPresentPeriodIndicator(),
                totalSalesIndicator.getPresentPeriodIndicator(), totalValueAddedTaxIndicator.getPresentPeriodIndicator()));
        setPastPeriodIndicator(IndicatorUtil.countProfitability(totalMarginIndicator.getPastPeriodIndicator(),
                totalSalesIndicator.getPastPeriodIndicator(), totalValueAddedTaxIndicator.getPastPeriodIndicator()));
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(),
                getPastPeriodIndicator()));
    }

    public TotalSalesIndicator getTotalSalesIndicator() {
        return totalSalesIndicator;
    }

    public TotalMarginIndicator getTotalMarginIndicator() {
        return totalMarginIndicator;
    }

    public Map<String, ProfitabilityIndicator> getProfitabilityIndicatorMap() {
        return profitabilityIndicatorMap;
    }
}
