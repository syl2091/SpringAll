package com.wasu.demo7.bean;

import java.io.Serializable;

/**
 * @ClassName:Student
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/16 15:42
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sno;
    private String name;
    private String sex;
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

}
