package com.little.demo.caffeine.test;

/**
 * @Author yangzhong
 * @Date 2022-10-13 14:40
 * @Description 描述
 */
public class ThisTest {
    public static void main(String[] args) {
        ThisTest test = new ThisTest();
        test.say();
    }

    private void say() {
        System.out.println(ThisTest.this.hello());
    }

    private String hello() {
        return "hello world";
    }
}
