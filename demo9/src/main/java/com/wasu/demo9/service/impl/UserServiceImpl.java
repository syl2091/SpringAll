package com.wasu.demo9.service.impl;

import com.wasu.demo9.dao.UserMapper;
import com.wasu.demo9.pojo.User;
import com.wasu.demo9.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:UserServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 16:03
 */
@Service
public class UserServiceImpl implements UserSevice {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
