package com.yangzhong.spring.boot.demo.bigdecimal;

import java.math.BigDecimal;

/**
 * @Author yangzhong
 * @Date 2020-11-19 10:08
 * @Description 描述
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("-1.0098");
        System.out.println("正负零：" + amount.signum());
        System.out.println(amount.precision());
        System.out.println(amount.scale());
    }
}
