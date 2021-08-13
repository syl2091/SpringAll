package com.wasu.demo36.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName:WebConfigurer
 * @Description: 除了使用@CrossOrigin注解外，我们可以使用接口编程的方式进行统一配置。
 * @Author: Syl
 * @Date: 2021/8/13 9:44
 */
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET");
    }
}
