<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title></title></head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/administration.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/administration.jsp?language=en">EN</a>
</div>
<H2><fmt:message key="admin.panel" /></H2>
<form name="basicIndicator" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
    <button type="submit"><fmt:message key="key.indicators" /></button>
</form>
<form name="metal_processing" action="${pageContext.request.contextPath}/metal_processing.jsp" method="post">
    <button type="submit"><fmt:message key="metal.processing" /></button>
</form>
<form name="expense" action="${pageContext.request.contextPath}/expense.jsp" method="post">
    <button type="submit"><fmt:message key="expenses" /></button>
</form>
<form name="productGroup" action="${pageContext.request.contextPath}/product_group.jsp" method="post">
    <button type="submit"><fmt:message key="product.group" /></button>
</form><form name="currencyExchangeRate" action="${pageContext.request.contextPath}/currency_exchange_rate.jsp" method="post">
    <button type="submit"><fmt:message key="currency.exchange.rate" /></button>
</form>
<form name="user" action="${pageContext.request.contextPath}/user.jsp" method="post">
    <button type="submit"><fmt:message key="user" /></button>
</form>

<jsp:include page="main_menu.jsp"/> <jsp:include page="logout.jsp"/>

</body>
</html>
