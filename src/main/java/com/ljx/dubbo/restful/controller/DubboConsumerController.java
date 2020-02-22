package com.ljx.dubbo.restful.controller;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.ljx.dubbo.restful.dto.DubboDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaxiong
 * @date 2020/2/21 1:53 下午
 */
@RestController
@RequestMapping("/generalization")
public class DubboConsumerController {

    private static Logger logger = LoggerFactory.getLogger(DubboConsumerController.class);

    @RequestMapping(value = "/call", method = RequestMethod.POST)
    public Object generalizationCall(@RequestBody DubboDto dto) {

        logger.info(">>>>>调用dubbo服务接口,入参:{}", dto);
        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface(dto.getInterfaceName());
        // 声明为泛化接口
        reference.setGeneric(true);
        reference.setApplication(new ApplicationConfig(dto.getApplication()));
        reference.setVersion(dto.getVersion());
        reference.setTimeout(dto.getTimeout());
        reference.setUrl(dto.getUrl());
        // 获取缓存中的实例
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        // 基本类型以及Date,List,Map等不需要转换，直接调用
        // 调用实例
        Object result = genericService.$invoke(dto.getMethod(), dto.getParameterTypes(), dto.getArgs());
        logger.info(">>>>>调用dubbo服务接口,出参:{}", result);
        return result;
    }
}
