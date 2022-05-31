package tr.edu.yildiz.ce.seuser.domain.dto;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;

public class RegisterControllerResponse {
    private ResponseHeader header;
    private String tenantId;

    public RegisterControllerResponse(ResponseHeader header, String tenantId) {
        this.header = header;
        this.tenantId = tenantId;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
