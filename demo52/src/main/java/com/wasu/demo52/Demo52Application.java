package com.wasu.demo52;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Demo52Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo52Application.class, args);
    }

}
