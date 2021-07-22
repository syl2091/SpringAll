package com.wasu.demo14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo14Application {

    @RequestMapping("/")
    String index() {
        return "hello spring boot";
    }
    public static void main(String[] args) {
        SpringApplication.run(Demo14Application.class, args);
    }

}
