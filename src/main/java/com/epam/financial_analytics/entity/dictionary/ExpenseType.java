package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class ExpenseType extends Entity {
    public ExpenseType() {
    }

    public ExpenseType(String name) {
        super(name);
    }

    public ExpenseType(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ExpenseType " + super.toString();
    }
}
