package tr.edu.yildiz.ce.seuser.domain.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

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
    @OneToOne
    private User tenant;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    public Profile() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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
