package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;

import java.sql.Date;

public class ProductGroupSales extends ReportWithOrganizationAndCurrency {
    ProductGroup productGroup;

    public ProductGroupSales() {
    }

    public ProductGroupSales(Date date, long amount, OrganizationUnit organizationUnit, Currency currency, ProductGroup productGroup) {
        super(date,amount, organizationUnit, currency);
        this.productGroup = productGroup;
    }

    public ProductGroupSales(long id, Date date, long amount, OrganizationUnit organizationUnit, Currency currency, ProductGroup productGroup) {
        super(id, date, amount, organizationUnit, currency);
        this.productGroup = productGroup;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }


    @Override
    public String toString() {
        return "ProductGroupInfo " + super.toString() +  ", " + productGroup +
                ", sum=" + getAmount();
    }
}
