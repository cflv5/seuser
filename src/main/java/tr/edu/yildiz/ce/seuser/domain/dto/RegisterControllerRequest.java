package tr.edu.yildiz.ce.seuser.domain.dto;

import javax.validation.Valid;

import tr.edu.yildiz.ce.se.base.domain.RequestHeader;

public class RegisterControllerRequest {
    private RequestHeader header;

    @Valid
    private UserRegistrationDto user;

    public RegisterControllerRequest() {
        super();
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public UserRegistrationDto getUser() {
        return user;
    }

    public void setUser(UserRegistrationDto user) {
        this.user = user;
    }

}
