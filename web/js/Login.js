$(document).ready(function () {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');
    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });
    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
});
$("form#signUpData").submit(function (e) {
    e.preventDefault();
    var userID = $('#userID').val();
    var password = $('#password').val();
    var fullName = $('#fullName').val();
    var confirm = $('#confirm').val();
    var email = $('#email').val();
    $.ajax({
        url: "CreateUserController",
        type: "POST",
        data: {userID,
            password,
            fullName,
            confirm,
            email},
        success: function (resultText) {
            alert(resultText);
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

