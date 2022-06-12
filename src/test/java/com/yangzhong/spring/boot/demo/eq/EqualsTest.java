package com.yangzhong.spring.boot.demo.eq;

import com.yangzhong.spring.boot.demo.model.Person;

/**
 * @Author yangzhong
 * @Date 2022-06-07 15:37
 * @Description EqualsTest
 */
public class EqualsTest {

    public static void main(String[] args) {
        Person p1 = new Person("yzz01", 18);
        System.out.println("p1:" + p1);
        Person p2 = new Person();
        p2 = p1;
        System.out.println("p2:" + p2);
        p1.setName("dyt01");
        System.out.println("p1:" + p1 + " p2:" + p2);
    }
}
