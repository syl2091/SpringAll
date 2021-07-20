package com.wasu.demo10.pojo;

import java.io.Serializable;

/**
 * @ClassName:Permission
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/19 17:21
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String url;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
