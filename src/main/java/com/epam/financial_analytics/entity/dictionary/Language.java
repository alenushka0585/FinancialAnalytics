package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class Language extends Entity {
    public Language() {
    }

    public Language(String name) {
        super(name);
    }

    public Language(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Language " + super.toString();
    }
}
