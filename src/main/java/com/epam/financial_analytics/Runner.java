package com.epam.financial_analytics;

import com.epam.financial_analytics.dao.impl.CurrencyDaoImpl;
import com.epam.financial_analytics.dao.impl.ExpenseTypeDaoImpl;
import com.epam.financial_analytics.dao.impl.OrganizationUnitDaoImpl;
import com.epam.financial_analytics.dao.impl.ProductGroupDaoImpl;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;

import java.util.List;

public class Runner {
    public static void main(String[] args){

        ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();

        List<ProductGroup> productGroupList = productGroupDao.getAll();

        for (ProductGroup productGroup: productGroupList){
            System.out.println(productGroup);
        }
    }
}