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
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/user.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/user.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="user.panel"/></h4> <br>
<form name="create_user" action="${pageContext.request.contextPath}/create_user.jsp" method="post">
    <button type="submit"><fmt:message key="create.user"/></button>
</form>
<form name="update_user_password" action="${pageContext.request.contextPath}/update_user_password.jsp" method="post">
    <button type="submit"><fmt:message key="update.password"/></button>
</form>

<form name="update_user_email" action="${pageContext.request.contextPath}/update_user_email.jsp" method="post">
    <button type="submit"><fmt:message key="update.email"/></button>
</form>

<form name="update_user_name" action="${pageContext.request.contextPath}/update_user_name.jsp" method="post">
    <button type="submit"><fmt:message key="update.name"/></button>
</form>

<form name="update_user_role" action="${pageContext.request.contextPath}/update_user_role.jsp" method="post">
    <button type="submit"><fmt:message key="update.role"/></button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
