package com.wasu.demo49.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @ClassName:UserController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/25 16:05
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}