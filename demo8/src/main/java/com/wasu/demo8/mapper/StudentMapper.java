package com.wasu.demo8.mapper;

import com.wasu.demo8.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    int update(Student student);

    void deleteStudentBySno(String sno);

    Student queryStudentBySno(String sno);
}
