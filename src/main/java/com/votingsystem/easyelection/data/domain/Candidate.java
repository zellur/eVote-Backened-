package com.votingsystem.easyelection.data.domain;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate extends AuditableEntity {

    @Column(name = "name", length= 100)
    private String name;

    @Column(name = "age", length = 10)
    private double age;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "description")
    @Lob
    private String description;

    @ManyToOne
    private Election election;

    public Candidate() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
