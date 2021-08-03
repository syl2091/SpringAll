package com.wasu.demo25.service;

import com.wasu.demo25.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:UserService
 * @Description:  value指定服务提供者  fallback指定降级类
 * @Author: Syl
 * @Date: 2021/8/3 16:23
 */
@FeignClient(value = "Server-Provider",fallback = UserServiceFallback.class)
public interface UserService {
    @GetMapping("user/{id}")
    public User get(@PathVariable("id") Long id);

    @GetMapping("user")
    public List<User> get();

    @PostMapping("user")
    public void add(@RequestBody User user);

    @PutMapping("user")
    public void update(@RequestBody User user);

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable("id") Long id);
}
