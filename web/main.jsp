<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 15.04.2020
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h1 align="center">Choose what are you going to do</h1>
<%--add checking user--%>
<form name="administration" action="${pageContext.request.contextPath}/controller/administration" method="post">
    <button type="submit">Администирование</button>
</form>
<form name="analytics" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
    <button type="submit">Отчет</button>
</form>
<p>
<%--    <jsp:useBean id="user" type="com.epam.financial_analytics.entity.dictionary.User" scope="session" />--%>
    User name: ${user.name} <br>
    User role: ${user.role.id}
</p>

</body>
</html>
