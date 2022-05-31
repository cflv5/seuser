package tr.edu.yildiz.ce.seuser.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import tr.edu.yildiz.ce.se.base.domain.RequestHeader;

public class LoginControllerRequest {
    @NotNull
    private RequestHeader header;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginControllerRequest() {
        super();
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
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
