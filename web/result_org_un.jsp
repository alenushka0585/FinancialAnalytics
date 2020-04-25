<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
Что-то будет здесь
<jsp:useBean id="basicIndicator" type="com.epam.financial_analytics.logic.BasicIndicator" scope="request"/>
<fieldset>
    <legend><b>Сравнение затрат и выручки</b></legend>
    <table border="1">
        <tr>
            <th></th>
            <th>%</th>
            <th>${basicIndicator.currencyName}</th>
        </tr>
        <tr>
            <td>Изменение затрат</td>
            <td>${basicIndicator.expenseIndicator.changingOfAllExpensesInPercents}</td>
            <td>${basicIndicator.expenseIndicator.changingOfAllExpenses}</td>
        </tr>
        <tr>
            <td>Изменение выручки</td>
            <td>${basicIndicator.changingOfRevenueInPercents}</td>
            <td>${basicIndicator.changingOfRevenue}</td>
        </tr>
        <tr>
            <td>Изменение продаж, м2</td>
            <td>${basicIndicator.changingOfSquareMetresSalesInPercents}</td>
            <td>${basicIndicator.changingOfSquareMetresSales}</td>
        </tr>
        <tr>
            <td>Изменение продаж, тонны</td>
            <td>${basicIndicator.changingOfTonnsSalesInPercents}</td>
            <td>${basicIndicator.changingOfTonnsSales}</td>
        </tr>
        <tr>
            <td>Изменение переработки, тонны</td>
            <td>${basicIndicator.changingOfMetallProcessingInPercents}</td>
            <td>${basicIndicator.changingOfMetallProcessing}</td>
        </tr>
        <tr>
            <td>% издержек к выручке текущий период</td>
            <td>${basicIndicator.presentPeriodPercentOfExpenseToRevenue}</td>
        </tr>
        <tr>
            <td>% издержек к выручке прошлый период</td>
            <td>${basicIndicator.pastPeriodPercentOfExpenseToRevenue}</td>
        </tr>
        <tr>
            <td>Изменение процента издержек к выручке</td>
            <td>${basicIndicator.changingOfPercentOfExpenseToRevenue}</td>
        </tr>
        <tr>
            <td>Изменение продаж</td>
            <td>${basicIndicator.productGroupIndicator.changingOfAllSalesInPercents}</td>
            <td>${basicIndicator.productGroupIndicator.changingOfAllSales}</td>
        </tr>
        <tr>
            <td>Изменение маржи</td>
            <td>${basicIndicator.productGroupIndicator.changingOfAllMarginInPercents}</td>
            <td>${basicIndicator.productGroupIndicator.changingOfAllMargin}</td>
        </tr>
        <tr>
            <td>Рентабельность текущий период</td>
            <td>${basicIndicator.productGroupIndicator.presentPeriodAllProfitability}</td>
        </tr>
        <tr>
            <td>Рентабельность прошлый период</td>
            <td>${basicIndicator.productGroupIndicator.pastPeriodAllProfitability}</td>
        </tr>
        <tr>
            <td>Изменение процента рентабельности</td>
            <td>${basicIndicator.productGroupIndicator.changingOfAllProfitability}</td>
        </tr>
    </table>
</fieldset>
<form name="analytics" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
    <button type="submit">Назад</button>
</form>
</body>
</html>
