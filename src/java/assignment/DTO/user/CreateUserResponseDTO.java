package assignment.DTO.user;

public class CreateUserResponseDTO {

    private String userIDError;
    private String fullNameError;
    private String passwordError;
    private String confirmError;
    private String phoneError;
    private String roleIDError;
    private String messageError;
    private String messageSuccess;

    public CreateUserResponseDTO() {
        this.userIDError = "";
        this.fullNameError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.phoneError = "";
        this.roleIDError = "";
        this.messageError = "";
        this.messageSuccess = "";
    }

    public CreateUserResponseDTO(String userIDError, String fullNameError,
            String passwordError, String confirmError, String phoneError,
            String roleIDError, String messageError, String messageSuccess) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.phoneError = phoneError;
        this.roleIDError = roleIDError;
        this.messageError = messageError;
        this.messageSuccess = messageSuccess;
        
    }



    public String getMessageSuccess() {
        return messageSuccess;
    }

    public void setMessageSuccess(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }
    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

}
