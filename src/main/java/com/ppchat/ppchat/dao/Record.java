package com.ppchat.ppchat.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 对于记录聊天数据的表的描述
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record {
    //用户1的id
    private String ppid1;
    //用户2的id
    private String ppid2;
    //聊天信息的时间
    private String times;
    //聊天内容
    private String message;

    public String getPpid1() {
        return ppid1;
    }

    public String getPpid2() {
        return ppid2;
    }

    public String getTimes() {
        return times;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPpid1(String ppid1) {
        this.ppid1 = ppid1;
    }

    public void setPpid2(String ppid2) {
        this.ppid2 = ppid2;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
