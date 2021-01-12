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
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Список пользователей</h1>
<hr/>
<a href="/users/new" class="c">Создать нового пользователя</a>
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

        <td><a href="users/${user.id}">${user.id}</a></td>
        <td><a href="users/${user.id}">${user.name}</a></td>
        <td><a href="users/${user.id}">${user.surname}</a></td>
        <td><a href="users/${user.id}">${user.email}</a></td>
        <td>
            <a href="users/${user.id}" class="c">Сведения</a>
            <a href="users/${user.id}/edit" class="c">Редактировать</a>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>
