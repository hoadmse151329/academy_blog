package assignment.DTO.blog;

import assignment.DTO.user.*;

public class CreateBlogResponseDTO {

    private boolean isSucceeded;
    private String responseMessage;

    public CreateBlogResponseDTO() {
    }

    public CreateBlogResponseDTO(boolean isSucceeded, String responseMessage) {
        this.isSucceeded = isSucceeded;
        this.responseMessage = responseMessage;
    }

    public boolean isIsSucceeded() {
        return isSucceeded;
    }

    public void setIsSucceeded(boolean isSucceeded) {
        this.isSucceeded = isSucceeded;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
