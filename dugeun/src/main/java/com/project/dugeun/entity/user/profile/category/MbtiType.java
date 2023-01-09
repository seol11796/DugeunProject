package com.project.dugeun.entity.user.profile.category;


import lombok.Getter;
import org.hibernate.hql.internal.ast.tree.EntityJoinFromElement;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
@Getter
public enum MbtiType {
    INTP(0,"INTP"),
    ISTP(1,"ISTP"),
    INTJ(2,"INTJ"),
    ISTJ(3,"ISTJ"),
    INFJ(4,"INFJ"),
    ISFJ(5,"ISFJ"),
    ISFP(6,"ISFP"),
    INFP(7,"INFP"),
    ENFJ(8,"ENFJ"),
    ENTJ(9,"ENTJ"),
    ESFJ(10,"ESFJ"),
    ESTP(11,"ESTP");

    private static final Map<String, MbtiType> stringToEnum =
            Stream.of(values()).collect(toMap(Objects::toString, e -> e));



    private int code;
    private String description;

    MbtiType(int code, String description){
        this.code = code;
        this.description = description;
    }

}
