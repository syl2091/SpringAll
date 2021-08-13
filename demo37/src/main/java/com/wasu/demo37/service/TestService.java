package com.wasu.demo37.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:TestService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/13 10:08
 */
@Service
public class TestService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("asyncThreadPoolTaskExecutor")
    public Future<String> asyncMethod(){
        sleep();
        logger.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        //如果异步方法具有返回值的话，需要使用Future来接收回调值
        return new AsyncResult<>("hello async");
    }

    public void syncMethod() {
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
