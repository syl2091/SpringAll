package com.wasu.demo8.service.impl;

import com.wasu.demo8.entity.Student;
import com.wasu.demo8.mapper.StudentMapper;
import com.wasu.demo8.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:StudentServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 14:01
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student update(Student student) {
        studentMapper.update(student);
        return studentMapper.queryStudentBySno(student.getSno());
    }

    @Override
    public void deleteStudentBySno(String sno) {
        studentMapper.deleteStudentBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return studentMapper.queryStudentBySno(sno);
    }
}
