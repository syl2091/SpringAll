package com.wasu.demo55.exception;

/**
 * @ClassName:MyJobExecutionException
 * @Description: 自定义异常
 * @Author: Syl
 * @Date: 2021/9/3 13:47
 */
public class MyJobExecutionException extends Exception{
    private static final long serialVersionUID = 7168487913507656106L;

    public MyJobExecutionException(String message) {
        super(message);
    }
}
