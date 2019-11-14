package com.ppchat.ppchat.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 数据库ppuser的描述
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    //用户编号，自生
    private int uid;
    //用户ppid，随机生成
    private String ppid;
    //用户昵称
    private String nickname;
    //用户密码
    private String pwd;

    public int getUid() {
        return uid;
    }

    public String getPpname() {
        return nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public void setPpname(String ppname) {
        this.nickname = ppname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
