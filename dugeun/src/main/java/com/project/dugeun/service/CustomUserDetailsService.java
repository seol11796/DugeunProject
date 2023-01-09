//package com.project.dugeun.service;
//
//import com.project.dugeun.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Slf4j
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public User loadUserByUsername(String name) throws UsernameNotFoundException {
//        Optional<User> optionalUser = UserService.findByUserId(name);
//        if (optionalUser.isEmpty()) {
//            throw new UsernameNotFoundException("Username [" + name + "] not found.");
//        }
//
//        return optionalUser.get();
//    }
//}