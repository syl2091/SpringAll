package com.wasu.demo34.controller;

import com.wasu.demo34.domain.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 15:31
 */
@RestController
@Validated
public class TestController {

    /**
     * 方法参数校验
     * @param name
     * @param email
     * @return
     */
    @GetMapping("test1")
    public String test1(@NotBlank(message = "{required}")String name, @Email(message = "{invalid}")String email){
        return "success";
    }


    @GetMapping("test2")
    public String test2(@Valid User user) {
        return "success";
    }
}
