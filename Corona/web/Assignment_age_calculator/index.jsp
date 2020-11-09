<%--
  Created by IntelliJ IDEA.
  User: Sheetal
  Date: 7/14/2020
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <title>Age input</title>
  </head>
  <body>
  <form action="result.jsp" method="post">
    Name: <input type="text" name="name" required>
    Date of birth: <input type="date" name="year of birth" required>
    <button type="submit"> Calculate</button>
  </form>
  </body>
</html>
