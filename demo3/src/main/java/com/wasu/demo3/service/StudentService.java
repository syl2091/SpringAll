package com.wasu.demo3.service;

import com.wasu.demo3.bean.Student;

public interface StudentService {
    int add(Student student);

    int update(Student student);

    int deleteBySno(Student student);

    Student queryStudentBySno(String sno);
}
