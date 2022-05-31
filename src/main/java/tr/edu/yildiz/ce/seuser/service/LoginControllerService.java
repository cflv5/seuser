package tr.edu.yildiz.ce.seuser.service;

import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerRequest;
import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.entity.User;
import tr.edu.yildiz.ce.seuser.exception.AuthenticationException;
import tr.edu.yildiz.ce.seuser.service.repository.UserRepositoryService;

@Service
public class LoginControllerService {
    private final UserRepositoryService userRepositoryService;

    public LoginControllerService(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    public LoginControllerResponse authenticate(LoginControllerRequest request) {
        var username = request.getEmail();
        var password = request.getPassword();

        User user = userRepositoryService.getUserByUsername(username).orElseThrow(AuthenticationException::new);

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException();
        }

        return new LoginControllerResponse(ResponseHeader.success(), user.getId());
    }

}
