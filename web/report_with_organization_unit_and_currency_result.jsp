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
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-4"></div>
            <table class="table table-bordered col-sm-4">
                <tbody>
                <tr>
                    <td><fmt:message key="karaganda"/></td>
                    <td>${report.get("Karaganda")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="almaty"/></td>
                    <td>${report.get("Almaty")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="atyrau"/></td>
                    <td>${report.get("Atyrau")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="astana"/></td>
                    <td>${report.get("Astana")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="aktobe"/></td>
                    <td>${report.get("Aktobe")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="oskemen"/></td>
                    <td>${report.get("Oskemen")}</td>
                </tr>
                <tr>
                    <td><fmt:message key="shymkent"/></td>
                    <td>${report.get("Shymkent")}</td>
                </tr>
                </tbody>
            </table>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <br>
        <div class="form-row justify-content-center">
            <div class="col-sm-6">
                <form name="back" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>

<%--<jsp:useBean id="karaganda" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="almaty" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="atyrau" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="astana" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="aktobe" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="oskemen" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>
<%--<jsp:useBean id="shymkent" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency" scope="request"/>--%>

<%--<h4><fmt:message key="loaded.information"/></h4> <br>--%>

<%--<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>--%>
<%--<p><fmt:message key="date"/> ${date}</p>--%>
<%--<p><fmt:message key="currency"/> ${currency.name}</p>--%>

<%--<p> <fmt:message key="karaganda"/> ${karaganda.amount}</p>--%>
<%--<p> <fmt:message key="almaty"/> ${almaty.amount}</p>--%>
<%--<p> <fmt:message key="atyrau"/> ${atyrau.amount}</p>--%>
<%--<p> <fmt:message key="astana"/> ${astana.amount}</p>--%>
<%--<p> <fmt:message key="aktobe"/> ${aktobe.amount}</p>--%>
<%--<p> <fmt:message key="oskemen"/> ${oskemen.amount}</p>--%>
<%--<p> <fmt:message key="shymkent"/> ${shymkent.amount}</p>--%>

<%--<form name="back" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">--%>
<%--    <button type="submit"><fmt:message key="back"/></button>--%>
<%--</form>--%>


</body>
</html>
