package com.wasu.demo38.service.impl;

import com.wasu.demo38.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @ClassName:Java7CalculateServiceImpl
 * @Description: @Profile可以根据不同的环境变量来注册不同的组件，下面我们来学一下它的用法。
 * @Author: Syl
 * @Date: 2021/8/13 17:18
 */
@Service
@Profile("java7")
public class Java7CalculateServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... value) {
        System.out.println("java7环境下运行");
        int result = 0;
        for (int i = 0; i < value.length; i++) {
            result += i;
        }
        return result;
    }
}
