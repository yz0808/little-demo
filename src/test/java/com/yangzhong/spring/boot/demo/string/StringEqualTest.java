package com.yangzhong.spring.boot.demo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangzhong
 * @Date 2022-04-21 18:24
 * @Description 描述
 */
public class StringEqualTest {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String str = "yangzhong" + i;
            stringList.add(str);
        }

        String aa = "yangzhong0";
        System.out.println(stringList.get(0));
        String bb = stringList.get(0);
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

    }
}
