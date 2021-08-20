package com.wasu.demo27.config;

import com.wasu.demo27.pojo.MyUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:MyUserDetailConfig
 * @Description: 登录逻辑处理类
 * @Author: Syl
 * @Date: 2021/8/4 9:34
 */
@Configuration
public class MyUserDetailConfig implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟一个用户替代数据库
        MyUser user = new MyUser();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode("123456"));
        logger.info("加密后的密码:" + user.getPassword());
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.equalsIgnoreCase("syl", username)) {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        } else {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("test");
        }
        return new User(username, user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired()
                , user.isAccountNonLocked(), authorities);
    }


}
