package com.votingsystem.easyelection.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class VoterModel extends AbstractModel {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private byte[] image;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String voterCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String voterPassword;

    public VoterModel() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getVoterCode() {
        return voterCode;
    }

    public void setVoterCode(String voterCode) {
        this.voterCode = voterCode;
    }

    public String getVoterPassword() {
        return voterPassword;
    }

    public void setVoterPassword(String voterPassword) {
        this.voterPassword = voterPassword;
    }
}
