<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:54
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
    <a href="${pageContext.request.contextPath}/create_user.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/create_user.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="create.user"/></h4> <br>
<form name="createUser" action="${pageContext.request.contextPath}/controller/create_user" method="post">
<p><fmt:message key="kind.indicator"/> <label><select class="mdb-select md-form" name="kindOfReport" size="1"><option value="<fmt:message key="creating.user"/>"><fmt:message key="creating.user"/></option></select></label></p>
    <p><fmt:message key="user.name"/> <label><input name="name" required></label></p>
<p><fmt:message key="login"/> <label><input name="login" required></label></p>
<p><fmt:message key="password"/> <label><input type="password" name="password" required></label></p>
<p><fmt:message key="email"/> <label><input type="email" name="email" required></label></p>
<p><fmt:message key="role"/> <label>
    <select class="mdb-select md-form" name="role" size="1">
        <option value="администратор"> <fmt:message key="admin"/> </option>
        <option value="директор"> <fmt:message key="director"/> </option>
        <option value="руководитель подразделения ОП Актобе"> <fmt:message key="head.of.aktobe"/> </option>
        <option value="руководитель подразделения ОП Алматы"> <fmt:message key="head.of.almaty"/> </option>
        <option value="руководитель подразделения ОП Астана"> <fmt:message key="head.of.astana"/> </option>
        <option value="руководитель подразделения ОП Атырау"> <fmt:message key="head.of.atyrau"/> </option>
        <option value="руководитель подразделения ОП Караганда"> <fmt:message key="head.of.karaganda"/> </option>
        <option value="руководитель подразделения ОП Оскемен"> <fmt:message key="head.of.oskemen"/> </option>
        <option value="руководитель подразделения ОП Шымкент"> <fmt:message key="head.of.shymkent"/> </option>
    </select>
</label>
</p>

    <p>
    <button type="submit"><fmt:message key="load.into.db"/></button>
    <input type="reset" value="<fmt:message key="clear"/>">
    </p>

</form>

<form name="back" action="${pageContext.request.contextPath}/user.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
