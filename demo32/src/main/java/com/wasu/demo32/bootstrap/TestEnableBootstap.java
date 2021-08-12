package com.wasu.demo32.bootstrap;

import com.wasu.demo32.annotation.EnableHelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName:TestEnableBootstap
 * @Description: 测试接口驱动  接口编程
 * @Author: Syl
 * @Date: 2021/8/12 13:33
 */
@EnableHelloWorld
public class TestEnableBootstap {
    public static Logger logger = LoggerFactory.getLogger(EnableAutoConfigurationBootstrap.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestEnableBootstap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans){
            logger.info(bean);
        }
        String hello = context.getBean("hello", String.class);
        String syl = context.getBean("syl",String.class);
        System.out.println("hello Bean: " + hello);
        System.out.println("syl Bean: " + syl);
        context.close();
    }
}
