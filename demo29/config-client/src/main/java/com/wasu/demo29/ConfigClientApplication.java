package com.wasu.demo29;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ConfigClientApplication.class, args);
            System.out.println("Successful Start");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
