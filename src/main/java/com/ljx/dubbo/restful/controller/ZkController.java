package com.ljx.dubbo.restful.controller;

import com.ljx.dubbo.restful.util.ZkUtil;
import io.swagger.annotations.Api;
import javax.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaxiong
 * @date 2020/6/11 2:53 下午
 */
@Api(tags = "zookeeper 相关接口")
@RestController
@RequestMapping("/zk")
@Validated
public class ZkController {

    @GetMapping(value = "/getDubboAddress")
    public Object getData(@RequestParam @NotBlank(message = "zk地址不能为空") String zk,
            @RequestParam @NotBlank(message = "dubbo地址不能为空") String path) {
        return ZkUtil.getDubboData(zk, path);
    }

}
