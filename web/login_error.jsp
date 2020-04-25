<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginError</title>
</head>
<body>
Login or password is not correct, try again
<form name="login" action="${pageContext.request.contextPath}/index.jsp" method="post">
    <button type="submit">Назад</button>
</form>
</body>
</html>
