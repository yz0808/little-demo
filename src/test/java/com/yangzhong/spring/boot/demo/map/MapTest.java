package com.yangzhong.spring.boot.demo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author yangzhong
 * @Date 2020-11-24 21:02
 * @Description 描述
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Long, Long> splitSkuIdMap = new HashMap<>();
        // splitSkuIdMap.put(1L, 1L);
        splitSkuIdMap.put(2L, null);
        splitSkuIdMap.put(null, 3L);

        Map<Long, Long> collect = splitSkuIdMap.entrySet().stream().filter(e -> e.getKey() != null && e.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect);
    }
}
