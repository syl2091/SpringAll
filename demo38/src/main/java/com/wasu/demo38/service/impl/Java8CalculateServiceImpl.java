package com.wasu.demo38.service.impl;

import com.wasu.demo38.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @ClassName:Java8CalculateServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/13 17:22
 */
@Service
@Profile("java8")
public class Java8CalculateServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... value) {
        System.out.println("Java 8环境下执行");
        return Arrays.stream(value).reduce(0, Integer::sum);
    }
}
