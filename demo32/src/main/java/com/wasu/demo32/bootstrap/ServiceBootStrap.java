package com.wasu.demo32.bootstrap;

import com.wasu.demo32.service.TestService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName:ServiceBootStrap
 * @Description: 用于测试注册TestService并从IOC容器中获取它
 * @Author: Syl
 * @Date: 2021/8/12 11:23
 */
@ComponentScan("com.wasu.demo32.service")
public class ServiceBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ServiceBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        TestService testService = context.getBean("testService", TestService.class);
        System.out.println("TestService Bean: " + testService);
        context.close();
    }
}
