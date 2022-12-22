package com.project.dugeun.repository;

import com.project.dugeun.entity.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>,
        QuerydslPredicateExecutor<User> {

    // itemNm
    List<User> findByUserName(String userName);

    List<User> findByUserNameOrDescription(String userName,String description);

    List<User> findByAgeLessThan(Integer age);

    @Query("select i from User i where i.description like %:description% order by i.age desc")
    List<User> findByDescription(@Param("description")String description);

}
