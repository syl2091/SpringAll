package com.wasu.demo27.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName:ValidateCodeException
 * @Description: 自定义验证码异常
 * @Author: Syl
 * @Date: 2021/8/4 17:12
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654458L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
