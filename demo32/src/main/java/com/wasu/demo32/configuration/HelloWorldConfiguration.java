package com.wasu.demo32.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:HelloWorldConfiguration
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 13:30
 */

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public  String hello(){
        return "hello";
    }

    @Bean
    public String syl(){
        return "syl";
    }
}
