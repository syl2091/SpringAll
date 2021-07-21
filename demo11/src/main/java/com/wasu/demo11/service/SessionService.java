package com.wasu.demo11.service;

import com.wasu.demo11.pojo.UserOnline;

import java.util.List;

/**
 * @ClassName:SessionService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 16:00
 */
public interface SessionService {
    //查看所有用户
    List<UserOnline> list();
    //踢出用户
    boolean forceLogout(String sessionId);
}
