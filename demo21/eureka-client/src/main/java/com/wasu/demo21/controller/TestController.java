package com.wasu.demo21.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/29 14:20
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;


    @GetMapping("/info")
    @ResponseBody
    public String info(){
        List<String> instance = client.getServices();
        logger.info(instance.toString());
        return instance.toString();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
