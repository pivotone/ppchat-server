package com.ppchat.ppchat.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    private String code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "Message{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", data" + data + '\'' + '}';
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
