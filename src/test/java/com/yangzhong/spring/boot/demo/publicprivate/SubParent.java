package com.yangzhong.spring.boot.demo.publicprivate;

/**
 * @Author yangzhong
 * @Date 2022-06-04 22:14
 * @Description SubParent
 */
public class SubParent extends Parent{
    public void sub(){
        super.protectedMethod();
        Parent p = new Parent();
        p.protectedMethod();
    }
}
