<%@ page import="Dto.EmployeeDto" %>
<%@ page import="Dao.EmployeeDao" %>
<%@ page import="Enum.State" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <title>Edit Form</title>
</head>
<body>

    <%
        String id=request.getParameter("id");
        EmployeeDao dao = new EmployeeDao();
        EmployeeDto dto = dao.getRecordById(Integer.parseInt(id));
    %>
    <h1> This is an edit page. </h1>
    <div class="container">
        <form action="/sheetal/Db_test" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="id" value="<%=dto.getId()%>">
            <div class="form-group">
                <label for="fullName">Full Name</label>
                <input type="text" class="form-control" id="fullName" placeholder="fullname" name="name" value="<%=dto.getFullName() %>">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="email" value="<%=dto.getEmail() %>">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="password" name="password" value="<%=dto.getPassword()%>">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address" value="<%=dto.getAddress()%>">
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" name="city" value="<%=dto.getCity()%>">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">State</label>
                    <select id="inputState" class="form-control" name="state" value="<%=dto.getState()%>">
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
                    <input type="text" class="form-control" id="inputZip" name="zip" value="<%=dto.getZip()%>">
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Update User</button>
        </form>
    </div>
</body>
</html>