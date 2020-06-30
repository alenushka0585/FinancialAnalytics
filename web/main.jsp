<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 15.04.2020
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <jsp:include page="style.jsp"/>
    <title></title></head>
<body>
<jsp:useBean id="user" type="com.epam.financial_analytics.entity.dictionary.User" scope="session" />
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/main.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/main.jsp?language=en">EN</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav justify-content-end">
                        <li class="nav-item active justify-content-end">
                            <form name="logout" action="${pageContext.request.contextPath}/controller/logout" method="post">
                                <button type="submit" class="btn btn-outline-light btn-sm"><fmt:message key="sign.out"/></button>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <br>
    <br>
    <br>
    <br>
    <div class="row">
        <div class="col">
            <p class="h4 text-center">
                <fmt:message key="hello"/> ${user.name}!
            </p>
        </div>
    </div>
    <br>
    <br>
    <c:choose>
    <c:when test="${sessionScope.user.role.name eq 'Admin'}">
    <div class="row justify-content-center">
        <div class="col-sm-6 btn-group">
            <button type="button" class="btn btn-outline-light btn-rounded dropdown-toggle" data-toggle="dropdown" aria-haspopup="menu" aria-expanded="false">
                <fmt:message key="admin.panel"/>
            </button>
            <div class="col-sm-11 dropdown-menu">
                <form name="basicIndicator" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="key.indicators" /></button>
                </form>
                <form name="metal_processing" action="${pageContext.request.contextPath}/metal_processing.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="metal.processing" /></button>
                </form>
                <form name="expense" action="${pageContext.request.contextPath}/expense.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="expenses" /></button>
                </form>
                <form name="productGroup" action="${pageContext.request.contextPath}/product_group.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="product.group" /></button>
                </form>
                <form name="currencyExchangeRate" action="${pageContext.request.contextPath}/currency_exchange_rate.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="currency.exchange.rate" />
                    </button>
                </form>
                <form name="user" action="${pageContext.request.contextPath}/user.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="user" /></button>
                </form>
            </div>
        </div>
        <div class="col-sm-6 btn-group">
            <button type="button" class="btn btn-outline-light btn-rounded dropdown-toggle" data-toggle="dropdown" aria-haspopup="menu" aria-expanded="false">
                <fmt:message key="report.generation"/>
            </button>
            <div class="col-sm-11 dropdown-menu">
                <form name="analytics" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="comparative.report" /></button>
                </form>
                <form name="absoluteIndicators = Absolute indicators" action="${pageContext.request.contextPath}/key_indicators_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="key.indicators.for.period"/></button>
                </form>
                <form name="expenseIndicatorForPeriod" action="${pageContext.request.contextPath}/expense_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="expense.indicators.for.period" /></button>
                </form>
                <form name="productGroupIndicatorForPeriod" action="${pageContext.request.contextPath}/product_group_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="product.group.for.period" /></button>
                </form>
            </div>
        </div>
    </div>
    </c:when>
    <c:otherwise>
        <div class="row align-items-center" >
            <div class="col-sm-12 justify-content-center btn-group">
                <button type="button" class="btn btn-outline-light btn-rounded-big dropdown-toggle" data-toggle="dropdown" aria-haspopup="menu" aria-expanded="false">
                    <fmt:message key="report.generation"/>
                </button>
                <div class="col-sm-12 dropdown-menu">
                    <form name="analytics" action="${pageContext.request.contextPath}/analytics.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="comparative.report" /></button>
                    </form>
                    <form name="keyIndicatorsForPeriod" action="${pageContext.request.contextPath}/key_indicators_for_period.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="key.indicators.for.period"/></button>
                    </form>
                    <form name="expenseIndicatorForPeriod" action="${pageContext.request.contextPath}/expense_for_period.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="expense.indicators.for.period" /></button>
                    </form>
                    <form name="productGroupIndicatorForPeriod" action="${pageContext.request.contextPath}/product_group_for_period.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="product.group.for.period" /></button>
                    </form>
                    <form name="currencyExchangeRateForThePeriod" action="${pageContext.request.contextPath}/currency_exchange_rate.jsp" method="post">
                        <button type="submit" class="btn btn-outline-dark  btn-rounded-small"><fmt:message key="currency.exchange.rate" />
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>
