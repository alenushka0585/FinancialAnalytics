<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 05.05.2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title></title></head>
<body>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="startDate" type="java.sql.Date" scope="request"/>
<jsp:useBean id="finishDate" type="java.sql.Date" scope="request"/>
<jsp:useBean id="organizationUnit" type="java.lang.String" scope="request"/>
<jsp:useBean id="report" type="java.util.Map" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
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
                    <fmt:message key="kind.indicator"/>: ${kindOfReport}
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="period"/> <fmt:message key="from"/>: ${startDate} <fmt:message key="to"/>: ${finishDate} </p>
        </div>
        <div class="col">
            <p class="h6 text-center" >${organizationUnit}</p>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4"></div>
            <table class="table table-bordered col-sm-4">
                <thead>
                <tr>
                    <th><fmt:message key="expense.type"/></th>
                    <th><fmt:message key="january"/></th>
                    <th><fmt:message key="february"/></th>
                    <th><fmt:message key="march"/></th>
                    <th><fmt:message key="april"/></th>
                    <th><fmt:message key="may"/></th>
                    <th><fmt:message key="june"/></th>
                    <th><fmt:message key="july"/></th>
                    <th><fmt:message key="august"/></th>
                    <th><fmt:message key="september"/></th>
                    <th><fmt:message key="october"/></th>
                    <th><fmt:message key="november"/></th>
                    <th><fmt:message key="december"/></th>
                    <th><fmt:message key="total"/></th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <th><fmt:message key="salary"/></th>
                    <c:forEach var="reportMap" items="${report.get('Salary')}">
                    <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th><fmt:message key="factory"/></th>
                    <c:forEach var="reportMap" items="${report.get('Factory')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="transport"/></th>
                    <c:forEach var="reportMap" items="${report.get('Transport')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="package"/></th>
                    <c:forEach var="reportMap" items="${report.get('Package')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="rent"/></th>
                    <c:forEach var="reportMap" items="${report.get('Rent')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="others"/></th>
                    <c:forEach var="reportMap" items="${report.get('Other')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="phone"/></th>
                    <c:forEach var="reportMap" items="${report.get('Phone')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="business.trip"/></th>
                    <c:forEach var="reportMap" items="${report.get('BusinessTrip')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="advertisement"/></th>
                    <c:forEach var="reportMap" items="${report.get('Advertisement')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="acquiring"/></th>
                    <c:forEach var="reportMap" items="${report.get('Acquiring')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="total"/></th>
                    <c:forEach var="reportMap" items="${report.get('total')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-6">
                <form name="back" action="${pageContext.request.contextPath}/expense_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
