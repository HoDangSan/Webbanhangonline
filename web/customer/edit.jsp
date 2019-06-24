<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 21-Jun-19
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="customerName" id="customerName" value="${requestScope["customer"].getCustomerName()}"></td>
            </tr>
            <tr>
                <td>Sex: </td>
                <td><input type="text" name="sex" id="sex" value="${requestScope["customer"].getSex()}"></td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td><input type="text" name="phone" id="phone" value="${requestScope["customer"].getPhone()}"></td>
            </tr>
            <tr>
                <td>Id User: </td>
                <td><input type="text" name="iduser" id="iduser" value="${requestScope["customer"].getIduser()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
