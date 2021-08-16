package com.wasu.demo38.factory;

import com.wasu.demo38.entity.Cherry;

/**
 * @ClassName:FactoryBean
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/16 9:33
 */
public class FactoryBean implements org.springframework.beans.factory.FactoryBean<Cherry> {
    @Override
    public Cherry getObject() throws Exception {
        return new Cherry();
    }

    @Override
    public Class<?> getObjectType() {
        return Cherry.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
