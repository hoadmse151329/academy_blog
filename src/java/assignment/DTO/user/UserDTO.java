package assignment.DTO.user;

public class UserDTO {
    
    public UserDTO(){}

    public UserDTO(String userID, String password, String email, String fullName, String avatar, Integer postCount, String createdDate, String role, String userStatus, String banReason) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.avatar = avatar;
        this.postCount = postCount;
        this.createdDate = createdDate;
        this.role = role;
        this.userStatus = userStatus;
        this.banReason = banReason;
    }

    private String userID;
    private String password;
    private String email;
    private String fullName;
    private String avatar;
    private Integer postCount;
    private String createdDate;
    private String role;
    private String userStatus;
    private String banReason;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

}