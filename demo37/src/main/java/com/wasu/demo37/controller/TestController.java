package com.wasu.demo37.controller;

import com.wasu.demo37.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName:TestController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/13 10:18
 */
@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @GetMapping("async")
    @ResponseBody
    public String testAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");
        Future<String> stringFuture = testService.asyncMethod();
        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }

    @GetMapping("sync")
    public void sync(){
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");
        testService.syncMethod();
        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }


}
