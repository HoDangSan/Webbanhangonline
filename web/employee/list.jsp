<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/21/2019
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/employees?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <th>Employees Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Sex</th>
        <th>Position</th>
        <th>Salary</th>
        <th>revenueTargets</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["employees"]}' var="employee">
        <tr>
            <td><a href="/employees?action=view&id=${employee.getIdemployees()}">${employee.getEmployeesName()}</a></td>
            <td>${employee.getAddress()}</td>
            <td>${employee.getPhone()}</td>
            <td>${employee.getSex()}</td>
            <td>${employee.getPosition()}</td>
            <td>${employee.getSalary()}</td>
            <td>${employee.getRevenueTargets()}</td>
            <td><a href="/employees?action=edit&id=${employee.getIdemployees()}">edit</a></td>
            <td><a href="/employees?action=delete&id=${employee.getIdemployees()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

