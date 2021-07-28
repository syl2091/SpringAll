package com.wasu.demo20;

import com.wasu.demo20.bean.User;
import com.wasu.demo20.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class Demo20ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("scott");
        user.setPasswd("ac089b11709f9b9e9980e7c497268dfa");
        user.setCreateTime(new Date());
        user.setStatus("0");
        this.userService.save(user);
    }

}
