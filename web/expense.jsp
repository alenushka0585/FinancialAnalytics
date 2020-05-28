<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:51
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/expense.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/expense.jsp?language=en">EN</a>
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
        <form name="basicIndicator" action="${pageContext.request.contextPath}/controller/expense" method="post">
            <div class="form-row justify-content-center">
                <label for="kindOfReport" class="col-sm-1.5 col-form-label">
                    <fmt:message key="kind.indicator"/>:
                </label>
                <div class="col-sm-2">
                    <select id="kindOfReport" class="form-control" name="kindOfReport" size="1">
                        <option value="<fmt:message key="expenses"/>"><fmt:message key="expenses"/></option>
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
                <label for="organization.unit" class="col-sm-1.5 col-form-label">
                    <fmt:message key="organization.unit"/>:
                </label>
                <div class="col-sm-1.5">
                    <select id="organization.unit" class="form-control" name="organizationUnit" size="1">
                        <option value="Karaganda"> <fmt:message key="karaganda"/> </option>
                        <option value="Almaty"> <fmt:message key="almaty"/> </option>
                        <option value="Atyrau"> <fmt:message key="atyrau"/> </option>
                        <option value="Astana"> <fmt:message key="astana"/> </option>
                        <option value="Aktobe"> <fmt:message key="aktobe"/> </option>
                        <option value="Oskemen"> <fmt:message key="oskemen"/> </option>
                        <option value="Shymkent"> <fmt:message key="shymkent"/> </option>
                    </select>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <label for="amountSalary" class="col-sm-2 col-form-label" ><fmt:message key="salary"/>:</label>
                <div class="col-sm-4">
                    <input id="amountSalary" class="form-control justify-content-end" type="number" name="amountSalary" required>
                </div>
            </div>
            <div class="form-row  justify-content-center">
                <label for="amountFactory" class="col-sm-2 col-form-label"><fmt:message key="factory"/>:</label>
                <div class="col-sm-4">
                    <input id="amountFactory" class="form-control justify-content-end" type="number" name="amountFactory" required>
                </div>
            </div>
            <div class="form-row  justify-content-center">
                <label for="amountTransport" class="col-sm-2 col-form-label" ><fmt:message key="transport"/>:</label>
                <div class="col-sm-4">
                    <input id="amountTransport" class="form-control" type="number" name="amountTransport" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountPackage" class="col-sm-2 col-form-label"><fmt:message key="package"/>:</label>
                <div class="col-sm-4">
                    <input id="amountPackage" class="form-control" type="number" name="amountPackage" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountRent" class="col-sm-2 col-form-label"><fmt:message key="rent"/>:</label>
                <div class="col-sm-4">
                    <input id="amountRent" class="form-control" type="number" name="amountRent" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountOther" class="col-sm-2 col-form-label"><fmt:message key="others"/>:</label>
                <div class="col-sm-4">
                    <input id="amountOther" class="form-control" type="number" name="amountOther" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountPhone" class="col-sm-2 col-form-label"><fmt:message key="phone"/>:</label>
                <div class="col-sm-4">
                    <input id="amountPhone" class="form-control" type="number" name="amountPhone" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountBusinessTrip" class="col-sm-2 col-form-label"><fmt:message key="business.trip"/>:</label>
                <div class="col-sm-4">
                    <input id="amountBusinessTrip" class="form-control" type="number" name="amountBusinessTrip" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountAdvertisement" class="col-sm-2 col-form-label"><fmt:message key="advertisement"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAdvertisement" class="form-control" type="number" name="amountAdvertisement" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <label for="amountAcquiring" class="col-sm-2 col-form-label"><fmt:message key="acquiring"/>:</label>
                <div class="col-sm-4">
                    <input id="amountAcquiring" class="form-control" type="number" name="amountAcquiring" required>
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
