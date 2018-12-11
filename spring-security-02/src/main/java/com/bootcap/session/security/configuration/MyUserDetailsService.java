package com.bootcap.session.security.configuration;

import com.bootcap.session.security.service.UserInfoService;
import com.bootcap.session.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义登录校验Service
 * Created by jack.
 * 2018-12-10 17:23
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.selectUserInfo(userName);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在"); // 若不存在抛出用户不存在异常
        }
        // 权限字符串转化
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        String[] roles = userInfo.getRoles().split(",");// 获取后的Roles必须有ROLE_前缀，否则会抛Access is denied无权限异常
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        // 交给security进行验证并返回
        return new User(userInfo.getUserName(), userInfo.getPassword(), simpleGrantedAuthorities);
    }
}
