package com.wasu.demo48.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:UserController
 * @Description: 为什么需要资源服务器呢？我们先来看下在没有定义资源服务器的时候，使用Token去获取资源时会发生什么。
 * @Author: Syl
 * @Date: 2021/8/20 16:56
 */
@RestController
public class UserController {
  @GetMapping("index")
  public Object index(Authentication authentication){
      return authentication;
  }
}
