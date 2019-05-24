package com.votingsystem.easyelection.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.votingsystem.easyelection.data.domain.Role;
import com.votingsystem.easyelection.data.domain.User;

import java.util.Set;

public class UserModel extends AbstractModel {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String mobile;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private byte[] image;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String country;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String confirmPassword;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Role> roles;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<ElectionModel> election;

    public UserModel() {
        super();
    }

    public UserModel(User user) {
        super();
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setMobile(user.getMobile());
        this.setGender(user.getGender());
        this.setAddress(user.getAddress());
        this.setCity(user.getCity());
        this.setCountry(user.getCountry());
        this.setPassword(user.getPassword());
        this.setRoles(user.getRoles());
        this.setImage(user.getImage());
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<ElectionModel> getElection() {
        return election;
    }

    public void setElection(Set<ElectionModel> election) {
        this.election = election;
    }
}
