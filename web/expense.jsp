<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <jsp:include page="style.jsp"/>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/expense.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/expense.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="choose.indicator.date.currency.organization.unit"/></h4> <br>
<form name="expenseIndicator" action="${pageContext.request.contextPath}/controller/expense" method="post">
    <fmt:message key="kind.indicator"/> <label>
    <select name="kindOfReport" size="1">
    <option value="<fmt:message key="expenses"/>"><fmt:message key="expenses"/></option></select>
</label>
    <p><fmt:message key="date"/> <label><input type="date" name="date" required></label>
        <fmt:message key="currency"/> <label><select class="mdb-select md-form" name="currency" size="1"> <option value="RUB">RUB</option></select></label>
        <fmt:message key="organization.unit"/> <label>
            <select class="mdb-select md-form" name="organizationUnit" size="1">
                <option value="Караганда"> <fmt:message key="karaganda"/> </option>
                <option value="Алматы"> <fmt:message key="almaty"/> </option>
                <option value="Атырау"> <fmt:message key="atyrau"/> </option>
                <option value="Астана"> <fmt:message key="astana"/> </option>
                <option value="Актобе"> <fmt:message key="aktobe"/> </option>
                <option value="Оскемен"> <fmt:message key="oskemen"/> </option>
                <option value="Шымкент"> <fmt:message key="shymkent"/> </option>
            </select>
        </label>
    </p>

    <p><label><select class="mdb-select md-form" name="salary" size="1"> <option value="Зарплата"><fmt:message key="salary"/></option></select></label> <label><input type="number"  name="amountSalary" required></label></p>
    <p><label><select class="mdb-select md-form" name="factory" size="1"><option value="Заводские расходы"><fmt:message key="factory"/></option></select></label> <label><input type="number" name="amountFactory" required></label></p>
    <p><label><select class="mdb-select md-form" name="transport" size="1"><option value="Транспорт"><fmt:message key="transport"/></option></select></label> <label><input type="number" name="amountTransport" required></label></p>
    <p><label><select class="mdb-select md-form" name="package" size="1"><option value="Упаковка"><fmt:message key="package"/></option></select></label> <label><input type="number" name="amountPackage" required></label></p>
    <p><label><select class="mdb-select md-form" name="rent" size="1"><option value="Аренда"><fmt:message key="rent"/></option></select></label> <label><input type="number" name="amountRent" required></label></p>
    <p><label><select class="mdb-select md-form" name="other" size="1"><option value="Разное"><fmt:message key="others"/></option></select></label> <label><input type="number" name="amountOther" required></label></p>
    <p><label><select class="mdb-select md-form" name="phone" size="1"><option value="Телефон"><fmt:message key="phone"/></option></select></label> <label><input type="number" name="amountPhone" required></label></p>
    <p><label><select class="mdb-select md-form" name="businessTrip" size="1"><option value="Командировки"><fmt:message key="business.trip"/></option></select></label> <label><input type="number" name="amountBusinessTrip" required></label></p>
    <p><label><select class="mdb-select md-form" name="advertisement" size="1"><option value="Реклама"><fmt:message key="advertisement"/></option></select></label> <label><input type="number" name="amountAdvertisement" required></label></p>
    <p><label><select class="mdb-select md-form" name="ecquiring" size="1"><option value="Эквайринг"><fmt:message key="acquiring"/></option></select></label> <label><input type="number" name="amountEcquiring" required></label></p>

    <p>
        <button type="submit"><fmt:message key="load.into.db"/></button>
        <input type="reset" value="<fmt:message key="clear"/>">
    </p>

</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
