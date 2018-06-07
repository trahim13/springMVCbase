<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
    <title>Main</title>
</head>
<body>
<p><spring:message code="hello"/></p>
<p><spring:message code="username"/> - ${user.name}</p>
<p><spring:message code="password"/> - ${user.password}</p>
<p><spring:message code="admin"/> - ${user.admin}</p>
<p>${locale}</p>


</body>
</html>
