package com.epam.financial_analytics.entity.dictionary;

import com.epam.financial_analytics.entity.abstract_classes.Entity;

public class OrganizationUnit extends Entity {
    public OrganizationUnit() {
    }

    public OrganizationUnit(String name) {
        super(name);
    }

    public OrganizationUnit(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Organization Unit " + super.toString();
    }
}
