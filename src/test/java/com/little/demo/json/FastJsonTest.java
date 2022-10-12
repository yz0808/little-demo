package com.little.demo.json;

import com.alibaba.fastjson.JSON;
import com.little.demo.json.domain.FastJsonDomain;

/**
 * @Author yangzhong
 * @Date 2021-05-13 16:30
 * @Description 描述
 */
public class FastJsonTest {

    public static void main(String[] args) {
        FastJsonDomain domain = new FastJsonDomain();

        domain.setName("yzz");
        domain.setAge(18);
        System.out.println(JSON.toJSONString(domain));
    }
}
