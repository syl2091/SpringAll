package com.wasu.demo18.handler;

import com.wasu.demo18.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:ControllerExceptionHandler
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/27 14:05
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistsException(UserNotExistException e) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",e.getId());
        map.put("message",e.getMessage());
        return map;
    }
}
