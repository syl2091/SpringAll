package com.wasu.demo4.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:StudentDao
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/15 17:15
 */
@Mapper
public interface StudentMapper {
    List<Map<String,Object>> getAllStudents();
}
