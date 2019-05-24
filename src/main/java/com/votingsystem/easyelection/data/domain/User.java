package com.votingsystem.easyelection.data.domain;

import com.votingsystem.easyelection.web.model.UserModel;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "user")
public class User extends AuditableEntity {

    @Column(name = "first_name", length = 25)
    private String firstName;

    @Column(name = "last_name", length = 25)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "country", length = 36)
    private String country;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Election> elections;

    public User() {
        super();
    }

    public User(UserModel userModel) {
        super();
        this.setFirstName(userModel.getFirstName());
        this.setLastName(userModel.getLastName());
        this.setEmail(userModel.getEmail());
        this.setMobile(userModel.getMobile());
        this.setGender(userModel.getGender());
        this.setAddress(userModel.getAddress());
        this.setCity(userModel.getCity());
        this.setCountry(userModel.getCountry());
        this.setPassword(userModel.getPassword());
        this.setImage(userModel.getImage());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Election> getElections() {
        return elections;
    }

    public void setElections(Set<Election> elections) {
        this.elections = elections;
    }
}
