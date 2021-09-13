package com.wasu.demo59.controller;

import com.wasu.demo59.server.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/13 16:07
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("test1")
    public String test1() throws InterruptedException {
        return "test1" + helloService.hello();
    }

    @GetMapping("test2")
    public String test2() {
        return "test2" + helloService.hello();
    }
}
