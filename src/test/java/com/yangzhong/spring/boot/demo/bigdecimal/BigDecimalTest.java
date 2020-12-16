package com.yangzhong.spring.boot.demo.bigdecimal;

import java.math.BigDecimal;

/**
 * @Author yangzhong
 * @Date 2020-11-19 10:08
 * @Description 描述
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("11");
        BigDecimal result = a.divide(b, 4, BigDecimal.ROUND_HALF_UP);
        // 0.090909
        System.out.println(result);
        System.out.println(result.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
