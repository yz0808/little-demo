package com.yangzhong.spring.boot.demo.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangzhong
 * @Date 2022-06-04 19:31
 * @Description ThreadPoolName
 */
public class ThreadPoolName {
    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("嘿嘿线程池" + "-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
    }
}
