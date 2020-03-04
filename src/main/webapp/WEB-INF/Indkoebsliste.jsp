<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joakim
  Date: 04-03-2020
  Time: 00:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>
<h1>Webshop</h1>

${sessionScope.message}
Du er nu klar til at købe ind!

<form action="AddItemServlet" method="post">
    <label for="name">Varenavn: </label><br>
    <input type="text" id="name" name="product"><br>
    <input type="submit" value="Tilføj">
</form>
<br><br>

${requestScope.message}
<br>

<c:forEach var="element" items="${sessionScope.basket}">
    ${element}
    <br>
</c:forEach>

<form action="LogoutServlet" method="post">
    <input type="submit" value="Logud">
</form>
</body>
</html>
