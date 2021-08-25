package com.wasu.demo49.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @ClassName:UserController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/25 16:03
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }

    @GetMapping("auth/test1")
    @PreAuthorize("hasAuthority('user:add')")
    public String authTest1(){
        return "您拥有'user:add'权限";
    }

    @GetMapping("auth/test2")
    @PreAuthorize("hasAuthority('user:update')")
    public String authTest2(){
        return "您拥有'user:update'权限";
    }
}
