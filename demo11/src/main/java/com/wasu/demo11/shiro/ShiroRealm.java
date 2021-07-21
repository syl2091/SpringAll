package com.wasu.demo11.shiro;

import com.wasu.demo11.dao.UserMapper;
import com.wasu.demo11.dao.UserPermissionMapper;
import com.wasu.demo11.dao.UserRoleMapper;
import com.wasu.demo11.pojo.Permission;
import com.wasu.demo11.pojo.Role;
import com.wasu.demo11.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.lang.model.element.UnknownAnnotationValueException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @ClassName:ShiroRealm
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 9:38
 */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserPermissionMapper userPermissionMapper;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUserName();
        logger.info("用户" + userName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色集
        List<Role> roles = userRoleMapper.findByUserName(userName);
        Set<String> roleSet = new HashSet<>();
        for (Role r : roles) {
            roleSet.add(r.getName());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        //获取用户权限集合
        List<Permission> permissions = userPermissionMapper.findByUserName(userName);
        Set<String> permissionSet = new HashSet<>();
        for (Permission p : permissions) {
            permissionSet.add(p.getName());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        return simpleAuthorizationInfo;
    }


    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        logger.info("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user = userMapper.findByUserName(userName);
        if (StringUtils.isEmpty(user)) {
            throw new UnknownAccountException("用户名或密码错误!");
        }
        if (!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误!");
        }
        if ("0".equals(user.getStatus())){
            throw new LockedAccountException("账号已锁定,请联系管理员!");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,password,getName());
        return simpleAuthenticationInfo;
    }


}
