package com.wasu.demo39.config;

import com.wasu.demo39.entity.Bird;
import com.wasu.demo39.entity.Fish;
import com.wasu.demo39.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:WebConfig
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/16 9:59
 */
@Configuration
public class WebConfig {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public User user() {
        return new User();

    }

    @Bean
    public Bird bird(){
        return new Bird();
    }

    @Bean
    public Fish fish(){
        return new Fish();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
