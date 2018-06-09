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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
    function doAjaxPassword() {
        $.ajax({
            url: 'checkPassword',
            data: ({password: $('#password').val()}),
            success: function (data) {
                $('#passwordResult').html(data);
            }
        });
    }

    function doAjaxName() {
        $.ajax({
            url: 'checkName',
            data: ({name: $('#name').val()}),
            success: function (data) {
                $('#nameResult').html(data);
            }
        });
    }
</script>


<form:form modelAttribute="user" method="post" action="check-user">

    <fieldset>

        <span>
            <a href="?lang=ru"><spring:message code="ru"/></a>
            <a href="?lang=en"><spring:message code="en"/></a>
        </span>

        <form:label path="name"><spring:message code="username"/></form:label>
        <form:input path="name" onkeyup="doAjaxName()"/>
        <form:errors path="name"/>
        <span style="float: right;" id="NameResult"></span>

        <form:label path="password"><spring:message code="password"/></form:label>
        <form:password path="password" onkeyup="doAjaxPassword()"/>
        <form:errors path="password"/>
        <span style="float: right;" id="passwordResult"></span>


    </fieldset>

    <footer>
        <form:label path="admin"><spring:message code="admin"/></form:label>
        <form:checkbox path="admin"/>

        <input type="submit" value="<spring:message code="submit"/>"/>
    </footer>
</form:form>

</body>
</html>
