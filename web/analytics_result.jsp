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
<div>
    <a href="${pageContext.request.contextPath}/analytics_result.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/analytics_result.jsp?language=en">EN</a>
</div>
<jsp:useBean id="allIndicator" type="com.epam.financial_analytics.logic.AllIndicator" scope="request"/>
<fieldset>
    <legend><b><fmt:message key="comparison.expenses.revenue"/></b></legend>
    <table class="table">
        <tr>
            <th></th>
            <th><fmt:message key="changing"/>  %</th>
            <th><fmt:message key="changing"/>  ${allIndicator.currencyName}</th>
            <th><fmt:message key="current.period"/>,  ${allIndicator.currencyName}</th>
            <th><fmt:message key="past.period"/>,  ${allIndicator.currencyName}</th>
        </tr>
        <tr>
            <td><fmt:message key="changing.expense"/></td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.revenue"/></td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.revenueIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.sales.sq.metres"/></td>
            <td>${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.changingOfIndicator}</td>
            <td>${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.marginOnSquareMetreIndicator.salesOfSquareMetresIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.sales.tons"/></td>
            <td>${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.changingOfIndicator}</td>
            <td>${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.marginOnTonsIndicator.salesOfTonsIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.metal.processing"/></td>
            <td>${allIndicator.metalProcessingIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.metalProcessingIndicator.changingOfIndicator}</td>
            <td>${allIndicator.metalProcessingIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.metalProcessingIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="expense.to.revenue"/></td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.changingOfIndicator}</td>
            <td> </td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.sales"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.changingOfIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing.margin"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.changingOfIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="profitability"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.changingOfIndicator}</td>
            <td> </td>
            <td>${allIndicator.profitabilityTotalIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.pastPeriodIndicator}</td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend><b><fmt:message key="key.performance.indicators"/></b></legend>
    <table class="table-light">
        <tr>
            <th></th>
            <th><fmt:message key="current.period"/></th>
            <th><fmt:message key="past.period"/></th>
            <th><fmt:message key="changing"/> %</th>
        </tr>
        <tr>
            <td><fmt:message key="margin.sq.metres"/></td>
            <td>${allIndicator.marginOnSquareMetreIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.marginOnSquareMetreIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.marginOnSquareMetreIndicator.changingOfIndicatorInPercents}</td>
        </tr>
        <tr>
            <td><fmt:message key="margin.tons"/></td>
            <td>${allIndicator.marginOnTonsIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.marginOnTonsIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.marginOnTonsIndicator.changingOfIndicatorInPercents}</td>
        </tr>
        <tr>
            <td><fmt:message key="margin.employee"/></td>
            <td>${allIndicator.marginOnEmployeeIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.marginOnEmployeeIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.marginOnEmployeeIndicator.changingOfIndicatorInPercents}</td>
        </tr>
        <tr>
            <td><fmt:message key="labour.cost.employee"/></td>
            <td>${allIndicator.labourCostOnEmployeeIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnEmployeeIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnEmployeeIndicator.changingOfIndicatorInPercents}</td>
        </tr>
        <tr>
            <td><fmt:message key="labour.cost.sq.metres"/></td>
            <td>${allIndicator.labourCostOnSquareMetreIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnSquareMetreIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnSquareMetreIndicator.changingOfIndicatorInPercents}</td>
        </tr>
        <tr>
            <td><fmt:message key="labour.cost.tons"/></td>
            <td>${allIndicator.labourCostOnTonIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnTonIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.labourCostOnTonIndicator.changingOfIndicatorInPercents}</td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend><b><fmt:message key="comparison.expenses"/></b></legend>
    <table class="table-success">
        <tr>
            <th></th>
            <th><fmt:message key="salary"/></th>
            <th><fmt:message key="factory"/></th>
            <th><fmt:message key="transport"/></th>
            <th><fmt:message key="package"/></th>
            <th><fmt:message key="rent"/></th>
            <th><fmt:message key="others"/></th>
            <th><fmt:message key="phone"/></th>
            <th><fmt:message key="business.trip"/></th>
            <th><fmt:message key="advertisement"/></th>
            <th><fmt:message key="acquiring"/></th>
        </tr>
        <tr>
            <td><fmt:message key="current.period"/></td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.salaryExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.factoryExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.transportExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.packageExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.rentExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.othersExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.phoneExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.businessTripExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.advertisementExpenseIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.ecquaringExpenseIndicator.presentPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="past.period"/></td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.salaryExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.factoryExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.transportExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.packageExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.rentExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.othersExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.phoneExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.businessTripExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.advertisementExpenseIndicator.pastPeriodIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.ecquaringExpenseIndicator.pastPeriodIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing"/> ${allIndicator.currencyName}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.salaryExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.factoryExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.transportExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.packageExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.rentExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.othersExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.phoneExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.businessTripExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.advertisementExpenseIndicator.changingOfIndicator}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.ecquaringExpenseIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="changing"/> %</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.salaryExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.factoryExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.transportExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.packageExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.rentExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.othersExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.phoneExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.businessTripExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.advertisementExpenseIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.percentExpenseToRevenueIndicator.totalExpenseIndicator.ecquaringExpenseIndicator.changingOfIndicatorInPercents}</td>
        </tr>
    </table>
</fieldset>

<fieldset>
    <legend><b><fmt:message key="analysis.product.group"/></b></legend>
    <table class="table-primary">
        <tr>
            <th><fmt:message key="product.group"/></th>
            <th><fmt:message key="sales.increase"/>, %</th>
            <th><fmt:message key="margin.increase"/>, %</th>
            <th><fmt:message key="current.profitability"/></th>
            <th><fmt:message key="changing.profitability"/></th>
        </tr>
        <tr>
            <td><fmt:message key="production"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumProductionIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumProductionIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityProductionIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityProductionIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="main.types.products"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumOVPIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumOVPIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityOVPIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityOVPIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="three.layer.sandwich.panel"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumTSPIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumTSPIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityTSPIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityTSPIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="gutter.systems"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumVSIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumVSIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityVSIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityVSIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="standard.finishes"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumSEOIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumSEOIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilitySEOIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilitySEOIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="safe.roof.elements"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumEBKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumEBKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityEBKIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityEBKIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="structural.elements"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumENKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumENKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityENKIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityENKIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="sandwich.panel"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumSPPSIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumSPPSIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilitySPPSIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilitySPPSIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="front.cassette"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumFKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumFKIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityFKIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityFKIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="others"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumOtherIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumOtherIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityOtherIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityOtherIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="goods"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.salesSumGoodsIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.marginSumGoodsIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityGoodsIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.profitabilityGoodsIndicator.changingOfIndicator}</td>
        </tr>
        <tr>
            <td><fmt:message key="total"/></td>
            <td>${allIndicator.profitabilityTotalIndicator.salesSumTotalIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.marginSumTotalIndicator.changingOfIndicatorInPercents}</td>
            <td>${allIndicator.profitabilityTotalIndicator.presentPeriodIndicator}</td>
            <td>${allIndicator.profitabilityTotalIndicator.changingOfIndicator}</td>
        </tr>
    </table>
</fieldset>

<form name="analytics" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
