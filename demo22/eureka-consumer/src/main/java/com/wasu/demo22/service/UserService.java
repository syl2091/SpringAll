package com.wasu.demo22.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:UserService
 * @Description: 简单起见不创建 接口
 * @Author: Syl
 * @Date: 2021/8/3 13:34
 */
@Service
public class UserService  {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private  RestTemplate restTemplate;


    /**
     *  @HystrixCommand 注解默认所有异常都触发降级  ignoreExceptions 忽略某异常
     * @return
     */
    @HystrixCommand(fallbackMethod = "getInfoDefault")
    public String getInfo(){
        return this.restTemplate.
                getForEntity("http://Server-Provider/info",String.class).getBody();
    }

    public String getInfoDefault(){
        return "Hystrix熔断降级测试";
    }


}
