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
    <title></title></head>
<body>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/restricted.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/restricted.jsp?language=en">EN</a>
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
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="h4 text-center">
                    <fmt:message key="restricted"/>
                </p>
            </div>
        </div>
        <br>
        <br>
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <form name="login" action="${pageContext.request.contextPath}/main.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="main.menu"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
