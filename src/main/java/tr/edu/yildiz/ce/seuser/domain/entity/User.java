package tr.edu.yildiz.ce.seuser.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import tr.edu.yildiz.ce.seuser.domain.dto.UserRegistrationDto;
import tr.edu.yildiz.ce.seuser.validation.Validatable;

@Entity(name = "TENANT")
public class User implements Serializable, Validatable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private String email;
    @Column
    private String password;
    @OneToOne
    private Profile profile;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean validate() {
        return true;
    }

    public static User of(UserRegistrationDto userDto) {
        var user = new User();
        
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

}
