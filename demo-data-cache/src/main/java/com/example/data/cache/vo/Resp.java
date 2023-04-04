package com.example.data.cache.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;



@Data
@Builder
public class Resp {

    private int code;

    private Object data;

    private String message;

    private Date datetime;

    public static Resp ok(Object data) {
        return Resp.builder().code(0).data(data).datetime(new Date()).message("请求成功").build();
    }

    public static Resp error(String message) {
        return Resp.builder().code(200).datetime(new Date()).message(message).build();
    }

}
