package com.wasu.demo37;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Demo37Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo37Application.class, args);
    }

}
