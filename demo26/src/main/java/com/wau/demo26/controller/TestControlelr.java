package com.wau.demo26.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestControlelr
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/3 17:03
 */
@RestController
public class TestControlelr {

    @GetMapping("hello")
    public String hello(){
        return "hello syl";
    }
}
