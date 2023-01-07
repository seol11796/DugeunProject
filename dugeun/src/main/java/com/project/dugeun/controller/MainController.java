package com.project.dugeun.controller;


import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value="/")
    public String main(){
        return "main";
    }
}
