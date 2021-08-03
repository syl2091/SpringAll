package com.wasu.demo22.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName:WebSecurityConfig
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/3 10:56
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //关闭csrf  新版本安全模式默认开启csrf 必须关闭
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证
    }

}
