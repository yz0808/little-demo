package com.yangzhong.spring.boot.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangzhong
 * @Date 2020-11-25 18:10
 * @Description 描述
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        poolExecutor.execute(() -> helloWorld("execute"));
        // poolExecutor.submit(() -> helloWorld("submit"));
        poolExecutor.shutdown();
    }

    public static void helloWorld(String str) {
        System.out.println("threadName:" + Thread.currentThread().getName() + " 执行方式:" + str);
        throw new RuntimeException("跑异常啦！！！");
    }
}
