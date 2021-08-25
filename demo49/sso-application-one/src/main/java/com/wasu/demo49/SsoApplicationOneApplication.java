package com.wasu.demo49;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso //开启单点登录
public class SsoApplicationOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplicationOneApplication.class, args);
    }

}
