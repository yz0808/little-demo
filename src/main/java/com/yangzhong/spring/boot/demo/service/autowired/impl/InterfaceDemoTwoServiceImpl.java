package com.yangzhong.spring.boot.demo.service.autowired.impl;

import com.yangzhong.spring.boot.demo.service.autowired.InterfaceDemoService;
import org.springframework.stereotype.Service;

/**
 * @Author yangzhong
 * @Date 2020-11-11 15:52
 * @Description 描述
 */
@Service
public class InterfaceDemoTwoServiceImpl implements InterfaceDemoService {
    @Override
    public void methodDemo(String str) {
        System.out.println("This is InterfaceDemoTwo!");
    }
}
