package com.yangzhong.spring.boot.demo.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yangzhong
 * @Date 2021-07-23 00:18
 * @Description 描述
 */
public class Set2ArrayTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("5");
        set.add("3");
        set.add("2");
        set.add("4");
        set.add("10");
        set.add("44");
        set.add("11");
        set.add("99");
        set.add("6");
        set.add("81");
        set.add("100");

        String[] strings = set.toArray(new String[set.size()]);
        for (String string : strings) {
            System.out.println(string);
        }
        // [Ljava.lang.String;@723279cf
        // [Ljava.lang.String;@723279cf
        // [Ljava.lang.String;@47d384ee
        System.out.println(strings);

    }
}
