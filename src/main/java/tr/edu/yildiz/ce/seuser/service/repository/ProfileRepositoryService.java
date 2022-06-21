package tr.edu.yildiz.ce.seuser.service.repository;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
import tr.edu.yildiz.ce.se.base.exception.SeBaseException;
import tr.edu.yildiz.ce.seuser.domain.dto.UserRegistrationDto;
import tr.edu.yildiz.ce.seuser.domain.entity.Profile;
import tr.edu.yildiz.ce.seuser.repository.ProfileRepository;

@Service
public class ProfileRepositoryService {
    private final ProfileRepository profileRepository;

    public ProfileRepositoryService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createAndSaveProfile(UserRegistrationDto user) {
        var profile = Profile.of(user);
        profileRepository.save(profile);
        return profile;
    }

    public Profile fetchProfile(String tenantId) {
        return profileRepository.getProfileByTenantId(tenantId)
                .orElseThrow(() -> new SeBaseException("Tenant could not be found", HttpStatus.OK));
    }

    public Profile saveProfile(Profile profile) {
        Objects.requireNonNull(profile, "Profile to be saved cannot be null.");
        return profileRepository.save(profile);
    }

    public Profile fetchOwnProfile() {
        return profileRepository.getProfileByTenantId(TenantContext.getCurrentTenant().getTenantId())
                .orElseThrow(() -> new SeBaseException("Profil not found", HttpStatus.NOT_FOUND));
    }
}
