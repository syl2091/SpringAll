package com.wau.demo26.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName:WebSecurityConfig
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/3 17:09
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    /*    http.csrf().disable(); //关闭csrf  新版本安全模式默认开启csrf 必须关闭
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证*/
        http.formLogin() //表单方式
                .and()
                .authorizeRequests() //授权配置
                .anyRequest() //所有请求
                .authenticated(); //都需要认证
    }
}
