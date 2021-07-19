package com.wasu.demo9.dao;

import com.wasu.demo9.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}
