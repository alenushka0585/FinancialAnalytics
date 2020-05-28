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
    <title></title></head>
<body>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user.jsp?language=en">EN</a>
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
                    <fmt:message key="user.panel"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <form name="create_user" action="${pageContext.request.contextPath}/create_user.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light  btn-rounded"><fmt:message key="create.user"/></button>
                </form>
            </div>
        </div>
        <div class="row justify-content-around">
            <div class="col-sm-4">
                <form name="update_user_password" action="${pageContext.request.contextPath}/update_user_password.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light  btn-rounded"><fmt:message key="update.password"/></button>
                </form>
            </div>
            <div class="col-sm-4">
                <form name="update_user_email" action="${pageContext.request.contextPath}/update_user_email.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light  btn-rounded"><fmt:message key="update.email"/></button>
                </form>
            </div>
        </div>
        <div class="row justify-content-between">
            <div class="col-sm-4">
                <form name="update_user_name" action="${pageContext.request.contextPath}/update_user_name.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light  btn-rounded"><fmt:message key="update.name"/></button>
                </form>
            </div>
            <div class="col-sm-4">
                <form name="update_user_role" action="${pageContext.request.contextPath}/update_user_role.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light  btn-rounded"><fmt:message key="update.role"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
