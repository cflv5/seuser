package tr.edu.yildiz.ce.seuser.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
import tr.edu.yildiz.ce.se.base.domain.OnlyHeaderControllerResponse;
import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.seuser.domain.dto.ProfileControllerResponse;
import tr.edu.yildiz.ce.seuser.domain.dto.UserProfileDto;
import tr.edu.yildiz.ce.seuser.service.repository.ProfileRepositoryService;

@Service
public class ProfileControllerService {
    private final ProfileRepositoryService profileRepositoryService;

    @Autowired
    public ProfileControllerService(ProfileRepositoryService profileRepositoryService) {
        this.profileRepositoryService = profileRepositoryService;
    }

    @Transactional
    public ProfileControllerResponse fetchTenantProfile() {
        var tenantId = TenantContext.getCurrentTenant();

        var userProfile = profileRepositoryService.fetchProfile(tenantId.getTenantId());

        return new ProfileControllerResponse(ResponseHeader.success(), UserProfileDto.of(userProfile));

    }

    public OnlyHeaderControllerResponse addProfilePicture(MultipartFile picture) throws IOException {
        var profile = profileRepositoryService.fetchOwnProfile();
        profile.setPicture(picture.getBytes());
        profileRepositoryService.saveProfile(profile);
        return OnlyHeaderControllerResponse.success();
    }

}
