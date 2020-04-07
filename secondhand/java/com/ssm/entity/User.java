package com.ssm.entity;

import java.util.Date;

public class User {
    private int userId;//用户编号
    private String phone;//手机号，用户登录
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String create_time;//用户注册时间
    private String last_login_time;//最近一次登录时间
    private int goods_num;//发布过的物品数量
    private int status;//账号状态
    private int credit_score;//用户的信用值初始为100
    private String email;//用户邮箱

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createTime=" + create_time +
                ", last_login_time=" + last_login_time +
                ", goods_num=" + goods_num +
                ", status=" + status +
                ", credit_score=" + credit_score +
                ", email='" + email + '\'' +
                '}';
    }
}
