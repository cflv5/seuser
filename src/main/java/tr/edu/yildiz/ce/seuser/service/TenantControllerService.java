package tr.edu.yildiz.ce.seuser.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.se.base.exception.SeBaseException;
import tr.edu.yildiz.ce.seuser.domain.response.FetchTenantControllerResponse;
import tr.edu.yildiz.ce.seuser.service.repository.UserRepositoryService;

@Service
public class TenantControllerService {
    private final UserRepositoryService userRepositoryService;

    public TenantControllerService(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    public FetchTenantControllerResponse fetchTenant(String id) {
        var user = userRepositoryService.findUser(id);
        return new FetchTenantControllerResponse(ResponseHeader.success(), user.toTenantUser());
    }

    public FetchTenantControllerResponse fetchTenantByEmail(String email) {
        var user = userRepositoryService.getUserByUsername(email)
                .orElseThrow(() -> new SeBaseException("User not found", HttpStatus.OK));
        return new FetchTenantControllerResponse(ResponseHeader.success(), user.toTenantUser());
    }

}
