<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 14:48
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
    <a href="${pageContext.request.contextPath}/analytics.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/analytics.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="choose.details.for.report"/></h4> <br>
<form name="result" action="${pageContext.request.contextPath}/controller/analytics" method="post">
    <p><fmt:message key="current.period"/>
        <fmt:message key="from"/> <label><input type="date" name="presentPeriodStartDate" required></label>
        <fmt:message key="to"/> <label><input type="date" name="presentPeriodFinishDate" required></label>
    </p>
    <p><fmt:message key="past.period"/>
        <fmt:message key="from"/> <label><input type="date" name="pastPeriodStartDate" required></label>
        <fmt:message key="to"/> <label><input type="date" name="pastPeriodFinishDate" required></label>
    </p>
    <p><fmt:message key="organization.unit"/> <label>
        <select class="mdb-select md-form" name="organizationUnit" size="1">
            <option value="Казахстан"><fmt:message key="kazakhstan"/></option>
            <option value="Караганда"><fmt:message key="karaganda"/></option>
            <option value="Алматы"><fmt:message key="almaty"/></option>
            <option value="Атырау"><fmt:message key="atyrau"/></option>
            <option value="Астана"><fmt:message key="astana"/></option>
            <option value="Актобе"><fmt:message key="aktobe"/></option>
            <option value="Оскемен"><fmt:message key="oskemen"/></option>
            <option value="Шымкент"><fmt:message key="shymkent"/></option>
        </select>
    </label>
        <fmt:message key="currency"/> <label>
            <select class="mdb-select md-form" name="currency" size="1">
            <option value="KZT">KZT</option>
            <option value="RUB">RUB</option>
            <option value="USD">USD</option>
        </select>
        </label>
    </p>
    <button type="submit"><fmt:message key="generate.report"/></button>
    <input type="reset" value="<fmt:message key="clear"/>">
</form>

<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
