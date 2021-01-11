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

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>

<h1>Создать нового пользователя</h1>
<hr/>
<%--<form th:method="POST" actions="/users" th:object="${user}">--%>

<%--    <label for="name">Имя:</label>--%>
<%--    <input type="text" th:field="*{name}" id="name" />--%>
<%--    <p th:if="${#fields.hasErrors('name')}"/>--%>
<%--    --%>
<%--    <label for="surname">Фамилия:</label>--%>
<%--    <input type="text" th:field="*{surname}" id="surname">--%>
<%--    <p  th:if="${#fields.hasErrors('surname')}"/>--%>
<%--    --%>
<%--    <label for="email">E-mail:</label>--%>
<%--    <input type="text" th:field="*{email}" id="email">--%>
<%--    <p  th:if="${#fields.hasErrors('email')}"/>--%>
<%--    --%>
<%--    <input type="submit" value="Создать пользователя">--%>
<%--</form>--%>

<c:if test="${empty param.name}" var="noName" />
<c:if test="${empty param.surname}" var="noSurname" />
<c:if test="${empty param.email}" var="noEmail" />

<c:if
    test="${not (noName or noSurname or noEmail)}">
    <c:set value="${param.name}" var="name" scope="request"/>
    <c:set value="${param.surname}" var="surname" scope="request"/>
    <c:set value="${param.email}" var="email" scope="request"/>
    <jsp:forward page="users" />
</c:if>

<form method="post" action="/users">
    Enter your name:
    <input type="text" name="name" value="${user.name}" />


        <c:if test="${noName}">

    Note: you must enter a name

    </c:if>
    </p>
    Enter your Surname:
    <input type="text" name="surname" value="${user.surname}" />


    <c:if test="${noSurname}">

        Note: you must enter a name

    </c:if>
    </p>
    Enter your email address:
    <input type="text" name="email" value="${user.email}" />


    <c:if test="${noEmail}">

    Note: you must enter an email address

    </c:if>
    </p>

    <input type="submit" value="Создать пользователя" />
</form>
</body>
</html>