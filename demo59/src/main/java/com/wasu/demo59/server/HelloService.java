package com.wasu.demo59.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @ClassName:HelloService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/13 16:46
 */
@Service
public class HelloService {
    @SentinelResource("hello")
    public String hello(){
        return "hello";
    }
}
