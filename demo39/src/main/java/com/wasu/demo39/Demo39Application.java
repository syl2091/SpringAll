package com.wasu.demo39;

import com.wasu.demo39.config.WebConfig;
import com.wasu.demo39.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo39Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo39Application.class, args);
        // 返回 IOC 容器，使用注解配置，传入配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        User user = context.getBean(User.class);
        //关闭ioc容器
        context.close();
    }

}
