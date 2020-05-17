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
    <a href="${pageContext.request.contextPath}/update_user_password.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/update_user_password.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="updating.password"/></h4> <br>
<form name="updateUser" action="${pageContext.request.contextPath}/controller/update_user_password" method="post">
    <p><fmt:message key="kind.indicator"/> <label><select class="mdb-select md-form" name="kindOfReport" size="1"><option value="<fmt:message key="updating.password"/>"><fmt:message key="updating.password"/></option></select>z</label>
    <p><fmt:message key="login"/> <label><input name="login"></label></p>
    <p><fmt:message key="new.password"/> <label><input type="password" name="password" required></label></p>
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
