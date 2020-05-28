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

public class TotalMarginIndicator extends Indicator implements Fillable {
    private ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private Map<String, MarginIndicator> marginIndicatorMap = new HashMap<>();
    private List<ProductGroup> productGroupList;

    public TotalMarginIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        productGroupList = productGroupDao.getAll();
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ProductGroup productGroup : productGroupList) {
            MarginIndicator marginIndicator = new MarginIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            marginIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup.getName());
            marginIndicatorMap.put(productGroup.getName(), marginIndicator);

            presentPeriodTotalIndicator+=marginIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=marginIndicator.getPastPeriodIndicator();
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
            MarginIndicator marginIndicator = new MarginIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            marginIndicator.fillAllIndicatorAndProductGroup(productGroup.getName());
            marginIndicatorMap.put(productGroup.getName(), marginIndicator);

            presentPeriodTotalIndicator+=marginIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=marginIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public Map<String, MarginIndicator> getMarginIndicatorMap() {
        return marginIndicatorMap;
    }
}