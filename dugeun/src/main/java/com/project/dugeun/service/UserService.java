package com.project.dugeun.service;

import com.project.dugeun.entity.user.User;
import com.project.dugeun.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

private final UserRepository userRepository;

public User saveUser(User user){
validateDuplicateUser(user);
return userRepository.save(user);
}

private void validateDuplicateUser(User user){
    User findUser = userRepository.findByExternalId(user.getExternalId());
    if(findUser != null){
        throw new IllegalStateException("이미 가입된 회원입니다 . ");
    }
}
}


