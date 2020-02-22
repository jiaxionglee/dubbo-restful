package com.ljx.dubbo.restful.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author jiaxiong
 * @date 2020/2/21 1:53 下午
 */
@Data
@ToString
public class DubboDto {

    private  String application;

    private String interfaceName;

    private String version;

    private String method;

    private Integer timeout;

    private String url;

    private String[] parameterTypes;

    private Object[] args;
}
