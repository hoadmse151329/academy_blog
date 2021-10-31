$("form#blogData").submit(function (e) {
    e.preventDefault();
    var title = $('#inputTopicTitle').val();
    var body = $('#inputTopicBody').val();
    var category = $('#inputCategory').val();
    $.ajax({
        url: "CreateBlogController",
        type: "POST",
        data: {title,
            body,
            category},
        success: function (resultText) {
            alert(resultText);
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

