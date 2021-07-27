package com.wasu.demo19.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:UserController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/27 14:33
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public void user(@PathVariable String id){
        try{
            System.out.println(id);
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }

}
