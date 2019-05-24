package com.votingsystem.easyelection.data.enums;

public enum RoleNameEnum {
    USER("ROLE_USER","User"),
    ADMIN("ROLE_ADMIN","Admin");

    private String name;
    private String code;

    private RoleNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
