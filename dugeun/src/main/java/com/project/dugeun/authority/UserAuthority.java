package com.project.dugeun.authority;

public enum UserAuthority {
    USER("USER"), ADMIN("ADMIN");

    private String name;

    private UserAuthority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}