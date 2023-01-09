//package com.project.dugeun.config;
//
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CustomLoginFailureHandler implements AuthenticationFailureHandler {
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        String errormsg = "";
//
//        if(exception instanceof LockedException) { //계정 잠금 여부
//            errormsg = "locked";
//        } else if(exception instanceof DisabledException) { //계정 활성화 여부
//            errormsg = "disabled";
//        } else if(exception instanceof AccountExpiredException) { //계정 기한 만료
//            errormsg = "accountExpired";
//        } else if(exception instanceof CredentialsExpiredException) { //비밀번호 기한 만료
//            errormsg = "credentialExpired";
//        } else if(exception instanceof BadCredentialsException){ // 비밀번호 입력 오류, ID 입력 오류
//
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("/login?error");
//
//        if(!errormsg.equals("")){
//            sb.append("=").append(errormsg);
//        }
//
//        response.sendRedirect(sb.toString());
//
//    }
//}