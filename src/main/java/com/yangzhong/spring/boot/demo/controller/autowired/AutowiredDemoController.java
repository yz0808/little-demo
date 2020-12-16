package com.yangzhong.spring.boot.demo.controller.autowired;

import com.yangzhong.spring.boot.demo.service.autowired.InterfaceDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author yangzhong
 * @Date 2020-11-11 15:54
 * @Description 描述
 */
@RestController
@RequestMapping("/autowired")
public class AutowiredDemoController {

    // @Resource(name = "aaa")
    // private InterfaceDemoService interfaceDemoService;

    @RequestMapping("/hello")
    public String hello() {
        return "123";
    }
}
