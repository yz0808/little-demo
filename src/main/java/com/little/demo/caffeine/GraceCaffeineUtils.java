package com.little.demo.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Author yangzhong
 * @Date 2022-10-13 10:53
 * @Description 描述
 */
public class GraceCaffeineUtils {
    private final LoadingCache<String, String> cache1 = Caffeine.newBuilder()
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(key -> {
                return loadCache1(key);
            });

    private final LoadingCache<String, String> cache2 = Caffeine.newBuilder()
            .refreshAfterWrite(3, TimeUnit.SECONDS)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(this::loadCache2);

    public enum CacheWrapper{

    }

    public static void main(String[] args) throws InterruptedException {
        GraceCaffeineUtils caffeine = new GraceCaffeineUtils();
        caffeine.putCache1("yangzhong", "hello");
        Thread.sleep(2000L);
        String yangzhong = caffeine.getCache1("yangzhong");
        System.out.println("result:" + yangzhong);
    }

    private String getCache1(String key) {
        return cache1.get(key, new Function<String, String>() {
            @Override
            public String apply(String key) {
                System.out.println("getCache1 start key:" + key);
                return "getCache1 result";
            }
        });
    }

    private void putCache1(String key, String value) {
        cache1.put(key, value);
    }

    private String loadCache1(String key) {
        System.out.println("loadCache1 start key:" + key);
        return "loadCache1 result";
    }

    private String loadCache2(String key) {
        System.out.println("loadCache2 start key:" + key);
        return "loadCache2";
    }

}
