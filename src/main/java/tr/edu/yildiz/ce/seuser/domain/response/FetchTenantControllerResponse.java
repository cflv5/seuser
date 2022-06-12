package tr.edu.yildiz.ce.seuser.domain.response;

import java.io.Serializable;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.se.base.domain.common.TenantUser;

public class FetchTenantControllerResponse implements Serializable {
    private ResponseHeader responseHeader;
    private TenantUser tenant;

    public FetchTenantControllerResponse(ResponseHeader responseHeader, TenantUser tenant) {
        this.responseHeader = responseHeader;
        this.tenant = tenant;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public TenantUser getTenant() {
        return tenant;
    }

    public void setTenant(TenantUser tenant) {
        this.tenant = tenant;
    }

}
