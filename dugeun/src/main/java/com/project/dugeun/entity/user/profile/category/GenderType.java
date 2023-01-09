package com.project.dugeun.entity.user.profile.category;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum GenderType {
    MAN("남자"),
    WOMAN("여자");

    private static final Map<String, GenderType> stringToEnum =
            Stream.of(values()).collect(toMap(Objects::toString, e -> e));

    private String description;

    GenderType(String description) {
        this.description = description;
    }

    @JsonCreator
    public static GenderType fromText(String text){
        return stringToEnum.get(text);
    }


}
