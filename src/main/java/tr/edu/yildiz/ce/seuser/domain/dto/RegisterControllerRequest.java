package tr.edu.yildiz.ce.seuser.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegisterControllerRequest {
    @Valid
    @NotNull
    private UserRegistrationDto user;

    public RegisterControllerRequest() {
        super();
    }

    public UserRegistrationDto getUser() {
        return user;
    }

    public void setUser(UserRegistrationDto user) {
        this.user = user;
    }

}
