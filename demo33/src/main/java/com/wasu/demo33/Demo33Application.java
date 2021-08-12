package com.wasu.demo33;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo33Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Demo33Application.class);
        application.setBannerMode(Banner.Mode.OFF); //关闭Banner打印
        application.setWebApplicationType(WebApplicationType.NONE); //设置应用环境为非WEB应用
        application.setAdditionalProfiles("dev"); //profiles指定为dev
        application.run(args);

    }

}
