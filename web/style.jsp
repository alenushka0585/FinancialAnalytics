<%--
  Created by IntelliJ IDEA.
  User: Фора
  Date: 11.04.2020
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title><fmt:message key="financial.analytics"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <link rel="stylesheet" href="lib/css/bootstrap.min.css">
    <style type="text/css">
        body {
            background: rgb(109,189,233);
            background: radial-gradient(circle, rgba(109,189,233,1) 0%, rgba(31,112,157,1) 100%);
            font-family: "Segoe UI","Segoe",Tahoma,Helvetica,Arial,sans-serif;
            color: whitesmoke;
        }

        p {
            font-family: "Segoe UI","Segoe",Tahoma,Helvetica,Arial,sans-serif;
            color: whitesmoke;
        }

        select {
            font-family: "Segoe UI","Segoe",Tahoma,Helvetica,Arial,sans-serif;
            color: black;
        }

        .navbar {
            background: rgb(57,130,171);
            background: radial-gradient(circle, rgba(57,130,171,1) 0%, rgba(5,89,136,1) 100%);
            height: fit-content;
            color: whitesmoke;
        }

        .btn-rounded {
            height: 100px;
            width: 100%;
            border-radius: 50px;
            text-align: center;
            font-size: larger;
        }
        .btn-rounded-small {
            height: 50px;
            width: 100%;
            border-radius: 25px;
            text-align: center;
            font-size: large;
        }


        .btn-rounded-big {
            height: 150px;
            width: 100%;
            border-radius: 75px;
            text-align: center;
            font-size: larger;
        }

    </style>
</head>
<body>
<script src="lib/jquery-3.5.0.min.js"></script>
<script src="lib/js/popper.min.js"></script>
<script src="lib/js/bootstrap.min.js"></script>
</body>
</html>
