package com.wasu.demo11.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName:ShiroSessionListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 15:48
 */
public class ShiroSessionListener implements SessionListener {
    //sessionCount用于统计在线session的数量
    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }
}
