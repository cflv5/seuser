package tr.edu.yildiz.ce.seuser.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yildiz.ce.seuser.domain.dto.ProfileControllerResponse;
import tr.edu.yildiz.ce.seuser.service.ProfileControllerService;

@RestController
@RequestMapping("/v1/api/user")
public class ProfileController {

    private final ProfileControllerService profileControllerService;

    public ProfileController(ProfileControllerService profileControllerService) {
        this.profileControllerService = profileControllerService;
    }

    @GetMapping(value = "/me")
    public ResponseEntity<ProfileControllerResponse> userProfile() {
        return ResponseEntity.ok().body(profileControllerService.fetchTenantProfile());
    }

}
