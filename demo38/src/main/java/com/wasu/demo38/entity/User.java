package com.wasu.demo38.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @ClassName:User
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/13 15:48
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String name;
    private Integer age;
}
