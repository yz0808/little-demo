package com.yangzhong.spring.boot.demo.longt;

/**
 * @Author yangzhong
 * @Date 2021-10-21 20:41
 * @Description 描述
 */
public class LongTest {

    public static void main(String[] args) {
        Long DEFAULT_TENANT_ID = 1L;
        String str = "12345567";
        System.out.println(Long.parseLong(str));

        Long ll = 16L;
        System.out.println(ll.toString());
        System.out.println(DEFAULT_TENANT_ID.equals(ll));
    }
}
