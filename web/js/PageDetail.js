$(document).ready(function () {
    var guestContent = document.getElementById("guestContent");
    var userContent = document.getElementById("userContent");
    var blog = JSON.parse(window.sessionStorage.getItem("blog"));
    var blogAuthor = document.getElementById("blogAuthor");
    var blogTitle = document.getElementById("blogTitle");
    var blogContent = document.getElementById("blogContent");
    var blogDate = document.getElementById("blogDate");
    var commentContent = document.getElementById("commentContent");
    blogAuthor.innerHTML = blog.authorId;
    blogTitle.innerHTML = blog.title;
    blogContent.innerHTML = blog.fullContent;
    blogDate.innerHTML += blog.createdDate;
    $.ajax({
        url: "GetCommentController",
        type: "POST",
        data: {blogId: blog.blogId},
        success: function (result) {
            var returnedData = JSON.parse(result);
            if (returnedData && returnedData.length > 0) {
                for (i = 0; i < returnedData.length; i++) {
                    var comment = document.createElement("div");
                    comment.className = 'tt-single-topic';
                    comment.innerHTML = "<div class='tt-item-header pt-noborder'> <div class='tt-item-info info-top'> <div class='tt-avatar-icon'> <i class='tt-icon' ><svg><use xlink:href='#icon-ava-t'></use></svg ></i> </div> <div class='tt-avatar-title'> <a href='#'>" + returnedData[i].authorId + "</a> </div> <a href='#' class='tt-info-time'> <i class='tt-icon' ><svg><use xlink:href='#icon-time'></use></svg></i > " + returnedData[i].createdDate + "</a> </div> </div> <div class='tt-item-description'>" + returnedData[i].content + "</div>";
                    commentContent.append(comment);
                }
            }
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        }
    });
    $.ajax({
        url: "SessionController",
        type: "GET",
        async: false,
        success: function (result) {
            guestContent.style.display = "none";
            userContent.style.display = "flex";
            userName.innerHTML = result;
            userId = result;
        },
        error: function (xhr) {
            guestContent.style.display = "flex";
            userContent.style.display = "none";
        }
    });
    $("#submitButton").click(function (e) {
        e.preventDefault();
        var content = $('#commentData').val();
        $.ajax({
            url: "CreateCommentController",
            type: "POST",
            data: {blogId: blog.blogId,
                content},
            success: function (resultText) {
                window.location.href = "./page-single-topic.html";
            },
            error: function (xhr) {
                alert("FAIL: " + xhr.responseText);
            },
        });
    });
});

