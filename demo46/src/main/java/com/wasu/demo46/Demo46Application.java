package com.wasu.demo46;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Demo46Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo46Application.class, args);
    }

}
