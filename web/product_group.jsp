<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 02.05.2020
  Time: 23:52
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/product_group.jsp?language=ru">RU</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/product_group.jsp?language=en">EN</a>
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
        <form name="productGroupIndicator" action="${pageContext.request.contextPath}/controller/product_group" method="post">
            <div class="form-row justify-content-center">
                <label for="kindOfReport" class="col-sm-1.5 col-form-label">
                    <fmt:message key="kind.indicator"/>:
                </label>
                <div class="col-sm-2">
                    <select id="kindOfReport" class="form-control" name="kindOfReport" size="1">
                        <option value="<fmt:message key="product.group"/>"><fmt:message key="product.group"/></option>
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
                        <option value="Караганда"> <fmt:message key="karaganda"/> </option>
                        <option value="Алматы"> <fmt:message key="almaty"/> </option>
                        <option value="Атырау"> <fmt:message key="atyrau"/> </option>
                        <option value="Астана"> <fmt:message key="astana"/> </option>
                        <option value="Актобе"> <fmt:message key="aktobe"/> </option>
                        <option value="Оскемен"> <fmt:message key="oskemen"/> </option>
                        <option value="Шымкент"> <fmt:message key="shymkent"/> </option>
                    </select>
                </div>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ></h6>
                <h6 class="col-sm-2 col-form-label text-center text-uppercase" ><fmt:message key="sales"/></h6>
                <h6 class="col-sm-2 col-form-label text-center text-uppercase" ><fmt:message key="vat"/></h6>
                <h6 class="col-sm-2 col-form-label text-center text-uppercase" ><fmt:message key="margin"/></h6>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="main.types.products"/>:</h6>
                <label for="salesSumOVP"></label>
                <div class="col-sm-2">
                    <input id="salesSumOVP" class="form-control justify-content-end" type="number" name="salesSumOVP" required>
                </div>
                <label for="valueAddedSumOVP"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumOVP" class="form-control justify-content-end" type="number" name="valueAddedSumOVP" required>
                </div>
                <label for="marginSumOVP"></label>
                <div class="col-sm-2">
                    <input id="marginSumOVP" class="form-control justify-content-end" type="number" name="marginSumOVP" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="three.layer.sandwich.panel"/>:</h6>
                <label for="salesSumTSP"></label>
                <div class="col-sm-2">
                    <input id="salesSumTSP" class="form-control justify-content-end" type="number" name="salesSumTSP" required>
                </div>
                <label for="valueAddedSumTSP"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumTSP" class="form-control justify-content-end" type="number" name="valueAddedSumTSP" required>
                </div>
                <label for="marginSumTSP"></label>
                <div class="col-sm-2">
                    <input id="marginSumTSP" class="form-control justify-content-end" type="number" name="marginSumTSP" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="gutter.systems"/>:</h6>
                <label for="salesSumVS"></label>
                <div class="col-sm-2">
                    <input id="salesSumVS" class="form-control justify-content-end" type="number" name="salesSumVS" required>
                </div>
                <label for="valueAddedSumVS"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumVS" class="form-control justify-content-end" type="number" name="valueAddedSumVS" required>
                </div>
                <label for="marginSumVS"></label>
                <div class="col-sm-2">
                    <input id="marginSumVS" class="form-control justify-content-end" type="number" name="marginSumVS" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="standard.finishes"/>:</h6>
                <label for="salesSumSEO"></label>
                <div class="col-sm-2">
                    <input id="salesSumSEO" class="form-control justify-content-end" type="number" name="salesSumSEO" required>
                </div>
                <label for="valueAddedSumSEO"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumSEO" class="form-control justify-content-end" type="number" name="valueAddedSumSEO" required>
                </div>
                <label for="marginSumSEO"></label>
                <div class="col-sm-2">
                    <input id="marginSumSEO" class="form-control justify-content-end" type="number" name="marginSumSEO" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="structural.elements"/>:</h6>
                <label for="salesSumENK"></label>
                <div class="col-sm-2">
                    <input id="salesSumENK" class="form-control justify-content-end" type="number" name="salesSumENK" required>
                </div>
                <label for="valueAddedSumENK"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumENK" class="form-control justify-content-end" type="number" name="valueAddedSumENK" required>
                </div>
                <label for="marginSumENK"></label>
                <div class="col-sm-2">
                    <input id="marginSumENK" class="form-control justify-content-end" type="number" name="marginSumENK" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="safe.roof.elements"/>:</h6>
                <label for="salesSumEBK"></label>
                <div class="col-sm-2">
                    <input id="salesSumEBK" class="form-control justify-content-end" type="number" name="salesSumEBK" required>
                </div>
                <label for="valueAddedSumEBK"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumEBK" class="form-control justify-content-end" type="number" name="valueAddedSumEBK" required>
                </div>
                <label for="marginSumEBK"></label>
                <div class="col-sm-2">
                    <input id="marginSumEBK" class="form-control justify-content-end" type="number" name="marginSumEBK" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="sandwich.panel"/>:</h6>
                <label for="salesSumSPPS"></label>
                <div class="col-sm-2">
                    <input id="salesSumSPPS" class="form-control justify-content-end" type="number" name="salesSumSPPS" required>
                </div>
                <label for="valueAddedSumSPPS"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumSPPS" class="form-control justify-content-end" type="number" name="valueAddedSumSPPS" required>
                </div>
                <label for="marginSumSPPS"></label>
                <div class="col-sm-2">
                    <input id="marginSumSPPS" class="form-control justify-content-end" type="number" name="marginSumSPPS" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="front.cassette"/>:</h6>
                <label for="salesSumFK"></label>
                <div class="col-sm-2">
                    <input id="salesSumFK" class="form-control justify-content-end" type="number" name="salesSumFK" required>
                </div>
                <label for="valueAddedSumFK"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumFK" class="form-control justify-content-end" type="number" name="valueAddedSumFK" required>
                </div>
                <label for="marginSumFK"></label>
                <div class="col-sm-2">
                    <input id="marginSumFK" class="form-control justify-content-end" type="number" name="marginSumFK" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="others"/>:</h6>
                <label for="salesSumOther"></label>
                <div class="col-sm-2">
                    <input id="salesSumOther" class="form-control justify-content-end" type="number" name="salesSumOther" required>
                </div>
                <label for="valueAddedSumOther"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumOther" class="form-control justify-content-end" type="number" name="valueAddedSumOther" required>
                </div>
                <label for="marginSumOther"></label>
                <div class="col-sm-2">
                    <input id="marginSumOther" class="form-control justify-content-end" type="number" name="marginSumOther" required>
                </div>
            </div>
            <div class="form-row justify-content-center">
                <h6 class="col-sm-3 col-form-label" ><fmt:message key="goods"/>:</h6>
                <label for="salesSumGoods"></label>
                <div class="col-sm-2">
                    <input id="salesSumGoods" class="form-control justify-content-end" type="number" name="salesSumGoods" required>
                </div>
                <label for="valueAddedSumGoods"></label>
                <div class="col-sm-2">
                    <input id="valueAddedSumGoods" class="form-control justify-content-end" type="number" name="valueAddedSumGoods" required>
                </div>
                <label for="marginSumGoods"></label>
                <div class="col-sm-2">
                    <input id="marginSumGoods" class="form-control justify-content-end" type="number" name="marginSumGoods" required>
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
