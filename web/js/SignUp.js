$("form#signUpData").submit(function (e) {
    e.preventDefault();
    var userID = $('#loginUserName').val();
    var fullName = $('#loginFullName').val();
    var password = $('#loginUserPassword').val();
    var email = $('#loginUserEmail').val();
    $.ajax({
        url: "CreateUserController",
        type: "POST",
        data: {userID,
            fullName,
            password,
            email},
        success: function (resultText) {
            window.location.href = "./page-login.html";
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

