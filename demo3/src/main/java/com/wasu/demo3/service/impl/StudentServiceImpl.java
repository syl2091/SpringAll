package com.wasu.demo3.service.impl;

import com.wasu.demo3.bean.Student;
import com.wasu.demo3.mapper.StudentMapper;
import com.wasu.demo3.service.StudentService;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:StudentServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 16:06
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int deleteBySno(Student student) {
        return studentMapper.deleteBySno(student);
    }

    @Override
    public Student queryStudentBySno(String  sno) {
        return studentMapper.queryStudentBySno(sno);
    }
}
