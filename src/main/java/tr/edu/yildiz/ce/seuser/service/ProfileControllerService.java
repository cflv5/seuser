package tr.edu.yildiz.ce.seuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
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

    public ProfileControllerResponse fetchTenantProfile() {
        var tenantId = TenantContext.getCurrentTenant();

        var userProfile = profileRepositoryService.fetchProfile(tenantId.getTenantId());

        return new ProfileControllerResponse(ResponseHeader.success(), UserProfileDto.of(userProfile));

    }

}
