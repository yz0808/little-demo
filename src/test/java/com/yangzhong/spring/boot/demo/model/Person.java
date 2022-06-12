package com.yangzhong.spring.boot.demo.model;

import lombok.Data;

/**
 * @Author yangzhong
 * @Date 2022-06-07 15:39
 * @Description Person
 */
@Data
public class Person {

    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
