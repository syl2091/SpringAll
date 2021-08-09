package com.wasu.demo27.filter.sms;

import com.wasu.demo27.config.MyUserDetailConfig;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @ClassName:SmsAuthenticationProvider
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/9 9:21
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {
    private MyUserDetailConfig myUserDetailConfig;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken smsAuthenticationToken = (SmsAuthenticationToken) authentication;
        UserDetails userDetails = myUserDetailConfig.loadUserByUsername
                ((String) smsAuthenticationToken.getPrincipal());
        if (userDetails == null){
            throw new InternalAuthenticationServiceException("未找到与该手机号对应的用户");
        }
        SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(userDetails,userDetails.getAuthorities());
        authenticationResult.setDetails(smsAuthenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SmsAuthenticationToken.class.isAssignableFrom(aClass);
    }

    public MyUserDetailConfig getMyUserDetailConfig() {
        return myUserDetailConfig;
    }

    public void setMyUserDetailConfig(MyUserDetailConfig myUserDetailConfig) {
        this.myUserDetailConfig = myUserDetailConfig;
    }
}
