package com.yangzhong.spring.boot.demo.service.autowired.impl;

import com.yangzhong.spring.boot.demo.service.autowired.InterfaceDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author yangzhong
 * @Date 2020-11-11 15:51
 * @Description 描述
 */
@Service("aaa")
public class InterfaceDemoOneServiceImpl implements InterfaceDemoService {

    @PostConstruct
    public void init(){
        System.out.println("----------init----------");
    }

    @Override
    public void methodDemo(String str) {
        System.out.println("This is InterfaceDemoOne");
    }
}
