package com.wasu.demo11.dao;

import com.wasu.demo11.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}
