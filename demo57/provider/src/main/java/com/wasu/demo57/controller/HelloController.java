package com.wasu.demo57.controller;

import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController; /**
 * @ClassName:HelloController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/7 16:20
 */
@RestController
@RequestMapping("provide")
public class HelloController {

    @GetMapping("{message}")
    public String hello(@PathVariable String message){
        return String.format("hello %s", message);
    }
}
