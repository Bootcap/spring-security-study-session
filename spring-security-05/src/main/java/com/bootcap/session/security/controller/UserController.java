package com.bootcap.session.security.controller;

import com.bootcap.session.security.entity.QQUserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UsernamePasswordAuthenticationToken userAuthentication, Model model){
        if (userAuthentication.getPrincipal() instanceof User){
            User user = (User) userAuthentication.getPrincipal();
            model.addAttribute("username",user.getUsername());
        }else{
            QQUserInfo user = (QQUserInfo) userAuthentication.getPrincipal();
            model.addAttribute("username", user.getNickname());
            model.addAttribute("avatar", user.getFigureurl_qq_1());
        }
        return "user/user";
    }
}
