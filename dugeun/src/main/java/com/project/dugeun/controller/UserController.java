package com.project.dugeun.controller;


import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.entity.User;
import com.project.dugeun.repository.UserRepository;
import com.project.dugeun.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String userForm(UserFormDto userFormDto){
        User user = User.createUser(userFormDto, passwordEncoder);
        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping(value="/login")
    public String loginForm(Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "login/loginForm";
    }

//    @PostMapping(value="/login")
//    public String login(){
//        userService.loadUserByUsername(name);
//
//        return "login/admin";
//    }

//    @GetMapping("/user_access")
//    public String userAccess(Model model, Authentication authentication) {
//        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
//        UserFormDto user = (UserFormDto) authentication.getPrincipal();  //userDetail 객체를 가져옴
//        model.addAttribute("info",  user.getName()+ "님");      //유저 아이디
//        return "login/user_access";
//    }
//
//    @GetMapping("/access_denied")
//    public String accessDenied() {
//        return "login/access_denied";
//    }


//    @GetMapping(value="/login")
//    public String login() {
//        return "login/loginForm";
//    }
}
