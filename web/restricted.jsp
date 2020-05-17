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
    <a href="${pageContext.request.contextPath}/restricted.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/restricted.jsp?language=en">EN</a>
</div>
<h4><fmt:message key="restricted"/></h4> <br>

<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
