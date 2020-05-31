package com.ljx.dubbo.restful;

import org.springframework.boot.Banner.Mode;
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
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DubboApplication.class);
        builder.web(WebApplicationType.SERVLET).run(args);
        // 关闭banner，banner生成网址：http://www.network-science.de/ascii/
        builder.bannerMode(Mode.OFF).run(args);
        // 多个配置文件本地启动，或者--spring.profile.active=prod
        builder.application().setAdditionalProfiles("prod");
        builder.run(args);
    }
}
