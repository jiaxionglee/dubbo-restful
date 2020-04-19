package com.ljx.dubbo.restful.exception;

import lombok.Getter;

/**
 * @author jiaxiong
 * @date 2020/4/19 5:18 下午
 */
@Getter
public enum ResultCode {

    SUCCESS(0, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
