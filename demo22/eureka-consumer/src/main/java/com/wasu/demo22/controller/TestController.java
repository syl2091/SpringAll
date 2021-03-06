package com.wasu.demo22.controller;

import com.wasu.demo22.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.wasu.demo22.entity.User;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/30 11:01
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;


    @GetMapping("/info")
    public String getInfo(){
        return userService.getInfo();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/user/{id}")
                .build().expand(params).encode().toUri();
        return this.restTemplate.getForEntity(uri, User.class).getBody();
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
    }

    @GetMapping("/user/add")
    public String addUser() {
        User user = new User(1L, "mrbird", "123456");
        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @GetMapping("user/update")
    public void updateUser() {
        User user = new User(1L, "mrbird", "123456");
        this.restTemplate.put("http://Server-Provider/user", user);
    }

    @GetMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.restTemplate.delete("http://Server-Provider/user/{1}", id);
    }
}