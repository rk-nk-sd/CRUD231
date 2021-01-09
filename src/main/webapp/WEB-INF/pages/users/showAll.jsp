<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <title>Title</title>
</head>
<body>
<h1>Список пользователей</h1>
<hr/>
<a href="/users/new">Создать нового пользователя</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
<c:forEach var="user" items="${users}">
    <tr>

        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.email}</td>
        <td>
            <a href="users/${user.id}/edit">EDIT</a>
            <a href="users/${user.id}/delete">DELETE</a>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>
