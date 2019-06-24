<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 20-Jun-19
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/customer/style.css">
</head>
<body>
<h1 class="title-customer">Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table border="1" class="border-table">
    <tr>
        <th>Name</th>
        <th>Sex</th>
        <th>Phone</th>
        <th>Id User</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getIdcustomer()}">${customer.getCustomerName()}</a></td>
            <td>${customer.getSex()}</td>
            <td>${customer.getPhone()}</td>
            <td>${customer.getIduser()}</td>
            <td><a href="/customers?action=edit&id=${customer.getIdcustomer()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getIdcustomer()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
