<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru"  xmlns:th="http://thymeleaf.org">
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>

<h1>Создать нового пользователя</h1>
<hr/>
<c:if test="${param.submitted}">

    <c:if test="${empty param.name}" var="noName" />
    <c:if test="${empty param.surname}" var="noSurname" />
    <c:if test="${empty param.email}" var="noEmail" />
    <c:if test="${not (noName or noSurname or noEmail)}">
        <c:set value="${param.name}" var="name" scope="request"/>
        <c:set value="${param.surname}" var="surname" scope="request"/>
        <c:set value="${param.email}" var="email" scope="request"/>
        <jsp:forward page="notFaund.jsp" />
    </c:if>

</c:if>
<form method="post" action="/users">
<%--    <input type="hidden" name="submitted" value="true" />--%>
    Enter your name:
    <input type="text" name="name"
           value="<c:out value='${param.name}'/>" />


        <c:if test="${noName}">

    Note: you must enter a name

    </c:if>
    </p>
    Enter your Surname:
    <input type="text" name="name"
           value="<c:out value='${param.surname}'/>" />


    <c:if test="${noName}">

        Note: you must enter a name

    </c:if>
    </p>
    Enter your email address:
    <input type="text" name="email"
           value="<c:out value='${param.email}'/>" />


    <c:if test="${noEmail}">

    Note: you must enter an email address

    </c:if>
    </p>

    <input type="submit" value="Sign up" />
</form>
</body>
</html>
