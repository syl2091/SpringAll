package com.wasu.demo38;

import com.wasu.demo38.config.WebConfig;
import com.wasu.demo38.entity.User;
import com.wasu.demo38.factory.FactoryBean;
import com.wasu.demo38.service.CalculateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Demo38Application {

    public static void main(String[] args) {

        //返回ioc容器
        ApplicationContext context =   new AnnotationConfigApplicationContext(WebConfig.class);
        System.out.println("容器创建完毕");
        User user1 = context.getBean(User.class);
        User user2 = context.getBean(User.class);
        System.out.println(user1==user2);
        String[] beanNames = context.getBeanDefinitionNames();
        Object cherry = context.getBean("cherryFactoryBean");
        System.out.println(cherry.getClass());
        Arrays.stream(beanNames).forEach(System.out::println);

/*        ConfigurableApplicationContext context1 = new SpringApplicationBuilder(Demo38Application.class)
                .web(WebApplicationType.NONE)
                .profiles("java7")
                .run(args);

        CalculateService service = context1.getBean(CalculateService.class);
        System.out.println("求合结果： " + service.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));*/
    }



}
