package com.wasu.demo2.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName:TestConfigBean
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 10:54
 */
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix="test")
@Component
public class TestConfigBean {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
