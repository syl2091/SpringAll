package com.wasu.demo20.service;

import com.wasu.demo20.bean.User;

import java.util.List;


/**
 * @ClassName:UserService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/28 16:01
 */
public interface UserService {
    List<User> selectAll();
}
