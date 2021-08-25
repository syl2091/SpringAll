package com.wasu.demo49;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SsoApplicationTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplicationTwoApplication.class, args);
    }

}
