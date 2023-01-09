package com.project.dugeun.config;

import com.project.dugeun.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                    .antMatchers("/users/new").permitAll()
                    .antMatchers("/").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/users/login")
                    .usernameParameter("userId")
                    .passwordParameter("password")
//                    .loginProcessingUrl("/users/login")
    //                .defaultSuccessUrl("/")
    //                .failureHandler(failureHandler())
    //                .successHandler(successHandler())
                    .failureUrl("/access_denied")
                .and()
                    .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                    .logoutSuccessUrl("/users/login")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("SESSION", "JSESSIONID")
                .and()
                    .csrf().disable()
        ;

        http.sessionManagement()
                .invalidSessionUrl("/login?invalidSession")
//                .sessionAuthenticationErrorUrl("login?maxSessions")
                .maximumSessions(1) // 최대 허용 세션 수
                .maxSessionsPreventsLogin(false) // 중복 로그인하면 기존 세션 만료
                .expiredUrl("/login")
        ;

        http.authorizeRequests()
                .mvcMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .mvcMatchers("/", "/users/**").permitAll()
                .anyRequest().authenticated()
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SimpleUrlAuthenticationSuccessHandler successHandler(){
//        SimpleUrlAuthenticationSuccessHandler successHandler = new CustomLoginSuccessHandler();
//        successHandler.setDefaultTargetUrl("/");
//        return successHandler;
//    }
//
//    @Bean
//    public AuthenticationFailureHandler failureHandler(){
//        return new CustomLoginFailureHandler();
//    }
//
////    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//
////    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
}