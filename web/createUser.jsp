<%@page import="assignment.DTO.user.UserDTO"%>
<%@page import="assignment.DTO.user.CreateUserResponseDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Main CSS Stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- All CSS Plugins -->
        <link rel="stylesheet" type="text/css" href="css/plugin.css">
    </head>
    <body>
        <div class="row bg-color-1"> 
            <div class="col">                    
                <div class="header-container">
                    <h1>
                        FPTB - FPT University Blog
                    </h1>
                </div>
            </div>
        </div>
        <div class="body-container">
            <div class="row justify-content-center">
                <div class="col"> 
                    <div class="form-container">
                        <%
                            CreateUserResponseDTO userResponse = (CreateUserResponseDTO) request.getAttribute("USER_RESPONSE");
                            if (userResponse == null) {
                                userResponse = new CreateUserResponseDTO();
                            }
                        %>
                        <form action="MainController" method="POST">
                            User ID<input class="form-control" type="text" name="id" required=""/>
                            <%= userResponse.getUserIDError()%></br>
                            Password<input class="form-control" type="password" name="password" required=""/></br>
                            Confirm<input class="form-control" type="password" name="confirm" required=""/>
                            <%= userResponse.getConfirmError()%></br>
                            Full Name<input class="form-control" type="text" name="fullName" required=""/>
                            <%= userResponse.getFullNameError()%></br>
                             Address<input class="form-control" type="text" name="address" required=""/></br>
                             Phone<input class="form-control" type="text" name="phone" required=""/>
                             <%= userResponse.getPhoneError()%></br>
                            Email<input class="form-control" type="text" name="email" required=""/></br>
                            Avatar<input class="form-control" type="text" name="avatar" required=""/>
                            <%= userResponse.getPhoneError()%></br>
                            <input class="btn btn-primary" type="submit" name="action" value="Create"/>
                            <input class="btn btn-secondary" type="reset" value="Reset"/>
                            <%= userResponse.getMessageError()%></br>   
                        </form>
                       <a class="btn btn-link">Go back to login page</a>  
                    </div>
                </div>
            </div>
        </div>
        <div class="logo-footer bg-color-2">
            <img class="footer-logo" src="images/fpt_logo/fpt_logo.jpg">
        </div>
    </body>
</html>