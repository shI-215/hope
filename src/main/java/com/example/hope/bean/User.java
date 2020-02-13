package com.example.hope.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String userPicture;
    private String userName;
    private String userTel;
    private String userPwd;
    private String userAddress;
    private String userSex;
    private String userBirthday;
    private String userAutograph;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPicture='" + userPicture + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userAutograph='" + userAutograph + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAutograph() {
        return userAutograph;
    }

    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph;
    }
}
