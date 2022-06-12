package com.yangzhong.spring.boot.model;

import lombok.Data;

/**
 * @Author yangzhong
 * @Date 2022-03-01 16:26
 * @Description 描述
 */
@Data
public class Person {
    private String name;

    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }
}
