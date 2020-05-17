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
    <a href="${pageContext.request.contextPath}/product_group_result.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/product_group_result.jsp?language=en">EN</a>
</div>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="currency" type="com.epam.financial_analytics.entity.dictionary.Currency" scope="request"/>
<jsp:useBean id="organizationUnit" type="com.epam.financial_analytics.entity.dictionary.OrganizationUnit" scope="request"/>

<jsp:useBean id="salesSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="salesSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>

<jsp:useBean id="marginSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="marginSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>

<jsp:useBean id="valueAddedTaxSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>
<jsp:useBean id="valueAddedTaxSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>

<h4><fmt:message key="loaded.information"/></h4> <br>

<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>
<p><fmt:message key="date"/> ${date}</p>
<p><fmt:message key="currency"/> ${currency.name}</p>
<p><fmt:message key="organization.unit"/> ${organizationUnit.name}</p>

<p> <fmt:message key="main.types.products"/> -  <fmt:message key="sales"/> ${salesSumOVP.amount} <fmt:message key="vat"/> ${valueAddedTaxSumOVP.amount} <fmt:message key="margin"/> ${marginSumOVP.amount}</p>
<p> <fmt:message key="three.layer.sandwich.panel"/> -  <fmt:message key="sales"/> ${salesSumTSP.amount} <fmt:message key="vat"/> ${valueAddedTaxSumTSP.amount} <fmt:message key="margin"/> ${marginSumTSP.amount}</p>
<p> <fmt:message key="gutter.systems"/> -  <fmt:message key="sales"/> ${salesSumVS.amount} <fmt:message key="vat"/> ${valueAddedTaxSumVS.amount} <fmt:message key="margin"/> ${marginSumVS.amount}</p>
<p> <fmt:message key="standard.finishes"/> -  <fmt:message key="sales"/> ${salesSumSEO.amount} <fmt:message key="vat"/> ${valueAddedTaxSumSEO.amount} <fmt:message key="margin"/> ${marginSumSEO.amount}</p>
<p> <fmt:message key="structural.elements"/> -  <fmt:message key="sales"/> ${salesSumENK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumENK.amount} <fmt:message key="margin"/> ${marginSumENK.amount}</p>
<p> <fmt:message key="safe.roof.elements"/> -  <fmt:message key="sales"/> ${salesSumEBK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumEBK.amount} <fmt:message key="margin"/> ${marginSumEBK.amount}</p>
<p> <fmt:message key="sandwich.panel"/> -  <fmt:message key="sales"/> ${salesSumSPPS.amount} <fmt:message key="vat"/> ${valueAddedTaxSumSPPS.amount} <fmt:message key="margin"/> ${marginSumSPPS.amount}</p>
<p> <fmt:message key="front.cassette"/> -  <fmt:message key="sales"/> ${salesSumFK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumFK.amount} <fmt:message key="margin"/> ${marginSumFK.amount}</p>
<p> <fmt:message key="others"/> -  <fmt:message key="sales"/> ${salesSumOther.amount} <fmt:message key="vat"/> ${valueAddedTaxSumOther.amount} <fmt:message key="margin"/> ${marginSumOther.amount}</p>
<p> <fmt:message key="goods"/> - <fmt:message key="sales"/> ${salesSumGoods.amount} <fmt:message key="vat"/> ${valueAddedTaxSumGoods.amount} <fmt:message key="margin"/> ${marginSumGoods.amount}</p>


<form name="back" action="${pageContext.request.contextPath}/product_group.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
