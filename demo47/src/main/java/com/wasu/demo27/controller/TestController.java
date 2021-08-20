package com.wasu.demo27.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String sessionInvalid(){
        return "session已失效，请重新认证";
    }


}
