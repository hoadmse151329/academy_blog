$("form#signUpData").submit(function (e) {
    e.preventDefault();
    var userID = $('#loginUserName').val();
    var password = $('#loginUserPassword').val();
    var email = $('#loginUserEmail').val();
    $.ajax({
        url: "CreateUserController",
        type: "POST",
        data: {userID,
            password,
            email},
        success: function (resultText) {
            alert(resultText);
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

