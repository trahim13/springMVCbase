<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.06.2018
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
    <title>Login</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="check-user">

    <fieldset>

        <form:label path="name">User name</form:label>
        <form:input path="name"/>

        <form:label path="password">Password</form:label>
        <form:password path="password"/>


    </fieldset>

    <footer>
        <form:label path="admin">is Admin?</form:label>
        <form:checkbox path="admin"/>

        <input type="submit" value="Submit"/>
    </footer>
</form:form>

</body>
</html>
