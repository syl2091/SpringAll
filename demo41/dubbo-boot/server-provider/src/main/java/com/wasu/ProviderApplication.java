package com.wasu;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName:ProviderApplication
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/11 16:15
 */
@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        System.out.println("complete");
    }
}
