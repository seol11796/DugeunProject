package com.project.dugeun.controller;


import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.entity.User;
import com.project.dugeun.repository.UserRepository;
import com.project.dugeun.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @GetMapping(value="/new")
    public String userForm(Model model){
        model.addAttribute("userFormDto",new UserFormDto());

        return "user/userForm";
    }

    @PostMapping(value="/new")
    public String userForm(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model){
        log.info("user info={}", userFormDto.getUserId());
        if(bindingResult.hasErrors()){
            return "user/userForm";
        }
        try{
            User user = User.createUser(userFormDto, passwordEncoder);
            userService.saveUser(user);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "user/userForm";
        }
        return "redirect:/";
    }

    @GetMapping(value="/login")
    public String loginForm(Model model) {
        model.addAttribute("userFormDto",new UserFormDto());
        return "login/loginForm";
    }



    @PostMapping(value="/login")
    public String login() {
        return "redirect:/";
    }
}
