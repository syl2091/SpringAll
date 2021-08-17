package com.wasu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wasu.api.HelloService;
import org.springframework.stereotype.Component;


/**
 * @ClassName:HelloServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/11 16:16
 */
@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}
