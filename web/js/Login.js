$("form#loginData").submit(function (e) {
    e.preventDefault();
    var userID = $('#loginUserName').val();
    var password = $('#loginUserPassword').val();
    $.ajax({
        url: "LoginController",
        type: "POST",
        data: {userID,
            password},
        success: function (result) {
            window.location.href = "./index.html";
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

