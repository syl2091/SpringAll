package com.wasu.demo2.controller;

import com.wasu.demo2.bean.BlogProperties;
import com.wasu.demo2.bean.ConfigBean;
import com.wasu.demo2.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:IndexController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 10:56
 */
@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/blogProperties")
    String index() {
        return blogProperties.getName() + ":" + blogProperties.getAge();
    }

    @RequestMapping("/configBean")
    String index2() {
        return configBean.getName() + ":" + configBean.getAge();
    }

    @RequestMapping("/testConfigBean")
    String index3() {
        return testConfigBean.getName() + ":" + testConfigBean.getAge();
    }
}
