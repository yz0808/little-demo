package com.yangzhong.spring.boot.demo.list;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangzhong
 * @Date 2020-12-23 14:45
 * @Description 描述
 */
public class ListTest {

    public static void main(String[] args) {
        // 交集
        List<String> listA_01 = new ArrayList<String>(){{
            add("A");
            add("D");
        }};

        listA_01.add(null);
        listA_01.add(null);

        List<String> listB_01 = new ArrayList<String>(){{
            add("B");
            add("C");
        }};
        listA_01.retainAll(listB_01);

        System.out.println(listA_01); // 结果:[B]
        System.out.println(listB_01); // 结果:[B, C]
        System.out.println(CollectionUtils.isEmpty(listA_01));
    }
}
