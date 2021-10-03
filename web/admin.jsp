<%@page import="java.util.List"%>
<%@page import="assignment.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        %>
        <h1>Hello Admin:<%= loginUser.getFullName()%></h1>

        <a href="MainController?action=Logout">Logout</a>

</body>
</html>
