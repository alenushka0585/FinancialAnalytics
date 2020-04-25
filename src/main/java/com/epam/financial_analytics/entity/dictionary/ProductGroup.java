package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class ProductGroup extends Entity {
    public ProductGroup() {
    }

    public ProductGroup(String name) {
        super(name);
    }

    public ProductGroup(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Product Group " + super.toString();
    }
}
