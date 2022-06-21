package tr.edu.yildiz.ce.seuser.api;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tr.edu.yildiz.ce.se.base.domain.OnlyHeaderControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.dto.ProfileControllerResponse;
import tr.edu.yildiz.ce.seuser.service.ProfileControllerService;

@RestController
@RequestMapping("/v1/api/users/profile")
public class ProfileController {

    private final ProfileControllerService profileControllerService;

    public ProfileController(ProfileControllerService profileControllerService) {
        this.profileControllerService = profileControllerService;
    }

    @GetMapping(value = "/me")
    public ResponseEntity<ProfileControllerResponse> userProfile() {
        return ResponseEntity.ok().body(profileControllerService.fetchTenantProfile());
    }

    @PostMapping(value = "/me/picture")
    public ResponseEntity<OnlyHeaderControllerResponse> addProfilePicture(
            @RequestParam("picture") MultipartFile picture) throws IOException {
        return ResponseEntity.ok().body(profileControllerService.addProfilePicture(picture));
    }
}
