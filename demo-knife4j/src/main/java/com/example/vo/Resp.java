package com.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Schema(description = "统一数据返回结果")
@Data
@Builder
public class Resp {

    @Schema(description = "业务操作结果")
    private int code;

    @Schema(description = "业务返回数据")
    private Object data;

    @Schema(description = "操作结果信息")
    private String message;

    @Schema(description = "操作时间")
    private Date datetime;

    public static Resp ok() {
        return Resp.builder().code(0).build();
    }

    public static Resp ok(Object data) {
        return Resp.builder().code(0).data(data).datetime(new Date()).message("请求成功").build();
    }

    public static Resp error(int code) {
        return Resp.builder().code(code).datetime(new Date()).message("操作失败").build();
    }

    public static Resp error(int code, String message) {
        return Resp.builder().code(code).datetime(new Date()).message(message).build();
    }

    public static Resp error(String message) {
        return Resp.builder().code(2).datetime(new Date()).message(message).build();
    }

}
