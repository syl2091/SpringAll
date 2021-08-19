package com.wasu.demo43.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 10:08
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("check")
    public String check() {
        logger.info("health check");
        return "ok";
    }

    @GetMapping("hello")
    public String hello() {
        logger.info("hello");
        return "hello from server provider";

    }

}
