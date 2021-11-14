package com.yangzhong.spring.boot.demo.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author yangzhong
 * @Date 2021-06-08 21:49
 * @Description 描述
 */
public class ComparatorTest {
    public static void main(String[] args) {

        List<Long> testList = new ArrayList<Long>() {
            {
                add(10L);
                add(1L);
                add(18L);
                add(20L);
            }
        };
        testList.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(testList);
    }
}
