<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <span>
            <a href="?lang=ru">ru</a>
            <a href="?lang=en">en</a>
        </span>

        <form:label path="name"><spring:message code="username"/></form:label>
        <form:input path="name"/>
        <form:errors path="name"/>

        <form:label path="password"><spring:message code="password"/></form:label>
        <form:password path="password"/>
        <form:errors path="password"/>


    </fieldset>

    <footer>
        <form:label path="admin"><spring:message code="admin"/></form:label>
        <form:checkbox path="admin"/>

        <input type="submit" value="<spring:message code="submit"/>"/>
    </footer>
</form:form>

</body>
</html>
