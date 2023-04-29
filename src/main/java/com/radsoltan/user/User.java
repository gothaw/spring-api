package com.radsoltan.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.radsoltan.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOM_USER")
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String firstName;
    private String lastName;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    protected User() {
        super();
    }

    public User(String username, String firstName, String lastName, String password, String[] roles) {
        this();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = username;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }
}
