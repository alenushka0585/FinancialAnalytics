package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class Role extends Entity{
    public Role() {
    }

    public Role(long id, String name) {
        super(id, name);
    }

    public Role(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Role " + super.toString();
    }
}
