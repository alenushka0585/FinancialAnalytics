package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class Role extends Entity{
    public Role() {
    }

    public Role(String name) {
        super(name);
    }

    public Role(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Role " + super.toString();
    }
}
