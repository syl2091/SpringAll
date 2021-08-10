package com.wasu.demo22.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/30 9:54
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @GetMapping("/info")
    public String info() {
        return registration.getHost() + ":" + registration.getUri();
    }
}
