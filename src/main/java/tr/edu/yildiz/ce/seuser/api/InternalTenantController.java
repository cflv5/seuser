package tr.edu.yildiz.ce.seuser.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yildiz.ce.seuser.domain.response.FetchTenantControllerResponse;
import tr.edu.yildiz.ce.seuser.service.TenantControllerService;

@RestController
@RequestMapping("/v1/api/internal/users")
public class InternalTenantController {
    private final TenantControllerService tenantControllerService;

    public InternalTenantController(TenantControllerService tenantControllerService) {
        this.tenantControllerService = tenantControllerService;
    }

    @GetMapping(value = "/email/{id}")
    public ResponseEntity<FetchTenantControllerResponse> fetchTenant(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(tenantControllerService.fetchTenantByEmail(id));
    }

}
