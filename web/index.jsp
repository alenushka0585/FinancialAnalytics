<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="language"/>
<html>
  <head>
    <jsp:include page="style.jsp"/>
    <title></title>
  </head>
  <body>
  <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
      <div class="container-fluid">
          <div class="collapse navbar-collapse">
              <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                      <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp?language=ru">RU</a>
                  </li>
                  <li class="nav-item active">
                      <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp?language=en">EN</a>
                  </li>
              </ul>
          </div>
      </div>
  </nav>
  <div class="container h-100">
      <div class="row h-100 justify-content-center align-items-center">
        <form name="loginPage" action="${pageContext.request.contextPath}/controller/login" method="post" >
           <h3 class="text-sm-center"><fmt:message key="sign.in.system"/></h3>
            <br>
            <div class="form-group">
                <label for="login" class="col-sm-2 col-form-label"><fmt:message key="login"/></label>
                <div class="col-sm-12">
                    <input type="text" id="login" name="login" class="form-control" maxlength="30">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 col-form-label"><fmt:message key="password"/></label>
                <div class="col-sm-12">
                    <input type="password" id="password" name="password" class="form-control" maxlength="30">
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-outline-light btn-block"><fmt:message key="sign.in"/></button>
                </div>
            </div>
        </form>
      </div>
  </div>
  </body>
</html>
