package com.wasu.demo20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wasu.demo20")
public class Demo20Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo20Application.class, args);
    }

}
