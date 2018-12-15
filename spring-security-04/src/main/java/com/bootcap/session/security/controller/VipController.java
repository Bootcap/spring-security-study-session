package com.bootcap.session.security.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态权限修改Controller
 * @author jack
 * 2018-12-15 14:16
 */
@Controller
@ResponseBody
public class VipController {

    @RequestMapping(value = "/vip/index",method = RequestMethod.GET)
    public String vipPage(){
        return "只有VIP用户可观看";
    }

    @RequestMapping(value = "/getVIP",method = RequestMethod.GET)
    public String getVip(){
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> update = new ArrayList<>(authentication.getAuthorities());
        // 添加VIP授权
        update.add(new SimpleGrantedAuthority("ROLE_VIP"));
        // 生成新的认证信息
        Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), update);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        return "ok";
    }
}
