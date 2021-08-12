package com.wasu.demo32.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName:EnableAutoConfigurationBootstrap
 * @Description: 测试自动装配
 * @Author: Syl
 * @Date: 2021/8/12 13:53
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {
    public static Logger logger = LoggerFactory.getLogger(EnableAutoConfigurationBootstrap.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans){
            logger.info(bean);
        }
        String hello = context.getBean("hello",String.class);
        System.out.println("hello Bean: " + hello);
        context.close();
        context.close();
    }
}
