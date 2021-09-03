package com.wasu.demo53.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName:TestData
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 9:45
 */
@Data
public class TestData {
    private int id;
    private String field1;
    private String field2;
    @NotBlank
    private String field3;
}
