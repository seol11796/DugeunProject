package com.project.dugeun.entity;


import com.project.dugeun.entity.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "blind_date")
@Getter @Setter
@ToString
public class BlindDate {

    @Id
    @Column(name = "blind_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "introducedDate")
    private Date introducedDate;

    @Column(name = "another_user_id")
    private Long another_user_id;

    @Column(name="user_score")
    private Long user_score;

    @Column(name = "another_user_score")
    private Long another_user_score;



}
