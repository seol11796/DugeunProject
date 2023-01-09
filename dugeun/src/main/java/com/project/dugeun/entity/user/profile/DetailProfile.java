package com.project.dugeun.entity.user.profile;

import com.project.dugeun.entity.user.profile.category.BodyType;
import com.project.dugeun.entity.user.profile.category.GenderType;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DetailProfile {

    // 성별
    @Enumerated(EnumType.STRING)
    private GenderType genderType;



    // 외모( 키, 체형, 옷입는 스타일)
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    private Integer height;



    // 성격



    // 거주지

}
