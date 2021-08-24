package com.wasu.demo48.code;

import java.time.LocalDateTime;

/**
 * @ClassName:SmsCode
 * @Description: 验证码
 * @Author: Syl
 * @Date: 2021/8/24 9:40
 */
public class SmsCode {

    private String code;

    public SmsCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
