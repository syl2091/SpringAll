package com.wasu.demo7.controller;

import com.wasu.demo7.bean.Student;
import com.wasu.demo7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:StudentController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 9:56
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStudent/{sno}")
    public Student getStudent(@PathVariable String sno){
        return studentService.queryStudentBySno(sno);
    }

    @RequestMapping("/updateStudent/{sno}/{name}")
    public void updateStudent(@PathVariable String sno,@PathVariable String name){
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        studentService.update(student);
    }
}
