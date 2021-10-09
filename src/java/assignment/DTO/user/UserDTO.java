package assignment.DTO.user;

public class UserDTO {

    private String userID;
    private String password;
    private String fullName;
    private String email;
    private String avatar;
    private String createdDate;
    private boolean isActive;
    private String role;
    private String gender;
    private String studentClass;
    private String profile;
    private int postCount;
    private int followerCount;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullName, String email, String avatar, String createdDate, boolean isActive, String role, String gender, String studentClass, String profile, int postCount, int followerCount) {
        this.userID = userID;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.createdDate = createdDate;
        this.isActive = isActive;
        this.role = role;
        this.gender = gender;
        this.studentClass = studentClass;
        this.profile = profile;
        this.postCount = postCount;
        this.followerCount = followerCount;
    }

    public UserDTO(String userID, String password, String fullName, String email, String avatar, String createdDate, boolean isActive) {
        this.userID = userID;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }
    
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }


}
