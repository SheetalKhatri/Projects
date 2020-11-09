<%@page import="Enum.State" %>
<%@page import="Dto.EmployeeDto" %>
<%@page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 7/31/2020
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>Employee Registration</title>
</head>
<body>
<div class="container">
    <form action="/sheetal/Db_test" method="post">
        <div class="form-group">
            <label for="fullName">Full Name</label>
            <input type="text" class="form-control" id="fullName" placeholder="fullname" name="name">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="email">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Password</label>
                <input type="password" class="form-control" id="inputPassword4" placeholder="password" name="password">
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address">
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">State</label>
                <select id="inputState" class="form-control" name="state">
                    <option selected>Choose...</option>
                    <%
                        State[] arr = State.values();
                        for (State state : arr) {

                    %>
                    <option value="<%=state%>"><%=state%>
                    </option>
                    <% }%>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="inputZip">Zip</label>
                <input type="text" class="form-control" id="inputZip" name="zip">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">FullName</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">City</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>

            <%
            List<EmployeeDto> dtos = (List<EmployeeDto>) request.getAttribute("employees");
            if (null != dtos) {
                for (int i = 0; i < dtos.size(); i++) {
        %>
        <tr>
            <th scope="row"><%=i + 1%>
            </th>
            <td><%=dtos.get(i).getFullName()%>
            </td>
            <td><%=dtos.get(i).getEmail()%>
            </td>
            <td><%=dtos.get(i).getAddress()%>
            </td>
            <td><%=dtos.get(i).getCity()%>
            </td>
                            <td><a href="Db_test?action=d&id=<%=dtos.get(i).getId()%>" class="btn btn-sm btn-danger">Delete</a> |
                                <a href="Db_test/edit.jsp?id=<%=dtos.get(i).getId()%>" class="btn btn-sm btn-info">Edit</a>
                            </td>
        </tr>
            <%
                }
            }
        %>

</body>
</html>
