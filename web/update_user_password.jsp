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
    <title></title></head>
<body>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/update_user_password.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/update_user_password.jsp?language=en">EN</a>
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
                    <fmt:message key="update.password"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <form name="updateUser" action="${pageContext.request.contextPath}/controller/update_user_password" method="post">
            <div class="form-row justify-content-center">
                <label for="kindOfReport" class="col-sm-1.5 col-form-label">
                    <fmt:message key="kind.indicator"/>:
                </label>
                <div class="col-sm-2.5">
                    <select id="kindOfReport" class="form-control" name="kindOfReport" size="1">
                        <option value="<fmt:message key="updating.password"/>"><fmt:message key="updating.password"/></option>
                    </select>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-2 col-form-label" ><fmt:message key="login"/>:</h6>
                <label for="login"></label>
                <div class="col-sm-4">
                    <input id="login" class="form-control justify-content-end" type="text" name="login" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-2 col-form-label" ><fmt:message key="new.password"/>:</h6>
                <label for="password"></label>
                <div class="col-sm-4">
                    <input id="password" class="form-control justify-content-end" type="password" name="password" required>
                </div>
            </div>
            <br>
            <div class="form-row justify-content-center">
                <div class="col-xs-1">
                    <button class="btn btn-outline-light" type="submit"><fmt:message key="load.into.db"/></button>
                </div>
                <div class="col-xs-1">
                    <input class="btn btn-outline-light" type="reset" value="<fmt:message key="clear"/>">
                </div>
            </div>
        </form>
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
