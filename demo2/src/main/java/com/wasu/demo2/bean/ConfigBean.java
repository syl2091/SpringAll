package com.wasu.demo2.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName:ConfigBean
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 10:49
 */
@Component
@ConfigurationProperties(prefix = "syl")
public class ConfigBean {
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
