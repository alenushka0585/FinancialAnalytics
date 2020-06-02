<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title></title>
</head>
<body>
<jsp:useBean id="allIndicator" type="com.epam.financial_analytics.logic.AllIndicator" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav justify-content-end">
                        <li class="nav-item active justify-content-end">
                            <form name="main" action="${pageContext.request.contextPath}/main.jsp" method="post">
                                <button type="submit" class="btn btn-outline-light btn-sm">
                                    <fmt:message key="main.menu"/>
                                </button>
                            </form>
                        </li>
                        <li class="nav-item active justify-content-end">
                            <form name="logout" action="${pageContext.request.contextPath}/controller/logout" method="post">
                                <button type="submit" class="btn btn-outline-light btn-sm">
                                    <fmt:message key="sign.out"/>
                                </button>
                            </form>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>
<br>
<br>
<br>
<br>
<main class="main">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <fieldset class="col-sm-6">
                <legend class="text-center"><b><fmt:message key="comparison.expenses.revenue"/></b></legend>
                <table class="table table-bordered table-hover table-light text-dark">
                    <thead class="table-active text-dark">
                    <tr>
                        <th></th>
                        <th scope="col"><fmt:message key="changing"/>  %</th>
                        <th scope="col"><fmt:message key="changing"/>  ${allIndicator.currencyName}</th>
                        <th scope="col"><fmt:message key="current.period"/>,  ${allIndicator.currencyName}</th>
                        <th scope="col"><fmt:message key="past.period"/>,  ${allIndicator.currencyName}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"><fmt:message key="changing.expense"/></th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.revenue"/></th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.sales.sq.metres"/></th>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.sales.tons"/></th>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.metal.processing"/></th>
                        <td class="text-center">${allIndicator.metalProcessingIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.metalProcessingIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.metalProcessingIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.metalProcessingIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="expense.to.revenue"/></th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.changingOfIndicator}</td>
                        <td> </td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.sales"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing.margin"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="profitability"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.changingOfIndicator}</td>
                        <td> </td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.pastPeriodIndicator}</td>
                    </tr>
                    </tbody><tr>
                </table>
            </fieldset>
            <fieldset class="col-sm-6">
                <legend class="text-center"><b><fmt:message key="key.performance.indicators"/></b></legend>
                <table class="table table-bordered table-hover table-light text-dark">
                    <thead class="table-active text-dark">
                    <tr>
                        <th></th>
                        <th scope="col"><fmt:message key="current.period"/></th>
                        <th scope="col"><fmt:message key="past.period"/></th>
                        <th scope="col"><fmt:message key="changing"/> %</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"><fmt:message key="margin.sq.metres"/></th>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnSquareMetreIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="margin.tons"/></th>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnTonsIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="margin.employee"/></th>
                        <td class="text-center">${allIndicator.marginOnEmployeeIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnEmployeeIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.marginOnEmployeeIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="labour.cost.employee"/></th>
                        <td class="text-center">${allIndicator.labourCostOnEmployeeIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnEmployeeIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnEmployeeIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="labour.cost.sq.metres"/></th>
                        <td class="text-center">${allIndicator.labourCostOnSquareMetreIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnSquareMetreIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnSquareMetreIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="labour.cost.tons"/></th>
                        <td class="text-center">${allIndicator.labourCostOnTonIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnTonIndicator.pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.labourCostOnTonIndicator.changingOfIndicatorInPercents}</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="row justify-content-center">
            <fieldset>
                <legend class="text-center"><b><fmt:message key="comparison.expenses"/></b></legend>
                <table class="table table-bordered table-hover table-light text-dark">
                    <thead class="table-active text-dark">
                    <tr>
                        <th class="col"></th>
                        <th class="col"><fmt:message key="salary"/></th>
                        <th class="col"><fmt:message key="factory"/></th>
                        <th class="col"><fmt:message key="transport"/></th>
                        <th class="col"><fmt:message key="package"/></th>
                        <th class="col"><fmt:message key="rent"/></th>
                        <th class="col"><fmt:message key="others"/></th>
                        <th class="col"><fmt:message key="phone"/></th>
                        <th class="col"><fmt:message key="business.trip"/></th>
                        <th class="col"><fmt:message key="advertisement"/></th>
                        <th class="col"><fmt:message key="acquiring"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"><fmt:message key="current.period"/></th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Salary").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Factory").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Transport").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Package").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Rent").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Other").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Phone").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("BusinessTrip").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Advertisement").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Acquiring").presentPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="past.period"/></th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Salary").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Factory").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Transport").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Package").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Rent").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Other").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Phone").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("BusinessTrip").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Advertisement").pastPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Acquiring").pastPeriodIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing"/> ${allIndicator.currencyName}</th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Salary").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Factory").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Transport").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Package").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Rent").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Other").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Phone").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("BusinessTrip").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Advertisement").changingOfIndicator}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Acquiring").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="changing"/> %</th>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Salary").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Factory").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Transport").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Package").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Rent").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Other").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Phone").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("BusinessTrip").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Advertisement").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.expenseInfoMap.get("Acquiring").changingOfIndicatorInPercents}</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="row justify-content-center">
            <fieldset>
                <legend class="text-center"><b><fmt:message key="analysis.product.group"/></b></legend>
                <table class="table table-bordered table-hover table-light text-dark">
                    <thead  class="table-active text-dark">
                    <tr>
                        <th scope="col"><fmt:message key="product.group"/></th>
                        <th scope="col"><fmt:message key="sales.increase"/>, %</th>
                        <th scope="col"><fmt:message key="margin.increase"/>, %</th>
                        <th scope="col"><fmt:message key="current.profitability"/></th>
                        <th scope="col"><fmt:message key="changing.profitability"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"><fmt:message key="main.types.products"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("OVP").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("OVP").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("OVP").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("OVP").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="three.layer.sandwich.panel"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("TSP").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("TSP").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("TSP").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("TSP").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="gutter.systems"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("VS").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("VS").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("VS").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("VS").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="standard.finishes"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("SEO").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("SEO").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("SEO").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("SEO").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="safe.roof.elements"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("EBK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("EBK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("EBK").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("EBK").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="structural.elements"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("ENK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("ENK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("ENK").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("ENK").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="sandwich.panel"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("SPPS").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("SPPS").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("SPPS").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("SPPS").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="front.cassette"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("FK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("FK").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("FK").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("FK").changingOfIndicator}</td>
                    </tr>
                    <tr>
                        <th scope="row"><fmt:message key="others"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("Other").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("Other").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("Other").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("Other").changingOfIndicator}</td>
                    </tr>
                    <tr class="table-active text-dark">
                        <th scope="row"><fmt:message key="goods"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.salesIndicatorMap.get("Goods").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.marginIndicatorMap.get("Goods").changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("Goods").presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.profitabilityIndicatorMap.get("Goods").changingOfIndicator}</td>
                    </tr>
                    <tr class="table-active text-dark">
                        <th scope="row"><fmt:message key="total"/></th>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalSalesIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.totalMarginIndicator.changingOfIndicatorInPercents}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.presentPeriodIndicator}</td>
                        <td class="text-center">${allIndicator.profitabilityTotalIndicator.changingOfIndicator}</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-6">
                <form name="back" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
