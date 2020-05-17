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
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/report_with_organization_unit_result.jsp?language=ru">RU</a>
    <a href="${pageContext.request.contextPath}/report_with_organization_unit_result.jsp?language=en">EN</a>
</div>
<jsp:useBean id="kindOfReport" type="java.lang.String" scope="request"/>
<jsp:useBean id="date" type="java.sql.Date" scope="request"/>
<jsp:useBean id="karaganda" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="almaty" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="atyrau" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="astana" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="aktobe" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="oskemen" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>
<jsp:useBean id="shymkent" type="com.epam.financial_analytics.entity.report_classes.ReportWithOrganization" scope="request"/>

<h4><fmt:message key="loaded.information"/></h4> <br>

<p><fmt:message key="kind.indicator"/> ${kindOfReport}</p>
<p><fmt:message key="date"/> ${date}</p>

<p> <fmt:message key="karaganda"/> ${karaganda.amount}</p>
<p> <fmt:message key="almaty"/> ${almaty.amount}</p>
<p> <fmt:message key="atyrau"/> ${atyrau.amount}</p>
<p> <fmt:message key="astana"/> ${astana.amount}</p>
<p> <fmt:message key="aktobe"/> ${aktobe.amount}</p>
<p> <fmt:message key="oskemen"/> ${oskemen.amount}</p>
<p> <fmt:message key="shymkent"/> ${shymkent.amount}</p>

<form name="back" action="${pageContext.request.contextPath}/basic_indicator.jsp" method="post">
    <button type="submit"><fmt:message key="back"/>/button>
</form>

<jsp:include page="admin_panel.jsp"/>
<jsp:include page="main_menu.jsp"/>
<jsp:include page="logout.jsp"/>

</body>
</html>
