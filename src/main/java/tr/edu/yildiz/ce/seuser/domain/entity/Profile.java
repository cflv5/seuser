package tr.edu.yildiz.ce.seuser.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tr.edu.yildiz.ce.seuser.domain.dto.UserRegistrationDto;
import tr.edu.yildiz.ce.seuser.validation.Validatable;

@Entity
public class Profile implements Serializable, Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private String middlename;
    @Column
    private String surname;
    @Column
    private String title;

    public Profile() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(final String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public boolean validate() {
        return false;
    }

    public static Profile of(UserRegistrationDto userDto) {
        var profile = new Profile();
        profile.setName(userDto.getName());
        profile.setSurname(userDto.getSurname());
        profile.setMiddlename(userDto.getMiddlename());
        profile.setTitle(userDto.getTitle());
        return profile;
    }

}
