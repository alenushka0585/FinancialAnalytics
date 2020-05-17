<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 18:35
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
    <a href="${pageContext.request.contextPath}/login_error.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/login_error.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="wrong.login.password"/></h4> <br>
<form name="login" action="${pageContext.request.contextPath}/index.jsp" method="post">
    <button type="submit"><fmt:message key="back"/></button>
</form>
</body>
</html>
