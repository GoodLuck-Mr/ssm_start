package com.ssm.domain;

import java.io.Serializable;

/**
 * @projectName: mrzhao_ssm
 * @className : Member
 * 类 的 描 述  ：创建会员实体类 ！
 **/
public class Member implements Serializable {
    private String id;
    private String name;       // 会员姓名
    private String nickname;   // 会员 昵称
    private String phoneNum;   //会员手机号
    private String email;      //会员Email

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
