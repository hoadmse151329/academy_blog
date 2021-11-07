$(document).ready(function () {
    var blog = JSON.parse(window.sessionStorage.getItem("blog"));
    var blogAuthor = document.getElementById("blogAuthor");
    var blogTitle = document.getElementById("blogTitle");
    var blogContent = document.getElementById("blogContent");
    var blogDate = document.getElementById("blogDate");
    blogAuthor.innerHTML = blog.authorId;
    blogTitle.innerHTML = blog.title;
    blogContent.innerHTML = blog.fullContent;
    blogDate.innerHTML += blog.createdDate;
});

