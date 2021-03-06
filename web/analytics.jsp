<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 14:48
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/analytics.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/analytics.jsp?language=en">EN</a>
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
                    <fmt:message key="choose.details.for.report"/>
                </p>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <form name="result" action="${pageContext.request.contextPath}/controller/analytics" method="post">
            <div class="form-row justify-content-center">
                <h6 class="col-sm-2"><fmt:message key="current.period"/></h6>
                <label for="presentPeriodStartDate" class="col-sm-1 col-form-label">
                    <fmt:message key="from"/>:
                </label>
                <div class="col-sm-3">
                    <input id="presentPeriodStartDate" class="form-control" type="date" name="presentPeriodStartDate" required>
                </div>
                <label for="presentPeriodFinishDate" class="col-sm-1 col-form-label">
                    <fmt:message key="to"/>:
                </label>
                <div class="col-sm-3">
                    <input id="presentPeriodFinishDate" class="form-control" type="date" name="presentPeriodFinishDate" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-2"><fmt:message key="past.period"/></h6>
                <label for="pastPeriodStartDate" class="col-sm-1 col-form-label">
                    <fmt:message key="from"/>:
                </label>
                <div class="col-sm-3">
                    <input id="pastPeriodStartDate" class="form-control" type="date" name="pastPeriodStartDate" required>
                </div>
                <label for="pastPeriodFinishDate" class="col-sm-1 col-form-label">
                    <fmt:message key="to"/>:
                </label>
                <div class="col-sm-3">
                    <input id="pastPeriodFinishDate" class="form-control" type="date" name="pastPeriodFinishDate" required>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <label for="organizationUnit" class="col-sm-1.5 col-form-label">
                    <fmt:message key="organization.unit"/>:
                </label>
                <div class="col-sm-3">
                    <select id="organizationUnit" class="form-control" name="organizationUnit" size="1">
                        <option value="Kazakhstan"><fmt:message key="kazakhstan"/></option>
                        <option value="Karaganda"><fmt:message key="karaganda"/></option>
                        <option value="Almaty"><fmt:message key="almaty"/></option>
                        <option value="Atyrau"><fmt:message key="atyrau"/></option>
                        <option value="Astana"><fmt:message key="astana"/></option>
                        <option value="Aktobe"><fmt:message key="aktobe"/></option>
                        <option value="Oskemen"><fmt:message key="oskemen"/></option>
                        <option value="Shymkent"><fmt:message key="shymkent"/></option>
                    </select>
                </div>
                <label for="currency" class="col-sm-2 col-form-label">
                    <fmt:message key="currency"/>:
                </label>
                <div class="col-sm-1">
                    <select id="currency" class="form-control" name="currency" size="1">
                        <option value="KZT">KZT</option>
                        <option value="RUB">RUB</option>
                        <option value="USD">USD</option>
                    </select>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <div class="col-xs-1">
                    <button class="btn btn-outline-light" type="submit"><fmt:message key="generate.report"/></button>
                </div>
                <div class="col-xs-1">
                    <input class="btn btn-outline-light" type="reset" value="<fmt:message key="clear"/>">
                </div>
            </div>
        </form>
    </div>
</main>









<%--<div>--%>
<%--    <a href="${pageContext.request.contextPath}/analytics.jsp?language=ru">RU</a>--%>
<%--    <a href="${pageContext.request.contextPath}/analytics.jsp?language=en">EN</a>--%>
<%--</div>--%>
<%--<h4><fmt:message key="choose.details.for.report"/></h4> <br>--%>
<%--<form name="result" action="${pageContext.request.contextPath}/controller/analytics" method="post">--%>
<%--    <p><fmt:message key="current.period"/>--%>
<%--        <fmt:message key="from"/> <label><input type="date" name="presentPeriodStartDate" required></label>--%>
<%--        <fmt:message key="to"/> <label><input type="date" name="presentPeriodFinishDate" required></label>--%>
<%--    </p>--%>
<%--    <p><fmt:message key="past.period"/>--%>
<%--        <fmt:message key="from"/> <label><input type="date" name="pastPeriodStartDate" required></label>--%>
<%--        <fmt:message key="to"/> <label><input type="date" name="pastPeriodFinishDate" required></label>--%>
<%--    </p>--%>


<%--    <p><fmt:message key="organization.unit"/> <label>--%>
<%--        <select class="mdb-select md-form" name="organizationUnit" size="1">--%>
<%--            <option value="Казахстан"><fmt:message key="kazakhstan"/></option>--%>
<%--            <option value="Караганда"><fmt:message key="karaganda"/></option>--%>
<%--            <option value="Алматы"><fmt:message key="almaty"/></option>--%>
<%--            <option value="Атырау"><fmt:message key="atyrau"/></option>--%>
<%--            <option value="Астана"><fmt:message key="astana"/></option>--%>
<%--            <option value="Актобе"><fmt:message key="aktobe"/></option>--%>
<%--            <option value="Оскемен"><fmt:message key="oskemen"/></option>--%>
<%--            <option value="Шымкент"><fmt:message key="shymkent"/></option>--%>
<%--        </select>--%>
<%--    </label>--%>
<%--        <fmt:message key="currency"/> <label>--%>
<%--            <select class="mdb-select md-form" name="currency" size="1">--%>
<%--            <option value="KZT">KZT</option>--%>
<%--            <option value="RUB">RUB</option>--%>
<%--            <option value="USD">USD</option>--%>
<%--        </select>--%>
<%--        </label>--%>
<%--    </p>--%>
<%--    <button type="submit"><fmt:message key="generate.report"/></button>--%>
<%--    <input type="reset" value="<fmt:message key="clear"/>">--%>
<%--</form>--%>


</body>
</html>
