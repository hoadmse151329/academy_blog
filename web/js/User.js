$(document).ready(function () {
    var blogContent = document.getElementById("tt-tab-01");
    var userId = document.getElementById("userId");
    var authorId = document.getElementById("authorId");
    var param = new URLSearchParams(window.location.search);
    userId.innerHTML = param.get("user");
    authorId.innerHTML = param.get("user");
    $.ajax({
        url: "GetUserBlogController",
        type: "GET",
        data: {user: param.get("user")},
        success: function (result) {
            var returnedData = JSON.parse(result);
            if (returnedData && returnedData.length > 0) {
                for (i = 0; i < returnedData.length; i++) {
                    var blog = document.createElement("div");
                    blog.className = 'content-box';
                    blog.innerHTML = "<div class='avatar-box'> <div class='avatar-pic'> <a href='page-single-user.html' ><img src='images/single-topic-img01.jpg' alt='' /></a> </div> <div class='avatar-name'> <div class='name'> <a href='page-single-user.html'>" + returnedData[i].authorId + "</a> </div> <div class='date-up'><span>" + returnedData[i].createdDate + "</span></div> </div> </div> <div class='title-box'><a href='#' class='detail-link'><h2>" + returnedData[i].title + "</h2></a><ul id='tagList'></ul> <span>Comment:0</span></div>";
                    var detailLink = blog.querySelector('.detail-link');
                    $(detailLink).click(returnedData[i], detailPage);
                    var tagList = blog.querySelector('#tagList');
                    returnedData[i].tags.forEach(tag => tagList.innerHTML += "<li><a href='#'>" + tag + "</a></li>");
                    blogContent.append(blog);
                }
            }
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        }
    });
});

function detailPage(detail) {
    window.sessionStorage.setItem("blog", JSON.stringify(detail.data));
    window.location.href = "./page-single-topic.html";
    return false;
}
