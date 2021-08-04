package com.wasu.demo27.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/4 9:25
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "hello spring security";
    }

    @PostMapping("welcome")
    public String welcome(){
        return "welcome to code word";
    }

    @GetMapping("index")
    public Object index(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @RequestMapping("/loginFail")
    public String loginFail(){
        System.out.println("登录失败");
        return "redirect:/loginfail.html";
    }


}
