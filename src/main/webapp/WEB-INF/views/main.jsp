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
    <title>$Title$</title>
  </head>
  <body>
  $END$
  ${helloText}
  <fieldset>
    <label>Username</label>
    <input type="text" required placeholder="Input login"/>
    <label>Password</label>
    <input type="password" required placeholder="Input password."/>
  </fieldset>

  <footer>
    <input type="submit" value="Submit"/>
  </footer>
  </body>
</html>
