<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Текущий пользователь</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${user.getId()}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${user.getName()}</td>
    </tr>
    <tr>
        <td>Фамилия</td>
        <td>${user.getSurname()}</td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td>${user.getEmail()}</td>
    </tr>
</table>
</body>
</html>
