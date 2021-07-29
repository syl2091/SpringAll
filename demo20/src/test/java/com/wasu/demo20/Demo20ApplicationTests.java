package com.wasu.demo20;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wasu.demo20.bean.User;
import com.wasu.demo20.mapper.UserMapper;
import com.wasu.demo20.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class Demo20ApplicationTests {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        PageHelper.startPage(2, 2);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        List<User> list2 = pageInfo.getList();
        for (User u : list2) {
            System.out.println(u.getUsername());
        }
    }

    @Test
    void getAll() {
        List<User> list = userService.selectAll();
        for (User user : list) {
            System.out.println(user.getId());
        }
    }

}
