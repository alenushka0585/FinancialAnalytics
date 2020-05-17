<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:50
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
    <a href="${pageContext.request.contextPath}/metal_processing.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/metal_processing.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="choose.indicator.date.organization.unit"/></h4> <br>
<form name="metalProcessing" action="${pageContext.request.contextPath}/controller/metal_processing" method="post">
    <p>
        <fmt:message key="kind.indicator"/> <label>
        <select class="mdb-select md-form" name="kindOfReport" size="1">
        <option value="Переработка металла"><fmt:message key="metal.processing"/></option>
    </select>
    </label>
        <fmt:message key="date"/> <label><input type="date" name="date" required></label></p>

    <p><label><select class="mdb-select md-form" name="karaganda" size="1"> <option value="Караганда"><fmt:message key="karaganda"/></option></select></label> <label><input type="number" name="amountKaraganda" required></label></p>
    <p><label><select class="mdb-select md-form" name="almaty" size="1"><option value="Алматы"><fmt:message key="almaty"/></option></select></label> <label><input type="number" name="amountAlmaty" required></label></p>

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
