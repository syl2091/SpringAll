package com.wasu.demo11.dao;

import com.wasu.demo11.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    List<Role> findByUserName(String userName);
}
