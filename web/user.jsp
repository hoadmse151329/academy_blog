<%@page import="assignment.user.UserDTO"%>
<%--<%@page import="java.util.List"%>
<%@page import="assignment.shopping.BookDTO"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        %>
        <h1>Hello <%= user.getFullName()%></h1>
        <h1> Welcome To FPTU Blog!</h1>

        <a href="MainController?action=Logout">Logout</a>

</body>
</html>
