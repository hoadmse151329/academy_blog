/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.DTO.comment;

import java.sql.Timestamp;

/**
 *
 * @author admin
 */
public class CommentDTO {

    public CommentDTO(Integer commentId, Integer blogId, String authorId, Timestamp createdDate, String content) {
        this.commentId = commentId;
        this.blogId = blogId;
        this.authorId = authorId;
        this.createdDate = createdDate;
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    Integer commentId;
    Integer blogId;
    String authorId;
    Timestamp createdDate;
    String content;
}
