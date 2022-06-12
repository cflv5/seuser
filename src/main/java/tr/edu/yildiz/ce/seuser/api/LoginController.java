package tr.edu.yildiz.ce.seuser.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerRequest;
import tr.edu.yildiz.ce.seuser.domain.dto.LoginControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.dto.RegisterControllerRequest;
import tr.edu.yildiz.ce.seuser.domain.dto.RegisterControllerResponse;
import tr.edu.yildiz.ce.seuser.service.LoginControllerService;

@RestController
@RequestMapping("/v1/api/users")
public class LoginController {
    private final LoginControllerService loginControllerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    public LoginController(LoginControllerService loginControllerService) {
        this.loginControllerService = loginControllerService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginControllerResponse> login(@RequestBody @Valid LoginControllerRequest request) {
        LoginControllerResponse response;
        try {
            response = loginControllerService.authenticate(request);
        } catch (Exception e) {
            LOGGER.error("Exception occured while authentication", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterControllerResponse> register(@RequestBody @Valid RegisterControllerRequest request) {
        RegisterControllerResponse response;
        try {
            response = loginControllerService.register(request);
        } catch (Exception e) {
            LOGGER.error("Exception occured while authentication", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(response);
    }

}
