package com.yangzhong.spring.boot.demo.bigdecimal;

import java.math.BigDecimal;

/**
 * @Author yangzhong
 * @Date 2020-11-19 10:08
 * @Description 描述
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("1.000");
        System.out.println(b1.compareTo(b2) != 0);
    }
}
