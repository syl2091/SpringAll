package com.wasu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wasu.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:HelloController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/11 16:28
 */
@RestController
public class HelloController {


    @Reference
    private HelloService helloService;

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        return this.helloService.hello(message);
    }
}
