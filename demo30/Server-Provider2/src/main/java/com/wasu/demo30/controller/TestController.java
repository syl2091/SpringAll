package com.wasu.demo30.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/11 14:55
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        logger.info("调用server2的hello接口");
        return "hello";
    }
}
