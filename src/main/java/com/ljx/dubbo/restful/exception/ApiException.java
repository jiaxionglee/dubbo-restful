package com.ljx.dubbo.restful.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @author jiaxiong
 * @date 2020/4/19 5:13 下午
 */
@Getter
public class ApiException extends RuntimeException{

    private int code;
    private String msg;

    public ApiException() {
        this(1001, "接口错误");
    }

    public ApiException(String msg) {
        this(1001, msg);
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
