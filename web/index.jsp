<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <jsp:include page="style.jsp"/>
    <title>"Login"</title>
  </head>
  <body style="background: rgb(58,64,68); background: linear-gradient(6deg, rgba(58,64,68,1) 7%, rgba(154,164,175,1) 94%);">
  <h1 align="center">Login Page</h1>
  <div class="container h-100" >
    <div class="row h-100 justify-content-center align-items-center">
      <form action="/controller/login" method="post">
<%--        <input type="hidden" name="command" value="login">--%>
        <div class="form-group" >
          <label for="inputLogin" class="col-sm-2 col-form-label">Login</label>
          <div class="col-sm-10">
            <input type="text" name="login" class="form-control" id="inputLogin" maxlength="30" placeholder="Login"/>
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
          <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="inputPassword" maxlength="30" placeholder="Password"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-6">
            <button type="submit" class="btn btn-primary">Login</button>
          </div>
        </div>
      </form>
        <form>
            <fieldset>
                <legend>Вход на сайт</legend>
                <p>Логин: <input name="login"></p>
                <p>Пароль: <input type="password" name="password"></p>
                <p><button type="submit">Вход</button></p>
            </fieldset>
        </form>
    </div>
  </div>
<%--  <jsp:useBean id="errorMassage" class="com.epam.financial_analytics.service.ErrorMessage" scope="request" >--%>
<%--      <jsp:setProperty name="errorMassage" property="error" />--%>
<%--  </jsp:useBean>--%>
<%--  ОШИБКА: <jsp:getProperty name="errorMassage" property="error"/>--%>
  </body>
</html>
