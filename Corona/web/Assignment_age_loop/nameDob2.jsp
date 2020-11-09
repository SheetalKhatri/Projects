<%--
  Created by IntelliJ IDEA.
  User: Sheetal
  Date: 7/26/2020
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <title>nameDob</title>
</head>
<body>
<%
    int userCount = Integer.parseInt(request.getParameter("count"));
%>
<form action="calculateAge3.jsp" method="post">
    <% for (int i = 0; i < userCount; i++) { %>
    Name: <input type="text" name="name">
    DOB: <input type="date" name="bornYear"><br>
    <%}%>
    <br>
    <button type="submit" class="btn btn-success">Calculate</button>
</form>
</body>
</html>
