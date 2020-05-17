<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:52
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
    <a href="${pageContext.request.contextPath}/product_group.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/product_group.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="choose.indicator.date.currency.organization.unit"/></h4> <br>
<form name="productGroupIndicator" action="${pageContext.request.contextPath}/controller/product_group" method="post">
    <fmt:message key="kind.indicator"/> <label>
    <select class="mdb-select md-form" name="kindOfReport" size="1">
    <option value="<fmt:message key="product.group"/>"><fmt:message key="product.group"/></option></select>
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

    <p><label><select class="mdb-select md-form" name="ovp" size="1"><option value="ОВП"><fmt:message key="main.types.products"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumOVP" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumOVP" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumOVP" required></label></p>
    <p><label><select class="mdb-select md-form" name="tsp" size="1"><option value="ТСП"><fmt:message key="three.layer.sandwich.panel"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumTSP" required></label> <fmt:message key="vat"/> <label><input type="number"  name="valueAddedSumTSP" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumTSP" required></label></p>
    <p><label><select class="mdb-select md-form" name="vs" size="1"><option value="ВС"><fmt:message key="gutter.systems"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumVS" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumVS" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumVS" required></label></p>
    <p><label><select class="mdb-select md-form" name="seo" size="1"><option value="СЭО"><fmt:message key="standard.finishes"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumSEO" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumSEO" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumSEO" required></label></p>
    <p><label><select class="mdb-select md-form" name="enk" size="1"><option value="ЭНК"><fmt:message key="structural.elements"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumENK" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumENK" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumENK" required></label></p>
    <p><label><select class="mdb-select md-form" name="ebk" size="1"><option value="ЭБК"><fmt:message key="safe.roof.elements"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumEBK" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumEBK" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumEBK" required></label></p>
    <p><label><select class="mdb-select md-form" name="spps" size="1"><option value="СППС"><fmt:message key="sandwich.panel"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumSPPS" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumSPPS" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumSPPS" required></label></p>
    <p><label><select class="mdb-select md-form" name="fk" size="1"><option value="ФК"><fmt:message key="front.cassette"/></option></select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumFK" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumFK" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumFK" required></label></p>
    <p><label><select class="mdb-select md-form" name="other" size="1"><option value="Прочее"><fmt:message key="others"/></option> </select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumOther" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumOther" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumOther" required></label></p>
    <p><label><select class="mdb-select md-form" name="goods" size="1"><option value="Товары"><fmt:message key="goods"/></option> </select></label> <fmt:message key="sales"/> <label><input type="number" name="salesSumGoods" required></label> <fmt:message key="vat"/> <label><input type="number" name="valueAddedSumGoods" required></label> <fmt:message key="margin"/> <label><input type="number" name="marginSumGoods" required></label></p>

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
