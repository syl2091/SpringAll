package com.wasu.demo9.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:User
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 15:30
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}
