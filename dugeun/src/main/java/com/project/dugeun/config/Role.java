package com.project.dugeun.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    SUPER("ROLE_SUPER, ROLE_GENERAL"),
    GENERAL("ROLE_GENERAL");

    private String value;
}
