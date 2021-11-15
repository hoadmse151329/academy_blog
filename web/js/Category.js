$(document).ready(function () {
    var blogContent = document.getElementById("blogContent");
    var param = new URLSearchParams(window.location.search);
    $.ajax({
        url: "GetCategoryBlogController",
        data: {category: param.get("category")},
        type: "GET",
        success: function (result) {
            var returnedData = JSON.parse(result);
            if (returnedData && returnedData.length > 0) {
                for (i = 0; i < returnedData.length; i++) {
                    var blog = document.createElement("div");
                    blog.className = 'content-box';
                    blog.innerHTML = "<div class='avatar-box'> <div class='avatar-pic'> <a href='page-single-user.html' ><img src='images/single-topic-img01.jpg' alt='' /></a> </div> <div class='avatar-name'> <div class='name'> <a href='page-single-user.html'>" + returnedData[i].authorId + "</a> </div> <div class='date-up'><span>" + returnedData[i].createdDate + "</span></div> </div> </div> <div class='title-box'><a href='#' class='detail-link'><h2>" + returnedData[i].title + "</h2></a><ul id='tagList'></ul> <span>Comment:0</span> </div>";
                    var detailLink = blog.querySelector('.detail-link');
                    $(detailLink).click(returnedData[i], detailPage);
                    var tagList = blog.querySelector('#tagList');
                    returnedData[i].tags.forEach(tag => tagList.innerHTML += "<li><a href='#'>" + tag + "</a></li>");
                    blogContent.append(blog);
                }
            }
        },
        error: function (xhr) {

        }
    });
    $.ajax({
        url: "SessionController",
        type: "GET",
        async: false,
        success: function (result) {
            guestContent.style.display = "none";
            userContent.style.display = "flex";
            profileContent.style.display = "list-item";
            userName.innerHTML = result;
            userId = result;
        },
        error: function (xhr) {
            guestContent.style.display = "flex";
            userContent.style.display = "none";
            profileContent.style.display = "none";
        }
    });
});

function detailPage(detail) {
    window.sessionStorage.setItem("blog", JSON.stringify(detail.data));
    window.location.href = "./page-single-topic.html";
    return false;
    }