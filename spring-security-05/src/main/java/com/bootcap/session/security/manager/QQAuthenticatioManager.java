package com.bootcap.session.security.manager;

import com.bootcap.session.security.entity.QQUserInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理授权类
 * @author jack
 * 2018-12-18 14:47
 */
public class QQAuthenticatioManager implements AuthenticationManager {

    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    public QQAuthenticatioManager(){}

    /**
     * 获取用户信息
     */
    private final static String USER_INFO_URL = "https://graph.qq.com/user/get_user_info?access_token=%s&oauth_consumer_key=%s&openid=%s";

    /**
     * client_id 由腾讯提供(即AppId)
     */
    static final String CLIENT_ID = "101364240";

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        QQUserInfo qqUserInfo = null;
        if (authentication.getName() != null && authentication.getCredentials() != null){
            qqUserInfo = getUserInfo(authentication.getName(), (String) authentication.getCredentials());
        }
//        System.out.println("输出用户信息：" +qqUserInfo.toString());
        return new UsernamePasswordAuthenticationToken(qqUserInfo,null,AUTHORITIES);
    }

    /**
     * 获取QQ授权后的基本信息
     * @param accessToken
     * @param openId
     * @return
     */
    private QQUserInfo getUserInfo(String accessToken, String openId) {
        String url = String.format(USER_INFO_URL,accessToken,CLIENT_ID,openId);
        RestTemplate template = new RestTemplate();
        String userInfoResult = template.getForObject(url, String.class);
        QQUserInfo qqUserInfo = jsonToObject(userInfoResult, QQUserInfo.class);
        return qqUserInfo;
    }

    private <T> T jsonToObject(String json,Class<T> targetClass){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(json,targetClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
