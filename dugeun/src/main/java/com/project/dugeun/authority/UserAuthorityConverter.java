package com.project.dugeun.authority;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserAuthorityConverter implements AttributeConverter<UserAuthority, String> {
    @Override
    public String convertToDatabaseColumn(UserAuthority authority) {
        if (authority == null) {
            return null;
        }

        return authority.getName();
    }

    @Override
    public UserAuthority convertToEntityAttribute(String authority) {
        if (authority == null) {
            return null;
        }

        return Stream.of(UserAuthority.values())
                .filter(memberRole -> memberRole.getName().equals(authority))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}