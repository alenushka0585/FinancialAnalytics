package com.epam.financial_analytics.logic;

import java.sql.Date;

public class AllIndicator extends Indicator implements Fillable {
    private PercentExpenseToRevenueIndicator percentExpenseToRevenueIndicator;
    private MetalProcessingIndicator metalProcessingIndicator;
    private ProfitabilityTotalIndicator profitabilityTotalIndicator;
    private MarginOnSquareMetreIndicator marginOnSquareMetreIndicator;
    private MarginOnTonsIndicator marginOnTonsIndicator;
    private MarginOnEmployeeIndicator marginOnEmployeeIndicator;
    private LabourCostOnEmployeeIndicator labourCostOnEmployeeIndicator;
    private LabourCostOnSquareMetreIndicator labourCostOnSquareMetreIndicator;
    private LabourCostOnTonIndicator labourCostOnTonIndicator;

    public AllIndicator(Date presentPeriodStartDate, Date presentPeriodFinishDate, Date pastPeriodStartDate, Date pastPeriodFinishDate, String currencyName) {
        super(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        percentExpenseToRevenueIndicator = new PercentExpenseToRevenueIndicator(presentPeriodStartDate, presentPeriodFinishDate,
                pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        metalProcessingIndicator = new MetalProcessingIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        profitabilityTotalIndicator = new ProfitabilityTotalIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginOnSquareMetreIndicator = new MarginOnSquareMetreIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginOnTonsIndicator = new MarginOnTonsIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        marginOnEmployeeIndicator = new MarginOnEmployeeIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostOnEmployeeIndicator = new LabourCostOnEmployeeIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostOnSquareMetreIndicator = new LabourCostOnSquareMetreIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
        labourCostOnTonIndicator = new LabourCostOnTonIndicator(presentPeriodStartDate, presentPeriodFinishDate, pastPeriodStartDate, pastPeriodFinishDate, currencyName);
    }

    @Override
    public void fillAllIndicatorWithOrganizationUnit(String organizationUnitName) {
        percentExpenseToRevenueIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        metalProcessingIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        profitabilityTotalIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginOnSquareMetreIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginOnTonsIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        marginOnEmployeeIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        labourCostOnEmployeeIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        labourCostOnSquareMetreIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
        labourCostOnTonIndicator.fillAllIndicatorWithOrganizationUnit(organizationUnitName);
    }

    @Override
    public void fillAllIndicator() {
        percentExpenseToRevenueIndicator.fillAllIndicator();
        metalProcessingIndicator.fillAllIndicator();
        profitabilityTotalIndicator.fillAllIndicator();
        marginOnSquareMetreIndicator.fillAllIndicator();
        marginOnTonsIndicator.fillAllIndicator();
        marginOnEmployeeIndicator.fillAllIndicator();
        labourCostOnEmployeeIndicator.fillAllIndicator();
        labourCostOnSquareMetreIndicator.fillAllIndicator();
        labourCostOnTonIndicator.fillAllIndicator();
    }

    public PercentExpenseToRevenueIndicator getPercentExpenseToRevenueIndicator() {
        return percentExpenseToRevenueIndicator;
    }

    public MarginOnSquareMetreIndicator getMarginOnSquareMetreIndicator() {
        return marginOnSquareMetreIndicator;
    }

    public MarginOnTonsIndicator getMarginOnTonsIndicator() {
        return marginOnTonsIndicator;
    }

    public MarginOnEmployeeIndicator getMarginOnEmployeeIndicator() {
        return marginOnEmployeeIndicator;
    }

    public MetalProcessingIndicator getMetalProcessingIndicator() {
        return metalProcessingIndicator;
    }

    public ProfitabilityTotalIndicator getProfitabilityTotalIndicator() {
        return profitabilityTotalIndicator;
    }

    public LabourCostOnEmployeeIndicator getLabourCostOnEmployeeIndicator() {
        return labourCostOnEmployeeIndicator;
    }

    public LabourCostOnSquareMetreIndicator getLabourCostOnSquareMetreIndicator() {
        return labourCostOnSquareMetreIndicator;
    }

    public LabourCostOnTonIndicator getLabourCostOnTonIndicator() {
        return labourCostOnTonIndicator;
    }
}
