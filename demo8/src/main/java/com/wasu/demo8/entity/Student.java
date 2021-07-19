package com.wasu.demo8.entity;

import java.io.Serializable;

/**
 * @ClassName:Student
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 13:51
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -339516038496531943L;
    private String sno;
    private String sname;
    private String ssex;



    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
}
