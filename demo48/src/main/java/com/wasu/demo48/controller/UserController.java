package com.wasu.demo48.controller;

import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName:UserController
 * @Description: 为什么需要资源服务器呢？我们先来看下在没有定义资源服务器的时候，使用Token去获取资源时会发生什么。
 * @Author: Syl
 * @Date: 2021/8/20 16:56
 */
@RestController
public class UserController {
  @GetMapping("index")
  public Object index(@AuthenticationPrincipal Authentication authentication, HttpServletRequest request){
      String header = request.getHeader("Authorization");
      String token = StringUtils.substringAfter(header, "bearer ");
      return Jwts.parser().setSigningKey("test_key".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
  }
}
