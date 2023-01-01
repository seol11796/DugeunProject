package com.project.dugeun.config;

import com.project.dugeun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return new org
                .springframework
                .security
                .core
                .userdetails
                .User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
