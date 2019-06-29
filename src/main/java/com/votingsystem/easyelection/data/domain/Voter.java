package com.votingsystem.easyelection.data.domain;

import javax.persistence.*;

@Entity
@Table(name = "voter")
public class Voter extends AuditableEntity{

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "phone", length = 20)
    private  String phone;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "voter_code", length = 10)
    private String voterCode;

    @Column(name = "voter_password", length = 10)
    private String voterPassword;

    @ManyToOne
    private Election election;

    public Voter() {
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
