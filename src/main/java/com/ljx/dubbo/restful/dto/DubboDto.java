package com.ljx.dubbo.restful.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "dubbo应用名不能为空")
    private String application;

    @ApiModelProperty(required = true, notes = "接口名")
    @NotBlank(message = "dubbo接口名不能为空")
    private String interfaceName;

    @ApiModelProperty(required = true, notes = "dubbo版本")
    @NotBlank(message = "dubbo版本不能为空")
    private String version;

    @ApiModelProperty(required = true, notes = "dubbo方法名")
    @NotBlank(message = "dubbo方法名不能为空")
    private String method;

    @ApiModelProperty(notes = "超时时间")
    private Integer timeout;

    @ApiModelProperty(required = true, notes = "dubbo地址加端口", example = "dubbo://127.0.0.1:20880")
    @NotBlank(message = "dubbo接口地址不能为空")
    private String url;

    @ApiModelProperty(notes = "参数类型", example = "java.Lang.String")
    private String[] parameterTypes;

    @ApiModelProperty(notes = "dubbo方法参数")
    private Object[] args;
}
