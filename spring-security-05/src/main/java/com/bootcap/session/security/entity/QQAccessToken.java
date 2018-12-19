package com.bootcap.session.security.entity;

/**
 * @author jack
 * 2018-12-18 11:47
 */
public class QQAccessToken {

    /**
     * 授权accessToken
     */
    private String accessToken;

    /**
     * 该access token的有效期，单位为秒。
     */
    private Integer expiresIn;

    /**
     * 在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。
     */
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "QQAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
