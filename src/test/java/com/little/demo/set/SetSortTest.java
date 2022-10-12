package com.little.demo.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yangzhong
 * @Date 2021-07-08 14:03
 * @Description 描述
 */
public class SetSortTest {

    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        set.add(148716L);
        set.add(107722L);
        set.add(108088L);
        set.add(100996L);
        set.add(101113L);
        System.out.println(set);
        // [100996, 101113, 108088, 107722, 148716]
        // [100996, 101113, 108088, 107722, 148716]
        // [100996, 101113, 108088, 107722, 148716]
    }
}
