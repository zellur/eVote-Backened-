package com.votingsystem.easyelection.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
