package com.yangzhong.spring.boot.demo.sync;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangzhong
 * @Date 2021-07-07 14:58
 * @Description 描述
 */
@SpringBootTest
public class SyncTest {

    @Test
    public void testSync() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<String> list1 = Lists.newArrayList("1", "2");
        List<String> list2 = Lists.newArrayList("1", "2");

        String str = "abc";
        String str1 = "abc";

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    syncMethod(str);
                }
            });

            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    syncMethod(str1);
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("线程结束");

    }

    public void syncMethod(List<String> str) {
        synchronized (str) {
            System.out.println(str + "  " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void syncMethod(String str) {
        synchronized (str) {
            System.out.println(str + "  " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
