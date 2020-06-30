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
<jsp:useBean id="reportSales" type="java.util.Map" scope="request"/>
<jsp:useBean id="reportMargin" type="java.util.Map" scope="request"/>
<jsp:useBean id="reportVAT" type="java.util.Map" scope="request"/>
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
    <div class="container-fluid">
        <div class="col">
            <p class="h6 text-center" ><fmt:message key="period"/> <fmt:message key="from"/>: ${startDate} <fmt:message key="to"/>: ${finishDate} </p>
        </div>
        <div class="col">
            <p class="h6 text-center" >${organizationUnit}</p>
        </div>
        <br>
        <br>
        <div class="form-row">
            <div></div>
            <table class="table table-bordered justify-content-center">
                <thead>
                <tr>
                    <th rowspan="2" colspan="2"><fmt:message key="product.group"/></th>
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
<%--                </tr>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                    <th><fmt:message key="sales"/></th>--%>
<%--                    <th><fmt:message key="margin"/></th>--%>
<%--                    <th><fmt:message key="vat"/></th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
                <tbody>

                <tr>
                    <th rowspan="3"><fmt:message key="main.types.products"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('OVP')}">
                    <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('OVP')}">
                    <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('OVP')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="three.layer.sandwich.panel"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('TSP')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('TSP')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('TSP')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="gutter.systems"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('VS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('VS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('VS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="standard.finishes"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('SEO')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('SEO')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('SEO')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="structural.elements"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('ENK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('ENK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('ENK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="safe.roof.elements"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('EBK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('EBK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('EBK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th rowspan="3"><fmt:message key="sandwich.panel"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('SPPS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('SPPS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('SPPS')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="front.cassette"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('FK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('FK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('FK')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="others"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('Other')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('Other')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('Other')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>

                <tr>
                    <th rowspan="3"><fmt:message key="goods"/></th>
                    <th><fmt:message key="sales"/></th>
                    <c:forEach var="reportMap" items="${reportSales.get('Goods')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="margin"/></th>
                    <c:forEach var="reportMap" items="${reportMargin.get('Goods')}">
                        <td>${reportMap.value}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th><fmt:message key="vat"/></th>
                    <c:forEach var="reportMap" items="${reportVAT.get('Goods')}">
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
                <form name="back" action="${pageContext.request.contextPath}/product_group_for_period.jsp" method="post">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="back"/></button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
