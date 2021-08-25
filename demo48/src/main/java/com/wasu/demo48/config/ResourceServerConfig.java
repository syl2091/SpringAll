package com.wasu.demo48.config;

import com.wasu.demo48.handler.MyAuthenticationFailureHandler;
import com.wasu.demo48.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @ClassName:ResourceServerConfig
 * @Description: 自定义用户名密码方式获取令牌
 * @Author: Syl
 * @Date: 2021/8/20 17:00
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin() //表单登录
            .loginProcessingUrl("/login")//处理表单登录url
            .successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)
            .and()
                .authorizeRequests()//授权配置
                .antMatchers("/code/sms").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .anyRequest()//任何请求
                .authenticated()//都需要认证
            .and()
                .csrf().disable();
    }
}
