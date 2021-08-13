package com.wasu.demo36.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/13 9:23
 */
@Controller
public class TestController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * @CrossOrigin 解决跨域问题的注解
     * @return
     */
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
