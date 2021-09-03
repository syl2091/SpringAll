package com.wasu.demo54;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Demo54Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo54Application.class, args);
    }

}
