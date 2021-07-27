package com.wasu.demo19.webconfig;

import com.wasu.demo19.filter.TimeFilter;
import com.wasu.demo19.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:WebConfig
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/27 14:20
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);
        List<String> urlList = new ArrayList<>();
        urlList.add("/*");
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(timeInterceptor);
        interceptorRegistration.addPathPatterns("/**");//拦截所有路径
        interceptorRegistration.excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.css");//添加不拦截路劲
    }
}
