package tr.edu.yildiz.ce.seuser.domain.dto;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;

public class RegisterControllerResponse {
    private ResponseHeader responseHeader;
    private String tenantId;

    public RegisterControllerResponse(ResponseHeader responseHeader, String tenantId) {
        this.responseHeader = responseHeader;
        this.tenantId = tenantId;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
