package com.little.demo.string;

/**
 * @Author yangzhong
 * @Date 2021-02-22 15:29
 * @Description 描述
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        String str = null;
        StringBuilder sb = new StringBuilder();
        sb.append("q23");
        sb.append(str);
        System.out.println(sb.toString());
    }
}
