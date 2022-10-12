package com.little.demo.set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author yangzhong
 * @Date 2020-11-23 18:02
 * @Description 描述
 */
public class SetFilterTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("-1");
        set.add(null);
        set.add(null);
        System.out.println("处理前：" + set);
        set = set.stream().filter(str -> !str.equals("-1")).collect(Collectors.toSet());
        System.out.println("处理后：" + set);
    }
}
