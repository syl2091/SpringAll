package com.wasu.demo4.controller;

import com.wasu.demo4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:StudentController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/15 17:14
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAllStudents")
    public List<Map<String,Object>> getAllStudents(){
        return studentService.getAllStudents();
    }
}
