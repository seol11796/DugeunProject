package com.project.dugeun.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="IDEAL_TYPE_INFO")
public class IdealTypeInfo {

    @Id
    @Column(name="ideal_type_info_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idealTypeInfoId; // 이상형정보 코드

    @OneToOne
    @JoinColumn(name="used_id")
    private User user;


}
