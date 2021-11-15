$(document).ready(function () {
    var blogContent = document.getElementById("blogContent");
    var authorId = document.getElementById("authorId");
    $.ajax({
        url: "GetUserBlogController",
        type: "GET",
        success: function (result) {
            var returnedData = JSON.parse(result);
            if (returnedData && returnedData.length > 0) {
                for (i = 0; i < returnedData.length; i++) {
                    var blog = document.createElement("div");
                    blog.className = 'content-box';
                    blog.innerHTML = "<div class='avatar-box'> <div class='avatar-pic'> <a href='page-single-user.html' ><img src='images/single-topic-img01.jpg' alt='' /></a> </div> <div class='avatar-name'> <div class='name'> <a href='page-single-user.html'>" + returnedData[i].authorId + "</a> </div> <div class='date-up'><span>" + returnedData[i].createdDate + "</span></div> </div> </div> <div class='title-box'><a href='#' class='detail-link'><h2>" + returnedData[i].title + "</h2></a><ul id='tagList'></ul> <span>Comment:0</span><br></br><button type='submit' class='btn-edit-del'><img src='images/pencil-1466_96e96df4-f387-42f9-b404-031c18f324b8.png' alt=''></button> <button type='submit' class='btn-edit-del delete'><img src='images/shopping-basket-2200_9917ac3f-3ab2-41a0-87fa-99d6c6d5fddb.png' alt=''></button></div>";
                    var detailLink = blog.querySelector('.detail-link');
                    $(detailLink).click(returnedData[i], detailPage);
                    authorId.innerHTML = returnedData[i].authorId;
                    var deleteButton = blog.querySelectorAll('.btn-edit-del.delete');
                    $(deleteButton).click(returnedData[i], deleteBlog);
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

function deleteBlog(detail) {
    var id = detail.data.blogId;
    $.ajax({
        url: "DeleteBlogController",
        type: "POST",
        data: {id},
        success: function (resultText) {
            alert(resultText);
            window.location.href = "./page-profile-user.html";
        },
        error: function (xhr) {
            alert("FAIL: " + xhr.responseText);
        },
    });
    return false;
}
