package com.little.demo.caffeine.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @Author yangzhong
 * @Date 2022-10-12 17:59
 * @Description 描述
 */
public class CaffeineTest {
    private static final Cache<String, String> cache = Caffeine.newBuilder()
            .refreshAfterWrite(3, TimeUnit.SECONDS)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .maximumSize(10).build(new CacheLoader<String, String>() {

                @Nullable
                @Override
                public String load(@NonNull String s) throws InterruptedException {
                    Thread.sleep(1000);
                    System.out.println("load...");
                    return "yangzhong";
                }
            });

    public static void main(String[] args) throws InterruptedException {
        cache.put("hello", "hello world!");
        System.out.println("first:" + cache.getIfPresent("hello"));
        Thread.sleep(4000);
        System.out.println("second:" + cache.getIfPresent("hello"));
        Thread.sleep(2000);
        System.out.println("third:" + cache.getIfPresent("hello"));
    }

    // private LoadingCache<String, String> caffeine = Caffeine.newBuilder()
    //         //自定义时间计时器
    //         .expireAfter(new Expiry<String, String>() {
    //
    //             @Override
    //             public long expireAfterCreate(String key, String value, long currentTime) {
    //                 return 0;
    //             }
    //
    //             @Override
    //             public long expireAfterUpdate(String key, String value, long currentTime, long currentDuration) {
    //                 return 0;
    //             }
    //
    //             @Override
    //             public long expireAfterRead(String key, String value, long currentTime, long currentDuration) {
    //                 return 0;
    //             }
    //         })
    //         //上次写入后开始计时
    //         .expireAfterWrite(10, TimeUnit.SECONDS)
    //         //上次访问后开始计时(读写)
    //         .expireAfterAccess(10, TimeUnit.SECONDS)
    //         //写入后就会刷新新值(expireAfterWrite 同步, refreshAfterWriter 异步(返回旧值))
    //         .refreshAfterWrite(10, TimeUnit.SECONDS)
    //         //最大大小
    //         .maximumSize(2)
    //         //key 弱引用 -> 内存溢出前回收
    //         .weakKeys()
    //         //value 弱引用 -> 内存溢出前回收
    //         .weakValues()
    //         //软引用 -> 下次GC时回收
    //         .softValues()
    //         .build(new CacheLoader<String, String>() {
    //
    //             //同步填充
    //             @Override
    //             public String load(@NotNull String key) throws Exception {
    //                 try {
    //                     Thread.sleep(1000);
    //                 } catch (InterruptedException e) {
    //                     e.printStackTrace();
    //                 }
    //                 return "load" + key;
    //             }
    //
    //             //批量填充
    //             @NotNull
    //             @Override
    //             public Map<String, String> loadAll(@NotNull Iterable<? extends String> keys) throws Exception {
    //                 return null;
    //             }
    //
    //             //重新加载
    //             @Override
    //             public String reload(@NotNull String key, @NotNull String oldValue) throws Exception {
    //                 try {
    //                     Thread.sleep(1000);
    //                 } catch (InterruptedException e) {
    //                     e.printStackTrace();
    //                 }
    //                 return "reload" + key;
    //             }
    //
    //         });
}
