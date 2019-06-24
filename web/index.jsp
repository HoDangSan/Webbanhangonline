<%@ page import="com.hodangsan.webbanhang.jdbc.DBConnection" %>

<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 20-Jun-19
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        if(conn == null){
          out.print("connection fail!");
        }
        else{
          out.print("connection success! <br><br>");
          out.print("<a href='/homes'>Home<a>");
        }
  %>
  </body>
</html>
