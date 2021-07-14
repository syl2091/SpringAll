package com.wasu.demo2.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName:BlogProperties
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 10:45
 */
@Component
public class BlogProperties {
    @Value("${syl.name}")
    private String name;
    @Value("${syl.age}")
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
