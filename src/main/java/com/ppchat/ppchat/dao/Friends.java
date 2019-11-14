package com.ppchat.ppchat.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 对于数据库中ppfriends表的描述
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Friends {
    //用户1的id
    private String ppid1;
    //用户2的id
    private String ppid2;

    public String getPpid1() {
        return ppid1;
    }

    public String getPpid2() {
        return ppid2;
    }

    public void setPpid1(String ppid1) {
        this.ppid1 = ppid1;
    }

    public void setPpid2(String ppid2) {
        this.ppid2 = ppid2;
    }
}
