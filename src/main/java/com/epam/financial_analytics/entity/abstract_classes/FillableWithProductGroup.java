package com.epam.financial_analytics.entity.abstract_classes;

public interface FillableWithProductGroup {
    void fillAllIndicatorWithOrganizationUnitAndProductGroup(String organizationUnitName, String productGroup);
    void fillAllIndicatorAndProductGroup(String productGroup);
}
