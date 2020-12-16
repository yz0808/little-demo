package com.yangzhong.spring.boot.demo.service;

import com.yangzhong.spring.boot.demo.service.autowired.InterfaceDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yangzhong
 * @Date 2020-11-11 16:02
 * @Description 描述
 */
@SpringBootTest
public class MultiImplServiceTest {

    @Autowired
    private InterfaceDemoService aaa;

    @Autowired
    @Qualifier("aaa")
    private InterfaceDemoService interfaceDemoService;

    @Resource(name = "interfaceDemoTwoServiceImpl")
    private InterfaceDemoService interfaceDemoService123;

    @Autowired
    private List<InterfaceDemoService> interfaceDemoServiceList;

    @Resource
    private List<InterfaceDemoService> resourceList;

    @Test
    public void test1() {
        System.out.println("===================");
        aaa.methodDemo("");
        System.out.println("===================");

        interfaceDemoService.methodDemo("");
        System.out.println("===================");

        interfaceDemoService123.methodDemo("");
        System.out.println("===================");

        System.out.println(interfaceDemoServiceList.size());
        System.out.println("===================");

        System.out.println(resourceList.size());
        System.out.println("===================");
    }
}
