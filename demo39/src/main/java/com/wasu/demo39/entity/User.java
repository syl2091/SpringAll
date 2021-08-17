package com.wasu.demo39.entity;

/**
 * @ClassName:User
 * @Description: 自定义初始化  销毁方法
 * @Author: Syl
 * @Date: 2021/8/16 9:53
 */
public class User {
    public User() {
        System.out.println("调用无参构造器创建User");
    }

    public void init() {
        System.out.println("初始化User");
    }

    public void destory() {
        System.out.println("销毁User");
    }
}
