package com.yangzhong.spring.boot.demo.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangzhong
 * @Date 2021-07-23 04:50
 * @Description 描述
 */
public class ListPerformanceTest {
    public static void main(String[] args) {
        long time = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            List<String> list = new ArrayList<>();
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            List<String> list = Lists.newArrayList();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
