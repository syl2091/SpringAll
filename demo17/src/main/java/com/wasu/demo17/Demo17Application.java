package com.wasu.demo17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo17Application {


    @RequestMapping("/")
    public String index(){
        return "你好";
    }
    public static void main(String[] args) {
        SpringApplication.run(Demo17Application.class, args);
    }

}
