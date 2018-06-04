<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
    <title>Main</title>
  </head>
  <body>
  Hello user:
  <p>User name - ${user.name}</p>
  <p>User password - ${user.password}</p>
  <p>User is administrator - ${user.admin}</p>

  </body>
</html>
