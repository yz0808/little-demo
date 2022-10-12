package com.little.demo.json.domain;

/**
 * @Author yangzhong
 * @Date 2021-05-13 16:33
 * @Description 描述
 */
public class FastJsonDomain {
    private String name;

    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getHa(String str) {
        return "hahaha";
    }
}
