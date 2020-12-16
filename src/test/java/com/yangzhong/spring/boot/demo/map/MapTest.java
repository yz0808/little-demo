package com.yangzhong.spring.boot.demo.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yangzhong
 * @Date 2020-11-24 21:02
 * @Description 描述
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putAll(new HashMap<>(5));
        System.out.println(map.size());
    }
}
