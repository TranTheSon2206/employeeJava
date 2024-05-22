<%@ page import="com.example.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Employee List</h2>
    <a href="employee.jsp" class="btn btn-success">Add a new</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Position</th>
            <th>Department</th>
        </tr>
        </thead>
        <tbody>
        <% com.example.da.EmployeeDAO employeeDAO = new com.example.da.EmployeeDAO();
            List<Employee> employees = employeeDAO.getAllEmployees();
            for (com.example.entity.Employee employee : employees) { %>
        <tr>
            <td><%= employee.getID() %></td>
            <td><%= employee.getFullName() %></td>
            <td><%= employee.getBirthday() %></td>
            <td><%= employee.getAddress() %></td>
            <td><%= employee.getPosition() %></td>
            <td><%= employee.getDepartment() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
