$(document).ready(function () {
    var guestContent = document.getElementById("guestContent");
    var userContent = document.getElementById("userContent");
    var blogContent = document.getElementById("blogContent");
    var userId = null;
    $.ajax({
        url: "SessionController",
        type: "GET",
        async: false,
        success: function (result) {
            guestContent.style.display = "none";
            userContent.style.display = "block";
            userId = result;
        },
        error: function (xhr) {
            guestContent.style.display = "block";
            userContent.style.display = "none";
        },
    });
    $.ajax({
        url: "GetBlogController",
        type: "GET",
        success: function (result) {
            var returnedData = JSON.parse(result);
            if (returnedData && returnedData.length > 0) {
                for (i = 0; i < returnedData.length; i++) {
                    var blog = document.createElement("div");
                    blog.className = 'tt-item';
                    blog.innerHTML = "<div class='tt-col-avatar'> <svg class='tt-icon'> <use xlink:href='#icon-ava-l'></use> </svg> </div> <div class='tt-col-description'> <h6 class='tt-title'> <a href='page-single-topic.html'>" + returnedData[i].title + "</a> </h6> <div class='row align-items-center no-gutters hide-desktope'> <div class='col-11'> <ul class='tt-list-badge'> <li class='show-mobile'> <a href='#' ><span class='tt-color02 tt-badge'>video</span></a > </li> </ul> </div> <div class='col-1 ml-auto show-mobile'> <div class='tt-value'>2h</div> </div> </div> </div> <div class='tt-col-category'> <span class='tt-color02 tt-badge'>" + (returnedData[i].categoryId === 'c1' ? 'horror' : '' )+ "</span> </div> <div class='tt-col-value hide-mobile'>0</div> <div class='tt-col-value tt-color-select hide-mobile'>0</div> <div class='tt-col-value hide-mobile'>0</div> <div class='tt-col-value hide-mobile'>2h</div>"
                    blogContent.append(blog);
                }
            }
        },
        error: function (xhr) {

        },
    });
});

