package tr.edu.yildiz.ce.seuser.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.domain.HeaderMessage;
import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerRequest;
import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.dto.RegisterControllerRequest;
import tr.edu.yildiz.ce.seuser.domain.dto.RegisterControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.entity.User;
import tr.edu.yildiz.ce.seuser.exception.AuthenticationException;
import tr.edu.yildiz.ce.seuser.service.repository.ProfileRepositoryService;
import tr.edu.yildiz.ce.seuser.service.repository.UserRepositoryService;

@Service
public class LoginControllerService {
    private final UserRepositoryService userRepositoryService;
    private final ProfileRepositoryService profileRepositoryService;

    public LoginControllerService(UserRepositoryService userRepositoryService,
            ProfileRepositoryService profileRepositoryService) {
        this.userRepositoryService = userRepositoryService;
        this.profileRepositoryService = profileRepositoryService;
    }

    @Transactional
    public LoginControllerResponse authenticate(LoginControllerRequest request) {
        var username = request.getEmail();
        var password = request.getPassword();

        User user = userRepositoryService.getUserByUsername(username).orElseThrow(AuthenticationException::new);

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException();
        }

        return new LoginControllerResponse(ResponseHeader.success(), user.getId());
    }

    public RegisterControllerResponse register(RegisterControllerRequest request) {
        var email = request.getUser().getEmail();

        if (userRepositoryService.getUserByUsername(email).isPresent()) {
            return new RegisterControllerResponse(ResponseHeader.fail(
                    HeaderMessage.Builder
                            .create()
                            .code(302)
                            .text(String.format("User with email %s already exists", email))
                            .build()),
                    "");
        }

        var profile = profileRepositoryService.createAndSaveProfile(request.getUser());

        var user = User.of(request.getUser());
        user.setProfile(profile);
        user = userRepositoryService.saveUser(user);
        profile.setTenant(user);
        profileRepositoryService.saveProfile(profile);

        return new RegisterControllerResponse(ResponseHeader.success(), user.getId());
    }

}
