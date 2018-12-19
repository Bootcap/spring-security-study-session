package com.bootcap.session.security.entity;

/**
 * qq信息实体
 * @author jack
 * 2018-12-18 15:34
 */
public class QQUserInfo {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String gender;

    /**
     * QQ头像
     */
    private String figureurl_qq_1;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    @Override
    public String toString() {
        return "QQUserInfo{" +
                "nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", figureurl_qq_1='" + figureurl_qq_1 + '\'' +
                '}';
    }
}
