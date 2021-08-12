package com.wasu.demo34.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName:User
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 16:06
 */

public class User implements Serializable {
    private static final long serialVersionUID = -2731598327208972274L;
    @NotBlank(message = "{required}")
    private String name;
    @Email(message = "{invalid}")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
