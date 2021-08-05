package com.wasu.demo27.filter.sms;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:SmsAuthenticationFilter
 * @Description: 处理短信验证码登录请求的过滤器
 * @Author: Syl
 * @Date: 2021/8/5 10:56
 */
public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String MOBILE_KEY = "mobile";
    private String mobileParameter = MOBILE_KEY;
    private boolean postOnly = true;
    public SmsAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/mobile", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
