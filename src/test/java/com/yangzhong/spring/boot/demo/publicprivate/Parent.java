package com.yangzhong.spring.boot.demo.publicprivate;

/**
 * @Author yangzhong
 * @Date 2022-06-04 22:13
 * @Description Parent
 */
public class Parent {

    private void privateMethod(){
        System.out.println("privateMethod");
    }

    public void publicMethod(){
        System.out.println("publicMethod");
    }

    protected void protectedMethod(){
        System.out.println("protectedMethod");
    }
}
