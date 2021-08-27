package com.wasu.demo51.entity;

import lombok.ToString;

/**
 * @ClassName:TestData
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/27 11:05
 */
@ToString
public class TestData {
    private int id;
    private String field1;
    private String field2;
    private String field3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
