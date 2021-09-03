package com.wasu.demo56;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Demo56Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo56Application.class, args);
    }

}
