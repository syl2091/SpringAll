package com.wasu.demo3.controller;

import com.wasu.demo3.bean.Student;
import com.wasu.demo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 16:22
 */
@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/querystudent/{sno}", method = RequestMethod.GET)
    public String getStudent(@PathVariable String sno) {
        Student student = studentService.queryStudentBySno(sno);
        return student.getName()+":"+student.getSex()+":"+student.getSno();
    }

    @RequestMapping(value = "/addstudent/{sno}/{name}/{sex}",method = RequestMethod.GET)
    public String addStudent(@PathVariable String sno, @PathVariable String name, @PathVariable String sex){
        Student student = new Student(sno,name,sex);
        try {
            studentService.add(student);
            return "成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "失败";
    }

    @RequestMapping(value = "/delStudent/{sno}",method = RequestMethod.GET)
    public String delStudent(@PathVariable String sno){
        try {
            studentService.deleteBySno(sno);
            return "成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "失败";
    }

}
