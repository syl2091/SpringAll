package com.wasu.demo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Demo8Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo8Application.class, args);
    }

}
