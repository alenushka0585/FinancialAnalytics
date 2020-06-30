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

public class TotalValueAddedTaxIndicator extends Indicator implements Fillable {
    private final ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private final Map<String, ValueAddedTaxIndicator> valueAddedTaxIndicatorMap = new HashMap<>();
    private final List<ProductGroup> productGroupList;

    public TotalValueAddedTaxIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate,
                                       Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        productGroupList = productGroupDao.getAll();
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        long presentPeriodTotalIndicator= 0L;
        long pastPeriodTotalIndicator= 0L;

        for (ProductGroup productGroup : productGroupList) {
            ValueAddedTaxIndicator valueAddedTaxIndicator = new ValueAddedTaxIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            valueAddedTaxIndicator.fillAllIndicatorWithOrganizationUnitAndProductGroup(organizationUnitName, productGroup.getName());
            valueAddedTaxIndicatorMap.put(productGroup.getName(), valueAddedTaxIndicator);

            presentPeriodTotalIndicator+=valueAddedTaxIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=valueAddedTaxIndicator.getPastPeriodIndicator();
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
            ValueAddedTaxIndicator valueAddedTaxIndicator = new ValueAddedTaxIndicator
                    (getPresentPeriodStartDate(),getPresentPeriodFinishDate(),getPastPeriodStartDate(),getPastPeriodFinishDate(),getCurrencyName());

            valueAddedTaxIndicator.fillAllIndicatorAndProductGroup(productGroup.getName());
            valueAddedTaxIndicatorMap.put(productGroup.getName(), valueAddedTaxIndicator);

            presentPeriodTotalIndicator+=valueAddedTaxIndicator.getPresentPeriodIndicator();
            pastPeriodTotalIndicator+=valueAddedTaxIndicator.getPastPeriodIndicator();
        }

        setPresentPeriodIndicator(presentPeriodTotalIndicator);
        setPastPeriodIndicator(pastPeriodTotalIndicator);
        setChangingOfIndicator(IndicatorUtil.fillIndicatorChangingSum(getPresentPeriodIndicator(), getPastPeriodIndicator()));
        setChangingOfIndicatorInPercents(IndicatorUtil.fillIndicatorChangingInPercent(getPresentPeriodIndicator(), getPastPeriodIndicator()));
    }

    public Map<String, ValueAddedTaxIndicator> getValueAddedTaxIndicatorMap() {
        return valueAddedTaxIndicatorMap;
    }
}