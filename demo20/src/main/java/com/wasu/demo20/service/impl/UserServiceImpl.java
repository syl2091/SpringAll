package com.wasu.demo20.service.impl;

import com.wasu.demo20.bean.User;
import com.wasu.demo20.mapper.UserMapper;
import com.wasu.demo20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/28 16:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
