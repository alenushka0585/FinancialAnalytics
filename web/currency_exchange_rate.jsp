<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:53
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/currency_exchange_rate.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/currency_exchange_rate.jsp?language=en">EN</a>
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
                    <fmt:message key="choose.indicator.date"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <form name="currencyExchangeRate" action="${pageContext.request.contextPath}/controller/currency_exchange_rate" method="post">
            <div class="form-row justify-content-center">
                <label for="kindOfReport" class="col-sm-1.5 col-form-label">
                    <fmt:message key="kind.indicator"/>:
                </label>
                <div class="col-sm-2.5">
                    <select id="kindOfReport" class="form-control" name="kindOfReport" size="1">
                        <option value="<fmt:message key="currency.exchange.rate"/>"><fmt:message key="currency.exchange.rate"/></option>
                    </select>
                </div>
                <label for="date" class="col-sm-0.5 col-form-label">
                    <fmt:message key="date"/>:
                </label>
                <div class="col-sm-1.2">
                    <input id="date" class="form-control" type="date" name="date" required>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-0.5 col-form-label" >RUB:</h6>
                <label for="rateRUB"></label>
                <div class="col-sm-2">
                    <input id="rateRUB" class="form-control justify-content-end" type="number" name="rateRUB" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-0.5 col-form-label" >USD:</h6>
                <label for="rateUSD"></label>
                <div class="col-sm-2">
                    <input id="rateUSD" class="form-control justify-content-end" type="number" name="rateUSD" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-0.5 col-form-label" >KZT:</h6>
                <label for="rateKZT"></label>
                <div class="col-sm-2">
                    <input id="rateKZT" class="form-control justify-content-end" type="number" name="rateKZT" required>
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
