<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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



<form method="post" action="uploadFile" enctype="multipart/form-data">
    <spring:message code="file"/> <input type="file" name="file"/>
    <input type="submit" value="<spring:message code="upload"/>"/>
    <spring:message code="uploadFile"/>
</form>



<form:form method="post" action="uploadFile" enctype="multipart/form-data" modelAttribute="uploadedFile">
    <table>
        <tr>
            <td><spring:message code="file"/></td>
            <td><input type="file" name="file"/></td>
            <td><form:errors path="file"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="<spring:message code="upload"/>"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
