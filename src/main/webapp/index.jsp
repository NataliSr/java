<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/AddUserServlet" method="POST">
    Last name: <input type="text" name="last_name"><br>
    Name: <input type="text" name="name"><br>
    Phone: <input type="text" name="phone"><br>
    <input type="submit" value="Add User"> </input>
</form>
<a href="ShowAllUser">Show all user</a>

</body>
</html>
