package com.wasu.demo7.service.impl;

import com.wasu.demo7.bean.Student;
import com.wasu.demo7.mapper.StudentMapper;
import com.wasu.demo7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName:StudentServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/16 15:47
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Cacheable(value = "student-key")
    public void update(Student student) {
        this.studentMapper.update(student);
    }

    @Override
    public void deleteStudentBySno(String sno) {
        this.studentMapper.deleteStudentBySno(sno);
    }

    @Override
    @Cacheable(value = "student-key")
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }
}
