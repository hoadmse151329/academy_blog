/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.DTO.blog;

public class BlogDTO {
    private String id;
    private boolean isDeleted;
    private String title;
    private String summary;
    private String blogContent;
    private String authorId;
    private String blogStatusId;
    private String createdDate;
    private String lastEditedDate;
    private String publicDate;    

    public BlogDTO() {
    }
    public BlogDTO(String id, 
            boolean isDeleted,
            String title,
            String summary,
            String blogContent,
            String authorId,
            String blogStatusId, String createdDate, String lastEditedDate, String publicDate) {
        this.id = id;
        this.isDeleted = isDeleted;
        this.title = title;
        this.summary = summary;
        this.blogContent = blogContent;
        this.authorId = authorId;
        this.blogStatusId = blogStatusId;
        this.createdDate = createdDate;
        this.lastEditedDate = lastEditedDate;
        this.publicDate = publicDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBlogStatusId() {
        return blogStatusId;
    }

    public void setBlogStatusId(String blogStatusId) {
        this.blogStatusId = blogStatusId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastEditedDate() {
        return lastEditedDate;
    }

    public void setLastEditedDate(String lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

}
