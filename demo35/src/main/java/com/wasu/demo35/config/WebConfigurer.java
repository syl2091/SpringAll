package com.wasu.demo35.config;

import com.wasu.demo35.converter.PropertiesHttpMessageConverter;
import com.wasu.demo35.resolver.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:WebConfigurer
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 16:32
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    /**
     * 需将PropertiesHttpMessageConverter添加到HttpMessageConverter集合中
     * @param converters
     */
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
      //  converters.add(new PropertiesHttpMessageConverter());
        //添加在第一个
        converters.add(0,new PropertiesHttpMessageConverter());
    }

    @PostConstruct
    public void init() {
        // 获取当前 RequestMappingHandlerAdapter 所有的 ArgumentResolver对象
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newArgumentResolvers = new ArrayList<>(argumentResolvers.size() + 1);
        // 添加 PropertiesHandlerMethodArgumentResolver 到集合第一个位置
        newArgumentResolvers.add(0, new PropertiesHandlerMethodReturnValueHandler());
        // 将原 ArgumentResolver 添加到集合中
        newArgumentResolvers.addAll(argumentResolvers);
        // 重新设置 ArgumentResolver对象集合
        requestMappingHandlerAdapter.setArgumentResolvers(newArgumentResolvers);
    }



}
