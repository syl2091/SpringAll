package com.wasu.demo20.bean;

import javax.persistence.*;

@Table(name = "student")
public class Student {
    @Column(name = "SNO")
    private String sno;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "SSEX")
    private String ssex;

    /**
     * @return SNO
     */
    public String getSno() {
        return sno;
    }

    /**
     * @param sno
     */
    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    /**
     * @return SNAME
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * @return SSEX
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * @param ssex
     */
    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }
}