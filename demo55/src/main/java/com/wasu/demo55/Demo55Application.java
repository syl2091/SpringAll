package com.wasu.demo55;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Demo55Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo55Application.class, args);
    }

}
