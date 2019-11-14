package com.ppchat.ppchat.util;

import com.ppchat.ppchat.entity.Message;

public class ResultUtils {
    private ResultUtils() {
    }

    public static Message success(Object object) {
        Message message = new Message();
        message.setCode("0000");
        message.setMsg("请求成功");
        message.setData(object);
        return message;
    }

    public static Message error(String code, String message) {
        Message message1 = new Message();
        message1.setCode(code);
        message1.setMsg(message);
        return message1;
    }

    public static Message success() {
        Message message = new Message();
        message.setCode("0000");
        message.setMsg("请求成功");
        return message;
    }
}
