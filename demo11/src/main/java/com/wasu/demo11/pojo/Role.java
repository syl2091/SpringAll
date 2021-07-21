package com.wasu.demo11.pojo;

import java.io.Serializable;

/**
 * @ClassName:Role
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 9:24
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -227437593919820521L;
    private String id;
    private String name;
    private String memo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
