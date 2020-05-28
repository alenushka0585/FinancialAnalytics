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

public class TotalSalesIndicator extends Indicator implements Fillable {
    private ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private Map<String, SalesIndicator> salesIndicatorMap = new HashMap<>();
    private List<ProductGroup> productGroupList;

    public TotalSalesIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                               Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        productGroupList = productGroupDao.getAll();
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ProductGroup productGroup : productGroupList) {
            SalesIndicator salesIndicator = new SalesIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            salesIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup.getName());
            salesIndicatorMap.put(productGroup.getName(), salesIndicator);

            presentPeriodTotalIndicator+=salesIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=salesIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    @Override
    public void fillAllIndicator() {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ProductGroup productGroup : productGroupList) {
            SalesIndicator salesIndicator = new SalesIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            salesIndicator.fillAllIndicatorAndProductGroup(productGroup.getName());
            salesIndicatorMap.put(productGroup.getName(), salesIndicator);

            presentPeriodTotalIndicator+=salesIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=salesIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public Map<String, SalesIndicator> getSalesIndicatorMap() {
        return salesIndicatorMap;
    }
}