package com.yangzhong.spring.boot.demo.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangzhong
 * @Date 2021-04-02 16:35
 * @Description 描述
 */
public class ScheduledExecutorTest {

    private ScheduledExecutorService executorService;

    @Test
    public void test() throws InterruptedException {
        ThreadFactoryBuilder builder = new ThreadFactoryBuilder();
        builder.setNameFormat("jmq-pull-%d");
        executorService = new ScheduledThreadPoolExecutor(1, builder.build(), new ThreadPoolExecutor.DiscardPolicy());

        executorService.scheduleWithFixedDelay(() -> execute("1"), 2, 3, TimeUnit.SECONDS);
        // executorService.scheduleWithFixedDelay(() -> execute("2"), 5, 3, TimeUnit.SECONDS);


        while (!executorService.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
        }

    }

    private void execute(String str) {
        System.out.println(Thread.currentThread().getName() + " " + str + " 执行任务:" + new Date());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
