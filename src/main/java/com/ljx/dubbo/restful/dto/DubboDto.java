package com.ljx.dubbo.restful.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author jiaxiong
 * @date 2020/2/21 1:53 下午
 */
@ApiModel("接口参数")
@Data
@ToString
public class DubboDto {

    @ApiModelProperty(required = true, notes = "应用名")
    private String application;

    @ApiModelProperty(required = true, notes = "接口名")
    private String interfaceName;

    @ApiModelProperty(required = true, notes = "dubbo版本")
    private String version;

    @ApiModelProperty(required = true, notes = "dubbo方法名")
    private String method;

    @ApiModelProperty(required = false, notes = "超时时间")
    private Integer timeout;

    @ApiModelProperty(required = true, notes = "dubbo地址加端口", example = "dubbo://127.0.0.1:20880")
    private String url;

    @ApiModelProperty(required = false, notes = "参数类型", example = "java.Lang.String")
    private String[] parameterTypes;

    @ApiModelProperty(required = false, notes = "dubbo方法参数")
    private Object[] args;
}
