package tr.edu.yildiz.ce.seuser.domain.dto;

import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;

public class ProfileControllerResponse {
    private ResponseHeader responseHeader;
    private UserProfileDto profile;

    public ProfileControllerResponse() {
        super();
    }

    public ProfileControllerResponse(ResponseHeader responseHeader, UserProfileDto profile) {
        this.responseHeader = responseHeader;
        this.profile = profile;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public UserProfileDto getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDto profile) {
        this.profile = profile;
    }

}
