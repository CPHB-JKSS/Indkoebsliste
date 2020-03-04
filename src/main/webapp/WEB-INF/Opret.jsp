<%--
  Created by IntelliJ IDEA.
  User: Joakim
  Date: 04-03-2020
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>
${requestScope.message}
<br>
Her kan du registrere dig som bruger på indkøbslisten.
<br>
<form action="OpretServlet" method="post">
    <label for="name">Username:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
