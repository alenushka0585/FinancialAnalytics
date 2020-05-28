<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:23
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
                                <a class="nav-link" href="${pageContext.request.contextPath}/basic_indicator.jsp?language=ru">RU</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/basic_indicator.jsp?language=en">EN</a>
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
                    <fmt:message key="choose.indicator.date.currency"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <form name="basicIndicator" action="${pageContext.request.contextPath}/controller/basic_indicator" method="post">
            <div class="form-row justify-content-center">
                <label for="kindOfReport" class="col-sm-1.5 col-form-label">
                    <fmt:message key="kind.indicator"/>:
                </label>
                <div class="col-sm-2">
                    <select id="kindOfReport" class="form-control" name="kindOfReport" size="1">
                        <option value="Number of stuff"><fmt:message key="number.of.stuff"/></option>
                        <option value="Labour cost"> <fmt:message key="labour.cost"/></option>
                        <option value="Sales of square metres"> <fmt:message key="sales.sq.metres"/></option>
                        <option value="Sales of tons"><fmt:message key="sales.tons"/></option>
                        <option value="Revenue"><fmt:message key="revenue"/></option>
                    </select>
                </div>
                <label for="date" class="col-sm-0.5 col-form-label">
                    <fmt:message key="date"/>:
                </label>
                <div class="col-sm-1.2">
                    <input id="date" class="form-control" type="date" name="date" required>
                </div>
                <label for="currency" class="col-sm-1 col-form-label">
                    <fmt:message key="currency"/>:
                </label>
                <div class="col-sm-1">
                    <select id="currency" class="form-control" name="currency" size="1"> <option value="RUB">RUB</option></select>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <label for="amountKaraganda" class="col-sm-2 col-form-label" ><fmt:message key="karaganda"/>:</label>
                <div class="col-sm-4">
                    <input id="amountKaraganda" class="form-control justify-content-end" type="number" name="amountKaraganda" required>
                </div>
            </div>
            <div class="form-row  justify-content-center">
                <label for="amountAlmaty" class="col-sm-2 col-form-label"><fmt:message key="almaty"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAlmaty" class="form-control justify-content-end" type="number" name="amountAlmaty" required>
                </div>
            </div>
            <div class="form-row  justify-content-center">
                <label for="amountAtyrau" class="col-sm-2 col-form-label" ><fmt:message key="atyrau"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAtyrau" class="form-control" type="number" name="amountAtyrau" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountAstana" class="col-sm-2 col-form-label"><fmt:message key="astana"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAstana" class="form-control" type="number" name="amountAstana" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountAktobe" class="col-sm-2 col-form-label"><fmt:message key="aktobe"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAktobe" class="form-control" type="number" name="amountAktobe" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountOskemen" class="col-sm-2 col-form-label"><fmt:message key="oskemen"/>:</label>
                <div class="col-sm-4">
                    <input id="amountOskemen" class="form-control" type="number" name="amountOskemen" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountShymkent" class="col-sm-2 col-form-label"><fmt:message key="shymkent"/>:</label>
                <div class="col-sm-4">
                    <input id="amountShymkent" class="form-control" type="number" name="amountShymkent" required>
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
    </div>
</main>
</body>
</html>
