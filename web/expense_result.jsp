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
    <a href="${pageContext.request.contextPath}/expense_result.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/expense_result.jsp?language=en">EN</a>
</div>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="currency" type="com.epam.financial_analytics.entity.dictionary.Currency" scope="request"/>
<jsp:useBean id="organizationUnit" type="com.epam.financial_analytics.entity.dictionary.OrganizationUnit" scope="request"/>
<jsp:useBean id="salary" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="factory" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="transport" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="package" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="rent" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="other" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="phone" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="businessTrip" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="advertisement" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>
<jsp:useBean id="ecquiring" type="com.epam.financial_analytics.entity.report_classes.ExpenseInfo" scope="request"/>

<h4><fmt:message key="loaded.information"/></h4> <br>

<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>
<p><fmt:message key="date"/> ${date}</p>
<p><fmt:message key="currency"/> ${currency.name}</p>
<p><fmt:message key="organization.unit"/> ${organizationUnit.name}</p>

<p> <fmt:message key="salary"/> ${salary.amount}</p>
<p> <fmt:message key="factory"/> ${factory.amount}</p>
<p> <fmt:message key="transport"/> ${transport.amount}</p>
<p> <fmt:message key="package"/> ${package.amount}</p>
<p> <fmt:message key="rent"/> ${rent.amount}</p>
<p> <fmt:message key="others"/> ${other.amount}</p>
<p> <fmt:message key="phone"/> ${phone.amount}</p>
<p> <fmt:message key="business.trip"/> ${businessTrip.amount}</p>
<p> <fmt:message key="advertisement"/> ${advertisement.amount}</p>
<p> <fmt:message key="acquiring"/> ${ecquiring.amount}</p>

<form name="back" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
