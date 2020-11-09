<%@ page import="java.time.Period" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Sheetal
  Date: 7/26/2020
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculateAge</title>
</head>
<body>
<% String userName[] = request.getParameterValues("name");
    String dob[] = request.getParameterValues("bornYear");
    LocalDate currentYear = LocalDate.now();
    int minAge = Integer.MAX_VALUE;
    int maxAge = 0;
    String youngest = " ";
    String oldest = " ";
    String msg = "Name: %s   DOB: %s   Age: %s";

    for (int i = 0; i < userName.length; i++) {
        LocalDate birthYear = LocalDate.parse(dob[i]);
        int age = Period.between(birthYear, currentYear).getYears();
        out.println(String.format(msg, userName[i], dob[i], age + "<br>"));

        if (age > maxAge) {
            maxAge = age;
            oldest = userName[i];
        }

        if (age < minAge) {
            minAge = age;
            youngest = userName[i];
        }
    }
    out.println("Youngest: " + youngest + "   age: " + minAge + "<br>");
    out.println("Oldest: " + oldest + "   age: " + maxAge);%>
</body>
</html>