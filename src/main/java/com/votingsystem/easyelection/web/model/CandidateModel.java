package com.votingsystem.easyelection.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CandidateModel extends AbstractModel{

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private double age;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private byte[] image;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String description;

    public CandidateModel() {
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
