package com.yangzhong.spring.boot.demo.spilt;

import java.util.Arrays;

/**
 * @Author yangzhong
 * @Date 2021-11-12 17:33
 * @Description 描述
 */
public class SpiltTest {
    public static void main(String[] args) {
        String str = "1,,3, ,4, ,5, ,,";

        System.out.println(Arrays.toString(str.split(",")));
    }
}
