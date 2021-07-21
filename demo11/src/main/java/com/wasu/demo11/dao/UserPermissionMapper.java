package com.wasu.demo11.dao;

import com.wasu.demo11.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {
    List<Permission> findByUserName(String userName);
}
