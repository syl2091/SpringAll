package com.wasu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wasu.api.HelloService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


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
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello(String message) {

        System.out.println("调用 com.wasu.service.HelloServiceImpl#hello");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello," + message;
    }

    public String defaultHello(String message){
        return "hello," + message;
    }
}
