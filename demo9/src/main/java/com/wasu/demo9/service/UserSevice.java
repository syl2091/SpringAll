package com.wasu.demo9.service;

import com.wasu.demo9.pojo.User;

/**
 * @ClassName:UserSevice
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 16:02
 */
public interface UserSevice {
    User findByUserName(String userName);
}
