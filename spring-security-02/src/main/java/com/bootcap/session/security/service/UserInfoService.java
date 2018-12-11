package com.bootcap.session.security.service;

import com.bootcap.session.security.constant.RolesContant;
import com.bootcap.session.security.entity.UserInfo;
import com.bootcap.session.security.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * service访问层
 * Created by jack.
 * 2018-12-10 16:37
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    public boolean insert(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoMapper.selectByUserName(userInfo.getUserName());
        if (userInfo1 != null){
            return false;
        }
        userInfo.setRoles(RolesContant.USER);
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        int result = userInfoMapper.insert(userInfo);
        return result == 1;
    }

    /**
     * 查询用户
     * @param username
     * @return
     */
    public UserInfo selectUserInfo(String username) {
        return userInfoMapper.selectByUserName(username);
    }

}
