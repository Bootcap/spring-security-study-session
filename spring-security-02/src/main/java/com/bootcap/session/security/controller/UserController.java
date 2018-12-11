package com.bootcap.session.security.controller;

import com.bootcap.session.security.service.UserInfoService;
import com.bootcap.session.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Created by jack.
 * 2018-12-10 17:02
 */
@Controller
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public String doRegister(UserInfo userInfo){
        boolean insert = userInfoService.insert(userInfo);
        if (insert){
            return "redirect:sign?success";
        }
        return "redirect:sign?error";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }
}
