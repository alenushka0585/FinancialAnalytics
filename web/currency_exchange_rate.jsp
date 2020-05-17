<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:53
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
    <a href="${pageContext.request.contextPath}/currency_exchange_rate.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/currency_exchange_rate.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="currency.exchange.rate"/></h4> <br>
<form name="currencyExchangeRate" action="${pageContext.request.contextPath}/controller/currency_exchange_rate" method="post">
    <p>
        <fmt:message key="kind.indicator"/> <label>
        <select class="mdb-select md-form" name="kindOfReport" size="1">
        <option value="Курсы валют"><fmt:message key="currency.exchange.rate"/></option>
    </select>
    </label> <fmt:message key="date"/> <label><input type="date" name="date" required></label></p>

    <p><label><select class="mdb-select md-form" name="RUB" size="1"> <option value="RUB">RUB</option></select></label> <label><input type="number" name="rateRUB" required></label></p>
    <p><label><select class="mdb-select md-form" name="USD" size="1"><option value="USD">USD</option></select></label> <label><input type="number" name="rateUSD" required></label></p>
    <p><label><select class="mdb-select md-form" name="KZT" size="1"><option value="KZT">KZT</option></select></label> <label><input type="number" name="rateKZT" required></label></p>

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
