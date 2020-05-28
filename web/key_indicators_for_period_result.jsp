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
<jsp:useBean id="startDate" type="java.sql.Date" scope="request"/>
<jsp:useBean id="finishDate" type="java.sql.Date" scope="request"/>
<jsp:useBean id="report" type="java.util.Map" scope="request"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/key_indicators_for_period_result.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/key_indicators_for_period_result.jsp?language=en">EN</a>
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
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4"></div>
            <table class="table table-bordered col-sm-4">
                <thead>
                <tr>
                    <th><fmt:message key="organization.unit"/></th>
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
                    <th><fmt:message key="karaganda"/></th>
                    <td>${report.get("Karaganda").get[0]}</td>
                    <td>${report.get("Karaganda").get[1]}</td>
                    <td>${report.get("Karaganda").get[2]}</td>
                    <td>${report.get("Karaganda").get[3]}</td>
                    <td>${report.get("Karaganda").get[4]}</td>
                    <td>${report.get("Karaganda").get[5]}</td>
                    <td>${report.get("Karaganda").get[6]}</td>
                    <td>${report.get("Karaganda").get[7]}</td>
                    <td>${report.get("Karaganda").get[8]}</td>
                    <td>${report.get("Karaganda").get[9]}</td>
                    <td>${report.get("Karaganda").get[10]}</td>
                    <td>${report.get("Karaganda").get[11]}</td>
                    <td>${report.get("Karaganda").get[12]}</td>
                </tr>
                <tr>
                    <th><fmt:message key="almaty"/></th>
                    <td>${report.get("Almaty").get("0")}</td>
                    <td>${report.get("Almaty").get("1")}</td>
                    <td>${report.get("Almaty").get("2")}</td>
                    <td>${report.get("Almaty").get("3")}</td>
                    <td>${report.get("Almaty").get("4")}</td>
                    <td>${report.get("Almaty").get("5")}</td>
                    <td>${report.get("Almaty").get("6")}</td>
                    <td>${report.get("Almaty").get("7")}</td>
                    <td>${report.get("Almaty").get("8")}</td>
                    <td>${report.get("Almaty").get("9")}</td>
                    <td>${report.get("Almaty").get("10")}</td>
                    <td>${report.get("Almaty").get("11")}</td>
                    <td>${report.get("Almaty").get("12")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="atyrau"/></th>
                    <td>${report.get("Atyrau").get("0")}</td>
                    <td>${report.get("Atyrau").get("1")}</td>
                    <td>${report.get("Atyrau").get("2")}</td>
                    <td>${report.get("Atyrau").get("3")}</td>
                    <td>${report.get("Atyrau").get("4")}</td>
                    <td>${report.get("Atyrau").get("5")}</td>
                    <td>${report.get("Atyrau").get("6")}</td>
                    <td>${report.get("Atyrau").get("7")}</td>
                    <td>${report.get("Atyrau").get("8")}</td>
                    <td>${report.get("Atyrau").get("9")}</td>
                    <td>${report.get("Atyrau").get("10")}</td>
                    <td>${report.get("Atyrau").get("11")}</td>
                    <td>${report.get("Atyrau").get("12")}</td>
                </tr>
                <tr>
                    <th><fmt:message key="astana"/></th>
                    <td>${report.get("Astana").get("0")}</td>
                    <td>${report.get("Astana").get("1")}</td>
                    <td>${report.get("Astana").get("2")}</td>
                    <td>${report.get("Astana").get("3")}</td>
                    <td>${report.get("Astana").get("4")}</td>
                    <td>${report.get("Astana").get("5")}</td>
                    <td>${report.get("Astana").get("6")}</td>
                    <td>${report.get("Astana").get("7")}</td>
                    <td>${report.get("Astana").get("8")}</td>
                    <td>${report.get("Astana").get("9")}</td>
                    <td>${report.get("Astana").get("10")}</td>
                    <td>${report.get("Astana").get("11")}</td>
                    <th>${report.get("Astana").get("12")}</th>
                </tr>
                <tr>
                    <th><fmt:message key="aktobe"/></th>
                    <td>${report.get("Aktobe").get("0")}</td>
                    <td>${report.get("Aktobe").get("1")}</td>
                    <td>${report.get("Aktobe").get("2")}</td>
                    <td>${report.get("Aktobe").get("3")}</td>
                    <td>${report.get("Aktobe").get("4")}</td>
                    <td>${report.get("Aktobe").get("5")}</td>
                    <td>${report.get("Aktobe").get("6")}</td>
                    <td>${report.get("Aktobe").get("7")}</td>
                    <td>${report.get("Aktobe").get("8")}</td>
                    <td>${report.get("Aktobe").get("9")}</td>
                    <td>${report.get("Aktobe").get("10")}</td>
                    <td>${report.get("Aktobe").get("11")}</td>
                    <th>${report.get("Aktobe").get("12")}</th>
                </tr>
                <tr>
                    <th><fmt:message key="oskemen"/></th>
                    <td>${report.get("Oskemen").get("0")}</td>
                    <td>${report.get("Oskemen").get("1")}</td>
                    <td>${report.get("Oskemen").get("2")}</td>
                    <td>${report.get("Oskemen").get("3")}</td>
                    <td>${report.get("Oskemen").get("4")}</td>
                    <td>${report.get("Oskemen").get("5")}</td>
                    <td>${report.get("Oskemen").get("6")}</td>
                    <td>${report.get("Oskemen").get("7")}</td>
                    <td>${report.get("Oskemen").get("8")}</td>
                    <td>${report.get("Oskemen").get("9")}</td>
                    <td>${report.get("Oskemen").get("10")}</td>
                    <td>${report.get("Oskemen").get("11")}</td>
                    <th>${report.get("Oskemen").get("12")}</th>
                </tr>
                <tr>
                    <th><fmt:message key="shymkent"/></th>
                    <td>${report.get("Shymkent").get("0")}</td>
                    <td>${report.get("Shymkent").get("1")}</td>
                    <td>${report.get("Shymkent").get("2")}</td>
                    <td>${report.get("Shymkent").get("3")}</td>
                    <td>${report.get("Shymkent").get("4")}</td>
                    <td>${report.get("Shymkent").get("5")}</td>
                    <td>${report.get("Shymkent").get("6")}</td>
                    <td>${report.get("AShymkent").get("7")}</td>
                    <td>${report.get("Shymkent").get("8")}</td>
                    <td>${report.get("Shymkent").get("9")}</td>
                    <td>${report.get("Shymkent").get("10")}</td>
                    <td>${report.get("Shymkent").get("11")}</td>
                    <th>${report.get("Shymkent").get("12")}</th>
                </tr>
                <tr>
                    <th><fmt:message key="total"/></th>
                    <th>${report.get("total").get("0")}</th>
                    <th>${report.get("total").get("1")}</th>
                    <th>${report.get("total").get("2")}</th>
                    <th>${report.get("total").get("3")}</th>
                    <th>${report.get("total").get("4")}</th>
                    <th>${report.get("total").get("5")}</th>
                    <th>${report.get("total").get("6")}</th>
                    <th>${report.get("total").get("7")}</th>
                    <th>${report.get("Atotal").get("8")}</th>
                    <th>${report.get("total").get("9")}</th>
                    <th>${report.get("total").get("10")}</th>
                    <th>${report.get("total").get("11")}</th>
                    <th>${report.get("total").get("12")}</th>
                </tr>
                </tbody>
            </table>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-6">
                <form name="back" action="${pageContext.request.contextPath}/key_indicators_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
