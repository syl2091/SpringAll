package com.wasu.demo32.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @ClassName:FirstLevelService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 11:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface FirstLevelService {
    String value() default "";
}
