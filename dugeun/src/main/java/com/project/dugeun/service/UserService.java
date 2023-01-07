package com.project.dugeun.service;

import com.project.dugeun.entity.User;
import com.project.dugeun.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Getter
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public User saveUser(User user) {
//        validateDuplicateUser(user);
        return userRepository.save(user);
    }

//    private void validateDuplicateUser(User user){
//        User findUser = userRepository.findByKakaoId(user.getKakaoId());
//        if(findUser != null){
//            throw new IllegalStateException("이미 가입된 회원입니다.");
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findById()
//        Optional<User> adminUser = userRepository.findUserByName(name);
//
//        if (adminUser.isPresent()) {
//            User admin = adminUser.get();
//            User authAdmin = User.builder()
////                    .id(admin.getId())
//                    .name(admin.getName())
//                    .password(admin.getPassword())
////                    .role(admin.getRole())
//                    .build();
//
//            log.info("authAdmin : {} ", authAdmin);
//            return authAdmin;
//        }
//        return null;
    }
}