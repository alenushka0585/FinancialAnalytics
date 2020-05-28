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
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="currency" type="com.epam.financial_analytics.entity.dictionary.Currency" scope="request"/>
<jsp:useBean id="organizationUnit" type="com.epam.financial_analytics.entity.dictionary.OrganizationUnit" scope="request"/>
<jsp:useBean id="report" type="java.util.Map" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/expense_result.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/expense_result.jsp?language=en">EN</a>
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
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="date"/>: ${date}</p>
        </div>
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="currency"/>: ${currency.name}</p>
        </div>
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="organization.unit"/> ${organizationUnit.name}</p>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4"></div>
            <table class="table table-bordered col-sm-4">
                <tbody>
                <tr>
                    <td><fmt:message key="salary"/></td>
                    <td>${report.get("Salary")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="factory"/></td>
                    <td>${report.get("Factory")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="transport"/></td>
                    <td>${report.get("Transport")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="package"/></td>
                    <td>${report.get("Package")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="rent"/></td>
                    <td>${report.get("Rent")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="others"/></td>
                    <td>${report.get("Other")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="phone"/></td>
                    <td>${report.get("Phone")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="business.trip"/></td>
                    <td>${report.get("BusinessTrip")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="advertisement"/></td>
                    <td>${report.get("Advertisement")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="acquiring"/></td>
                    <td>${report.get("Acquiring")}</td>
                </tr>
                </tbody>
            </table>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4">
                <form name="back" action="${pageContext.request.contextPath}/expense.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
