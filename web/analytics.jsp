<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 19.04.2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Analytics</title>
</head>
<body>
Analytics
<form name="result" action="${pageContext.request.contextPath}/controller/analytics" method="post">
    <p>Текущий период
        с <input type="date" name="presentPeriodStartDate">
        по <input type="date" name="presentPeriodFinishDate">
    </p>
    <p>Прошлый период
        с <input type="date" name="pastPeriodStartDate">
        по <input type="date" name="pastPeriodFinishDate">
    </p>
    <p>Подразделение <select name="organizationUnit" size="1">
        <option value="Казахстан"> Казахстан </option>
        <option value="Караганда"> Караганда </option>
        <option value="Алматы"> Алматы </option>
        <option value="Атырау"> Атырау </option>
        <option value="Астана"> Астана </option>
        <option value="Актобе"> Актобе </option>
        <option value="Оскемен"> Оскемен </option>
        <option value="Шымкент"> Шымкент </option>
    </select>
        Валюта <select name="currency" size="1">
        <option value="KZT">KZT</option>
        <option value="RUB">RUB</option>
        <option value="USD">USD</option>
    </select>
    </p>
    <button type="submit">Сформировать</button>
    <input type="reset" value="Очистить">
</form>
</body>
</html>
