$("form#blogData").submit(function (e) {
    e.preventDefault();
    var title = $('#inputTopicTitle').val();
    var body = $('#inputTopicBody').val();
    var category = $('#inputCategory').val();
    var tag = $('#inputTag').val().split(' ').filter(x => x.toString().indexOf("#") === 0);
    $.ajax({
        url: "CreateBlogController",
        type: "POST",
        data: {title,
            body,
            category,
            tag: JSON.stringify(tag)},
        success: function (resultText) {
            alert(resultText);
            window.location.href = "./index.html";
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
});

