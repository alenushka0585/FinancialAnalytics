<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 05.05.2020
  Time: 18:20
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
    <a href="${pageContext.request.contextPath}/currency_exchange_rate_result.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/currency_exchange_rate_result.jsp?language=en">EN</a>
</div>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="RUB" type="com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate" scope="request"/>
<jsp:useBean id="USD" type="com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate" scope="request"/>
<jsp:useBean id="KZT" type="com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate" scope="request"/>

<h4><fmt:message key="loaded.information"/></h4> <br>

<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>
<p><fmt:message key="date"/> ${date}</p>

<p> RUB: ${RUB.currencyExchangeRate}</p>
<p> USD: ${USD.currencyExchangeRate}</p>
<p> KZT: ${KZT.currencyExchangeRate}</p>

<form name="back" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
