package com.epam.financial_analytics.entity.report_classes;

import com.epam.financial_analytics.entity.abstract_classes.ReportWithOrganizationAndCurrency;
import com.epam.financial_analytics.entity.dictionary.*;

import java.sql.Date;

public class ProductGroupSales extends ReportWithOrganizationAndCurrency {
    ProductGroup productGroup;
    private long salesSum;
    private long valueAddedTaxSum;
    private long marginSum;

    public ProductGroupSales() {
    }

    public ProductGroupSales(long id, Date date, OrganizationUnit organizationUnit, Currency currency, ProductGroup productGroup, long salesSum, long valueAddedTaxSum, long marginSum) {
        super(id, date, organizationUnit, currency);
        this.productGroup = productGroup;
        this.salesSum = salesSum;
        this.valueAddedTaxSum = valueAddedTaxSum;
        this.marginSum = marginSum;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public long getSalesSum() {
        return salesSum;
    }

    public void setSalesSum(long salesSum) {
        this.salesSum = salesSum;
    }

    public long getValueAddedTaxSum() {
        return valueAddedTaxSum;
    }

    public void setValueAddedTaxSum(long valueAddedTaxSum) {
        this.valueAddedTaxSum = valueAddedTaxSum;
    }

    public long getMarginSum() {
        return marginSum;
    }

    public void setMarginSum(long marginSum) {
        this.marginSum = marginSum;
    }

    @Override
    public String toString() {
        return "ProductGroupSales " + super.toString()+
                ", "+ productGroup +
                ", salesSum=" + salesSum +
                ", valueAddedTaxSum=" + valueAddedTaxSum +
                ", marginSum=" + marginSum;
    }
}
