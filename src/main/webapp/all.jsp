<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 06.01.2021
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Все пользователи</p>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>
                <a href="/edit/${user.id}">EDIT</a>
                <a href="/delete/${user.id}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
