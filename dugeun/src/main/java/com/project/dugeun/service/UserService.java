package com.project.dugeun.service;

import com.project.dugeun.entity.User;
import com.project.dugeun.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Getter
@Slf4j
public class UserService implements UserDetailsService {

    private static UserRepository userRepository;

    public User saveUser(User user) {
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        User findUser = userRepository.findByExternalId(user.getExternalId());
        if (findUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("[" + username + "] Username Not Found"));

        return User.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .build();
//        return userRepository.findByUserId(username)
//                .orElseThrow(() -> new UsernameNotFoundException("[" + username + "] Username Not Found"));
    }


//    private UserDetails toUserDetails(User user) {
//        return User.builder()
//                .user(user.getId())
//                .password(user.getPassword())
//                .build();
//    }
}
