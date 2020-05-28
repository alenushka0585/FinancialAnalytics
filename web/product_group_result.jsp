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
    <title></title></head>
<body>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="currency" type="com.epam.financial_analytics.entity.dictionary.Currency" scope="request"/>
<jsp:useBean id="organizationUnit" type="com.epam.financial_analytics.entity.dictionary.OrganizationUnit" scope="request"/>
<jsp:useBean id="reportSales" type="java.util.Map" scope="request"/>
<jsp:useBean id="reportMargin" type="java.util.Map" scope="request"/>
<jsp:useBean id="reportVAT" type="java.util.Map" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/product_group_result.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/product_group_result.jsp?language=en">EN</a>
                        </li>
                    </ul>
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
        <div class="row">
            <div class="col">
                <p class="h4 text-center">
                    <fmt:message key="loaded.information"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="kind.indicator"/>: ${kindOfReport}</p>
        </div>
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="date"/>: ${date}</p>
        </div>
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="organization.unit"/>: ${organizationUnit.name}</p>
        </div>
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="currency"/>: ${currency.name}</p>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-2"></div>
            <table class="table table-bordered col-sm-8">
                <thead>
                <tr>
                    <th><fmt:message key="product.group"/></th>
                    <th><fmt:message key="sales"/></th>
                    <th><fmt:message key="margin"/></th>
                    <th><fmt:message key="vat"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th><fmt:message key="main.types.products"/></th>
                    <td>${reportSales.get("OVP")}</td>
                    <td>${reportMargin.get("OVP")}</td>
                    <td>${reportVAT.get("OVP")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="three.layer.sandwich.panel"/></th>
                    <td>${reportSales.get("TSP")}</td>
                    <td>${reportMargin.get("TSP")}</td>
                    <td>${reportVAT.get("TSP")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="gutter.systems"/></th>
                    <td>${reportSales.get("VS")}</td>
                    <td>${reportMargin.get("VS")}</td>
                    <td>${reportVAT.get("VS")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="standard.finishes"/></th>
                    <td>${reportSales.get("SEO")}</td>
                    <td>${reportMargin.get("SEO")}</td>
                    <td>${reportVAT.get("SEO")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="structural.elements"/></th>
                    <td>${reportSales.get("ENK")}</td>
                    <td>${reportMargin.get("ENK")}</td>
                    <td>${reportVAT.get("ENK")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="safe.roof.elements"/></th>
                    <td>${reportSales.get("EBK")}</td>
                    <td>${reportMargin.get("EBK")}</td>
                    <td>${reportVAT.get("EBK")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="sandwich.panel"/></th>
                    <td>${reportSales.get("SPPS")}</td>
                    <td>${reportMargin.get("SPPS")}</td>
                    <td>${reportVAT.get("SPPS")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="front.cassette"/></th>
                    <td>${reportSales.get("FK")}</td>
                    <td>${reportMargin.get("FK")}</td>
                    <td>${reportVAT.get("FK")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="others"/></th>
                    <td>${reportSales.get("Other")}</td>
                    <td>${reportMargin.get("Other")}</td>
                    <td>${reportVAT.get("Other")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="goods"/></th>
                    <td>${reportSales.get("Goods")}</td>
                    <td>${reportMargin.get("Goods")}</td>
                    <td>${reportVAT.get("Goods")}</td>
                </tr>
                </tbody>
            </table>
            <div class="col-sm-2"></div>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-6">
                <form name="back" action="${pageContext.request.contextPath}/product_group.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
<%--<div>--%>
<%--    <a href="${pageContext.request.contextPath}/product_group_result.jsp?language=ru">RU</a>--%>
<%--    <a href="${pageContext.request.contextPath}/product_group_result.jsp?language=en">EN</a>--%>
<%--</div>--%>
<%--<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>--%>
<%--<jsp:useBean id="date" type="java.sql.Date" scope="request"/>--%>
<%--<jsp:useBean id="currency" type="com.epam.financial_analytics.entity.dictionary.Currency" scope="request"/>--%>
<%--<jsp:useBean id="organizationUnit" type="com.epam.financial_analytics.entity.dictionary.OrganizationUnit" scope="request"/>--%>

<%--<jsp:useBean id="salesSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="salesSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>

<%--<jsp:useBean id="marginSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="marginSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>

<%--<jsp:useBean id="valueAddedTaxSumOVP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumTSP" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumVS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumSEO" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumENK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumEBK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumSPPS" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumFK" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumOther" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>
<%--<jsp:useBean id="valueAddedTaxSumGoods" type="com.epam.financial_analytics.entity.report_classes.ProductGroupSales" scope="request"/>--%>

<%--<h4><fmt:message key="loaded.information"/></h4> <br>--%>

<%--<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>--%>
<%--<p><fmt:message key="date"/> ${date}</p>--%>
<%--<p><fmt:message key="currency"/> ${currency.name}</p>--%>
<%--<p><fmt:message key="organization.unit"/> ${organizationUnit.name}</p>--%>

<%--<p> <fmt:message key="main.types.products"/> -  <fmt:message key="sales"/> ${salesSumOVP.amount} <fmt:message key="vat"/> ${valueAddedTaxSumOVP.amount} <fmt:message key="margin"/> ${marginSumOVP.amount}</p>--%>
<%--<p> <fmt:message key="three.layer.sandwich.panel"/> -  <fmt:message key="sales"/> ${salesSumTSP.amount} <fmt:message key="vat"/> ${valueAddedTaxSumTSP.amount} <fmt:message key="margin"/> ${marginSumTSP.amount}</p>--%>
<%--<p> <fmt:message key="gutter.systems"/> -  <fmt:message key="sales"/> ${salesSumVS.amount} <fmt:message key="vat"/> ${valueAddedTaxSumVS.amount} <fmt:message key="margin"/> ${marginSumVS.amount}</p>--%>
<%--<p> <fmt:message key="standard.finishes"/> -  <fmt:message key="sales"/> ${salesSumSEO.amount} <fmt:message key="vat"/> ${valueAddedTaxSumSEO.amount} <fmt:message key="margin"/> ${marginSumSEO.amount}</p>--%>
<%--<p> <fmt:message key="structural.elements"/> -  <fmt:message key="sales"/> ${salesSumENK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumENK.amount} <fmt:message key="margin"/> ${marginSumENK.amount}</p>--%>
<%--<p> <fmt:message key="safe.roof.elements"/> -  <fmt:message key="sales"/> ${salesSumEBK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumEBK.amount} <fmt:message key="margin"/> ${marginSumEBK.amount}</p>--%>
<%--<p> <fmt:message key="sandwich.panel"/> -  <fmt:message key="sales"/> ${salesSumSPPS.amount} <fmt:message key="vat"/> ${valueAddedTaxSumSPPS.amount} <fmt:message key="margin"/> ${marginSumSPPS.amount}</p>--%>
<%--<p> <fmt:message key="front.cassette"/> -  <fmt:message key="sales"/> ${salesSumFK.amount} <fmt:message key="vat"/> ${valueAddedTaxSumFK.amount} <fmt:message key="margin"/> ${marginSumFK.amount}</p>--%>
<%--<p> <fmt:message key="others"/> -  <fmt:message key="sales"/> ${salesSumOther.amount} <fmt:message key="vat"/> ${valueAddedTaxSumOther.amount} <fmt:message key="margin"/> ${marginSumOther.amount}</p>--%>
<%--<p> <fmt:message key="goods"/> - <fmt:message key="sales"/> ${salesSumGoods.amount} <fmt:message key="vat"/> ${valueAddedTaxSumGoods.amount} <fmt:message key="margin"/> ${marginSumGoods.amount}</p>--%>


<%--<form name="back" action="${pageContext.request.contextPath}/product_group.jsp" method="post">--%>
<%--    <button type="submit"><fmt:message key="back"/></button>--%>
<%--</form>--%>


</body>
</html>
