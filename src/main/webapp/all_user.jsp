<%@ page import="com.gmail.natalia.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nata
  Date: 30.08.2019
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p2>All user</p2>

<%
    List<User> users = (List<User>) request.getAttribute("users");
    for (User user : users) {
            out.print("<p>");
            out.print("<br>");
            out.print(user.getLastName()+" "+user.getName()+" "+user.getPhone());
            out.print("</p>");
        }
%>



</body>
</html>
