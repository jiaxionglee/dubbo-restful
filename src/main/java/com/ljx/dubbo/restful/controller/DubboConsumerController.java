package com.ljx.dubbo.restful.controller;

import com.ljx.dubbo.restful.dto.DubboDto;
import com.ljx.dubbo.restful.service.DubboGenericService;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaxiong
 * @date 2020/2/21 1:53 下午
 */
@Api(tags = "dubbo 接口")
@RestController
@RequestMapping("/generalization")
public class DubboConsumerController {

    @Resource
    private DubboGenericService genericService;

    @RequestMapping(value = "/call", method = RequestMethod.POST)
    public Object generalizationCall(@RequestBody DubboDto dto) {
        return genericService.dubboGeneric(dto);
    }
}
