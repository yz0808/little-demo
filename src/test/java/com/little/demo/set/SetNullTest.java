package com.little.demo.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yangzhong
 * @Date 2022-09-14 18:30
 * @Description 描述
 */
public class SetNullTest {

    public static void main(String[] args) {
        Set<Long> sets = new HashSet<>();
        sets.add(1L);
        System.out.println(sets.contains(null));
    }
}
