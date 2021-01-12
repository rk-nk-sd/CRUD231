<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Обновить текущего пользователя</h1>

<%--<form th:method="PATCH" th:action="@{/users/{id}(id = ${user.id})}" th:object="${user}" >--%>
<%--    <label for="name">Enter name:</label>--%>
<%--    <input type="text" th:field="*{name}" id="name"/>--%>
<%--    <label for="name">Enter surname:</label>--%>
<%--    <input type="text" th:field="*{surname}" id="surname"/>--%>
<%--    <label for="name">Enter email:</label>--%>
<%--    <input type="text" th:field="*{email}" id="email"/>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="Update">--%>
<%--</form>--%>

<form method="post" action="/users/<c:out value='${user.id}'/>">
    <input type="hidden" name="_method" value="patch"/>
    ID: <c:out value="${user.id}" />
    </p>
    Enter your name:
    <input type="text" name="name" value="${user.name}" />


    <c:if test="${empty user.name}">

        Note: you must enter a name

    </c:if>
    </p>
    Enter your Surname:
    <input type="text" name="surname" value="${user.surname}" />


    <c:if test="${noName}">

        Note: you must enter a name

    </c:if>
    </p>
    Enter your email address:
    <input type="text" name="email" value="${user.email}" />


    <c:if test="${noEmail}">

        Note: you must enter an email address

    </c:if>
    </p>

    <input type="submit" value="Сохранить" />
</form>

</body>
</html>
