package com.wasu.demo39.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName:Fish
 * @Description: 使用注解
 * @Author: Syl
 * @Date: 2021/8/17 9:24
 */
public class Fish {
    public Fish() {
        System.out.println("无参构造");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化fish");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁fish");
    }
}
