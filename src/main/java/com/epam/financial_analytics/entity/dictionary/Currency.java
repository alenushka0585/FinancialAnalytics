package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class Currency extends Entity {
    public Currency() {
    }

    public Currency(String name) {
        super(name);
    }

    public Currency(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Currency " + super.toString();
    }
}
