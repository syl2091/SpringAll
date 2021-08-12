package com.wasu.demo32.configuration;

import com.wasu.demo32.annotation.EnableHelloWorld;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:HelloWorldAutoConfiguration
 * @Description: 自动装配
 * @Author: Syl
 * @Date: 2021/8/12 13:49
 */
@Configuration
@EnableHelloWorld
@ConditionalOnProperty(name = "helloworld", havingValue = "true")
public class HelloWorldAutoConfiguration {
}

