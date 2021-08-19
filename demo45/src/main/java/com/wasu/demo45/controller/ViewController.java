package com.wasu.demo45.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName:ViewController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 15:46
 */
@Controller
public class ViewController {
    @GetMapping("flux")
    public String flux() {
        return "flux";
    }
}
