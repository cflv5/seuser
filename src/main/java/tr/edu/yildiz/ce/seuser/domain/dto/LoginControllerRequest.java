package tr.edu.yildiz.ce.seuser.domain.dto;

import javax.validation.constraints.NotBlank;

public class LoginControllerRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginControllerRequest() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
