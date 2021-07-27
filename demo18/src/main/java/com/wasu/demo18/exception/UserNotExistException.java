package com.wasu.demo18.exception;

import java.io.Serializable;

/**
 * @ClassName:UserNotExistException
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/27 13:56
 */
public class UserNotExistException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -3265080064304886801L;

    public String id;

    public UserNotExistException(String id) {
        super("user is not exits");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
