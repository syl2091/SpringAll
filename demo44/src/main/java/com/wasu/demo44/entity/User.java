package com.wasu.demo44.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName:User
 * @Description:   表明这是一个文档对象，名称为user，对应Mongo DB里的user表。
 * @Author: Syl
 * @Date: 2021/8/19 13:46
 */
@Document(collection = "user")
public class User {
    /**
     * Id标注主键字段，String类型的主键值在插入的时候Mongo DB会帮我们自动生成。
     * 如果对象中的某个属性为非表字段，可以使用注解@Transient进行排除。
     */
    @Id
    private String id;
    private String name;
    private Integer age;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
