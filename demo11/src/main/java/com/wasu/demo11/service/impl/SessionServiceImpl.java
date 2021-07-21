package com.wasu.demo11.service.impl;

import com.wasu.demo11.pojo.User;
import com.wasu.demo11.pojo.UserOnline;
import com.wasu.demo11.service.SessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName:SessionServiceImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 16:01
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private RedisSessionDAO redisSessionDAO;

    @Override
    public List<UserOnline> list() {
        List<UserOnline> list = new ArrayList<>();
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        for (Session s : sessions) {
            UserOnline userOnline = new UserOnline();
            User user;
            SimplePrincipalCollection simplePrincipalCollection;
            if (s.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)== null){
                continue;
            }else {
                simplePrincipalCollection = (SimplePrincipalCollection)s.
                        getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                user = (User)simplePrincipalCollection.getPrimaryPrincipal();
                userOnline.setUsername(user.getUserName());
                userOnline.setUserId(user.getId());
            }
            userOnline.setId((String) s.getId());
            userOnline.setHost(s.getHost());
            userOnline.setStartTimestamp(s.getStartTimestamp());
            userOnline.setLastAccessTime(s.getLastAccessTime());
            Long timeOut = s.getTimeout();
            if (timeOut==0L){
                userOnline.setStatus("离线");
            }else {
                userOnline.setStatus("在线");
            }
            userOnline.setTimeout(timeOut);
            list.add(userOnline);
        }
        return list;
    }

    @Override
    public boolean forceLogout(String sessionId) {
        Session session = redisSessionDAO.readSession(sessionId);
       // 普通 session.setTimeout(0L);
        // redis
        redisSessionDAO.delete(session);
        return true;
    }
}
