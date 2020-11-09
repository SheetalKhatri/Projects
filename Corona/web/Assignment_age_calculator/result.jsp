<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Period" %><%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 7/21/2020
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String dob = request.getParameter("year of birth");
    LocalDate bYear = LocalDate.parse(dob);
    LocalDate ldNow = LocalDate.now();
    int age = Period.between(bYear,ldNow).getYears();

    out.println("Age of " + name + "is" + age);
%>

</body>
</html>
