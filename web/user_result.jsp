<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 05.05.2020
  Time: 18:20
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
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="newUser" type="com.epam.financial_analytics.entity.dictionary.User" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user_result.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user_result.jsp?language=en">EN</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav justify-content-end">
                        <li class="nav-item active justify-content-end">
                            <form name="main" action="${pageContext.request.contextPath}/main.jsp" method="post">
                                <button type="submit" class="btn btn-outline-light btn-sm">
                                    <fmt:message key="main.menu"/>
                                </button>
                            </form>
                        </li>
                        <li class="nav-item active justify-content-end">
                            <form name="logout" action="${pageContext.request.contextPath}/controller/logout" method="post">
                                <button type="submit" class="btn btn-outline-light btn-sm">
                                    <fmt:message key="sign.out"/>
                                </button>
                            </form>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <p class="h4 text-center">
                    <fmt:message key="loaded.information"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="kind.indicator"/>: ${kindOfReport}</p>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <table class="table table-bordered col-sm-4">
                <tbody>
                <tr>
                    <td><fmt:message key="user.name"/></td>
                    <td>${newUser.name}</td>
                </tr>
                <tr>
                    <td><fmt:message key="login"/></td>
                    <td>${newUser.login}</td>
                </tr>
                <tr>
                    <td><fmt:message key="password"/></td>
                    <td>${newUser.password}</td>
                </tr>
                <tr>
                    <td><fmt:message key="email"/></td>
                    <td>${newUser.EMail}</td>
                </tr>
                <tr>
                    <td><fmt:message key="role"/></td>
                    <td>${newUser.role.name}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4">
                <form name="back" action="${pageContext.request.contextPath}/user.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
