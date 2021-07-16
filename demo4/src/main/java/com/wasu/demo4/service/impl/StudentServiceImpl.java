package com.wasu.demo4.service.impl;

import com.wasu.demo4.dao.StudentMapper;
import com.wasu.demo4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:StudentServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/15 17:16
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}
