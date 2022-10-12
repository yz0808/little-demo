package com.little.demo.jvm;

/**
 * @Author yangzhong
 * @Date 2022-06-09 16:23
 * @Description JvmMemorySize
 */
public class JvmMemorySize {
    public static void main(String[] args) {
        // 系统的最大空间
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        // 系统的空闲空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        // 当前可用的总空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }
}
