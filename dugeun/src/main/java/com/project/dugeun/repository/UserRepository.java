package com.project.dugeun.repository;

import com.project.dugeun.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByExternalId(String externalId);
    Optional<User> findByUserId(String userId);
}