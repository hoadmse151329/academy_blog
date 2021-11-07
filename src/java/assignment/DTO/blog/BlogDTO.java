/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.DTO.blog;

import java.sql.Timestamp;

public class BlogDTO {

    public BlogDTO(Integer blogId, String title, String categoryId, String authorId, String fullContent, Integer votingStar, Double averageVote, Timestamp createdDate, String latestEditedContent, Timestamp latestEditedDate, Timestamp approvedDate, String blogStatusId, String denyReason) {
        this.blogId = blogId;
        this.title = title;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.fullContent = fullContent;
        this.votingStar = votingStar;
        this.averageVote = averageVote;
        this.createdDate = createdDate;
        this.latestEditedContent = latestEditedContent;
        this.latestEditedDate = latestEditedDate;
        this.approvedDate = approvedDate;
        this.blogStatusId = blogStatusId;
        this.denyReason = denyReason;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public Integer getVotingStar() {
        return votingStar;
    }

    public void setVotingStar(Integer votingStar) {
        this.votingStar = votingStar;
    }

    public Double getAverageVote() {
        return averageVote;
    }

    public void setAverageVote(Double averageVote) {
        this.averageVote = averageVote;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getLatestEditedContent() {
        return latestEditedContent;
    }

    public void setLatestEditedContent(String latestEditedContent) {
        this.latestEditedContent = latestEditedContent;
    }

    public Timestamp getLatestEditedDate() {
        return latestEditedDate;
    }

    public void setLatestEditedDate(Timestamp latestEditedDate) {
        this.latestEditedDate = latestEditedDate;
    }

    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getBlogStatusId() {
        return blogStatusId;
    }

    public void setBlogStatusId(String blogStatusId) {
        this.blogStatusId = blogStatusId;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }

    private Integer blogId;
    private String title;
    private String categoryId;
    private String authorId;
    private String fullContent;
    private Integer votingStar;
    private Double averageVote;
    private Timestamp createdDate;
    private String latestEditedContent;
    private Timestamp latestEditedDate;
    private Timestamp approvedDate;
    private String blogStatusId;
    private String denyReason;
}