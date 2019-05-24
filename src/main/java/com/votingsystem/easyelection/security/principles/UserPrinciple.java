package com.votingsystem.easyelection.security.principles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {


    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    private String city;

    private String country;

    private String mobile;

    private String email;

    private String imageUrl;

    @JsonIgnore
    private String passwords;

    @JsonIgnore
    private Collection<? extends GrantedAuthority> authoritiesg;


    public UserPrinciple(UserModel model, Collection<? extends GrantedAuthority> authorities) {
        this.setId(model.getId());
        this.setFirstName(model.getFirstName());
        this.setLastName(model.getLastName());
        this.setEmail(model.getEmail());
        this.setMobile(model.getMobile());
        this.setAddress(model.getAddress());
        this.setCity(model.getCity());
        this.setCountry(model.getCountry());
        this.setPasswords(model.getPassword());
        this.setGender(model.getGender());
        this.setAuthoritiesg(authorities);
    }

    public static UserPrinciple create(UserModel user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
        return new UserPrinciple(user,authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritiesg;
    }

    @Override
    public String getPassword() {
        return passwords;
    }

    @Override
    public String getUsername() {
        String userName = this.getEmail().isEmpty()? this.getMobile(): this.getEmail();
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrinciple that = (UserPrinciple) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesg() {
        return authoritiesg;
    }

    public void setAuthoritiesg(Collection<? extends GrantedAuthority> authoritiesg) {
        this.authoritiesg = authoritiesg;
    }
}
