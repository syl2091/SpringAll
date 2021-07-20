package com.wasu.demo10.dao;

import com.wasu.demo10.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}