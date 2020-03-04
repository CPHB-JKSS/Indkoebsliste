<%--
  Created by IntelliJ IDEA.
  User: Joakim
  Date: 04-03-2020
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>
<h1>
    Velkommen til webshoppen.
</h1>

${sessionScope.message}
<br>
${requestScope.message}

<form action="LoginServlet" method="post">
    <label for="name">Username:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>


</body>
</html>
