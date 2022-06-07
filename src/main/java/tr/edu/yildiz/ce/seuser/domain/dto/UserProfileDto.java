package tr.edu.yildiz.ce.seuser.domain.dto;

import tr.edu.yildiz.ce.seuser.domain.entity.Profile;

public class UserProfileDto {
    private String name;
    private String middlename;
    private String surname;
    private String title;

    public UserProfileDto() {
        super();
    }

    public static UserProfileDto of(Profile profile) {
        var dto = new UserProfileDto();
        dto.setName(profile.getName());
        dto.setMiddlename(profile.getMiddlename());
        dto.setSurname(profile.getSurname());
        dto.setTitle(profile.getTitle());
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
