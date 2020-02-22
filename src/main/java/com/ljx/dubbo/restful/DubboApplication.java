package com.ljx.dubbo.restful;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author jiaxiong
 * @date 2020/2/21 1:55 下午
 */
@SpringBootApplication
public class DubboApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
