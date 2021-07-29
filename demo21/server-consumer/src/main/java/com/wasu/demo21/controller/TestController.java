package com.wasu.demo21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:TestController
 * @Description: 用于消费服务
 * @Author: Syl
 * @Date: 2021/7/29 15:56
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    public String getInfo(){
        return this.restTemplate.
                getForEntity("http://Server-Provider/info",String.class).getBody();
    }
}
