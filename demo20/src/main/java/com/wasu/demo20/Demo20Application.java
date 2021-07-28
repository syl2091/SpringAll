package com.wasu.demo20;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wasu.demo20")
public class Demo20Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo20Application.class, args);
    }

}
