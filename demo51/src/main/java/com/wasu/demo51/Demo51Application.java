package com.wasu.demo51;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Demo51Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo51Application.class, args);
    }

}
