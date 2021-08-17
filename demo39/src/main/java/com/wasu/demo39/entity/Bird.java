package com.wasu.demo39.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName:Bird
 * @Description: 实现InitializingBean&DisposableBean 接口
 * @Author: Syl
 * @Date: 2021/8/17 9:20
 */
public class Bird implements InitializingBean , DisposableBean {
    public Bird() {
        System.out.println("无参构造");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁bird");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化bird");
    }
}
