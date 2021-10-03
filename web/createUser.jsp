<%@page import="assignment.user.UserDTO"%>
<%@page import="assignment.user.CreateUserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create new user!</h1>
        <%
            CreateUserErrorDTO userError = (CreateUserErrorDTO) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new CreateUserErrorDTO();
            }
        %>
        <form action="MainController" method="POST">
            User ID<input type="text" name="id" required=""/>
            <%= userError.getUserIDEror()%></br>
            Password<input type="password" name="password" required=""/></br>
            Confirm<input type="password" name="confirm" required=""/>
            <%= userError.getConfirmError()%></br>
            Full Name<input type="text" name="fullName" required=""/>
            <%= userError.getFullNameError()%></br>
            Email<input type="text" name="email" required=""/></br>
            Avatar<input type="text" name="avatar" required=""/>
            <%= userError.getPhoneError()%></br>
            

            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
            <%= userError.getMessageError()%></br>
        </form>
        <a href="login.html">Go back to login page</a>
    </body>
</html>
