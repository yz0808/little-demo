package com.little.demo.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author yangzhong
 * @Date 2022-10-12 17:04
 * @Description Caffeine工具累
 */
@Slf4j
public class CaffeineUtils {

    public enum CacheWrapper {
        storeSkuBatch(storeSkuBatchMaximumSize, storeSkuBatchDuration, TimeUnit.SECONDS),
        areaSkuStatusBatch(areaSkuStatusBatchMaximumSize, areaSkuStatusBatchDuration, TimeUnit.SECONDS),
        storeSkuStatusBatch(storeSkuStatusBatchMaximumSize, storeSkuStatusBatchDuration, TimeUnit.SECONDS),
        skuImagesBatch(skuImagesBatchMaximumSize, skuImagesBatchDuration, TimeUnit.SECONDS),
        categoryAttrBatch(categoryAttrBatchMaximumSize, categoryAttrBatchDuration, TimeUnit.SECONDS),
        storeSkuRelationBatch(storeSkuRelationBatchMaximumSize, storeSkuRelationBatchDuration, TimeUnit.SECONDS),
        mainSkuIdBatch(mainSkuIdBatchMaximumSize, mainSkuIdBatchDuration, TimeUnit.SECONDS),
        freshSkuIdBatch(freshSkuIdBatchMaximumSize, freshSkuIdBatchDuration, TimeUnit.SECONDS),
        freshCategoryIdBatch(freshCategoryIdBatchMaximumSize, freshCategoryIdBatchDuration, TimeUnit.SECONDS),
        storeSkuCenterBatch(storeSkuCenterBatchMaximumSize, storeSkuCenterBatchDuration, TimeUnit.SECONDS),
        skuCenterBatch(skuCenterBatchMaximumSize, skuCenterBatchDuration, TimeUnit.SECONDS),
        skuImagesCenterBatch(skuImagesCenterBatchMaximumSize, skuImagesCenterBatchDuration, TimeUnit.SECONDS),
        categoryAttrCenterBatch(categoryAttrCenterBatchMaximumSize, categoryAttrCenterBatchDuration, TimeUnit.SECONDS);

        Cache cache;

        CacheWrapper(int maximumSize, int duration, TimeUnit timeUnit) {
            cache = Caffeine.newBuilder()
                    .expireAfterWrite(duration, timeUnit)
                    .maximumSize(maximumSize)
                    .build();
        }

        public void clearAll() {
            try {
                cache.invalidateAll();
                log.warn("cache {} clearAll", this.name());
            } catch (Exception e) {
                log.error("清空缓存中所有数据", e);
            }
        }

        public <K, V> void put(K k, V v) {
            try {
                cache.put(buildKey(k), v);
            } catch (Exception e) {
                log.error("occurred error when put value from cache,params:k:{};v:{}", k, v, e);
                throw e;
            }
        }

        public <K, V> V get(K k) {
            try {
                Object value = cache.getIfPresent(buildKey(k));
                if (Objects.isNull(value)) {//ump即为内存命中率

                }
                return value == null ? null : (V) value;
            } catch (Exception e) {
                log.error("occurred error when getIfPresent value from cache,params:[key:{}]", k, e);
                throw e;
            } finally {
            }
        }

        public <K, V> void putAll(Map<K, V> kvMap) {
            Map<String, V> stringKeyMap = kvMap.entrySet().stream().
                    filter(entry -> Objects.nonNull(entry.getValue())).
                    collect(Collectors.toMap(entry -> buildKey(entry.getKey()), entry -> entry.getValue()));
            try {
                cache.putAll(stringKeyMap);
            } catch (Exception e) {
                log.error("occurred error when put value from cache,params:kvMap:{}", stringKeyMap, e);
                throw e;
            }
        }

        public <K, V> Map<K, V> getAll(Set<K> keys) {
            try {
                List<String> realKeys = keys.stream().map(key -> buildKey(key)).collect(Collectors.toList());
                Map keyValMap = cache.getAllPresent(realKeys);
                Map<K, V> resultMap = new HashMap<>();
                for (K key : keys) {
                    try {
                        V value = (V) keyValMap.get(buildKey(key));
                        if (Objects.isNull(value)) {

                            continue;
                        }
                        resultMap.put(key, value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
                return resultMap;
            } catch (Exception e) {
                log.error("occurred error when getAllPresent value from cache,params:[key:{}]", keys, e);
                throw e;
            }
        }

        private <K> String buildKey(K key) {
            return this.name() + "_" + key;
        }

        public <K> void delete(K k) {
            try {
                cache.invalidate(buildKey(k));
            } catch (Exception e) {
                log.error("occurred error when delete value from cache,params:k:{}", k, e);
                throw e;
            }
        }

    }

    private static Integer storeSkuBatchMaximumSize;
    private static Integer storeSkuBatchDuration;
    private static Integer areaSkuStatusBatchMaximumSize;
    private static Integer areaSkuStatusBatchDuration;
    private static Integer storeSkuStatusBatchMaximumSize;
    private static Integer storeSkuStatusBatchDuration;
    private static Integer skuImagesBatchMaximumSize;
    private static Integer skuImagesBatchDuration;
    private static Integer categoryAttrBatchMaximumSize;
    private static Integer categoryAttrBatchDuration;
    private static Integer storeSkuRelationBatchMaximumSize;
    private static Integer storeSkuRelationBatchDuration;
    private static Integer mainSkuIdBatchMaximumSize;
    private static Integer mainSkuIdBatchDuration;
    private static Integer freshCategoryIdBatchMaximumSize;
    private static Integer freshCategoryIdBatchDuration;
    private static Integer freshSkuIdBatchMaximumSize;
    private static Integer freshSkuIdBatchDuration;
    private static Integer storeSkuCenterBatchMaximumSize;
    private static Integer storeSkuCenterBatchDuration;
    private static Integer skuCenterBatchMaximumSize;
    private static Integer skuCenterBatchDuration;
    private static Integer skuImagesCenterBatchMaximumSize;
    private static Integer skuImagesCenterBatchDuration;
    private static Integer categoryAttrCenterBatchMaximumSize;
    private static Integer categoryAttrCenterBatchDuration;

    @Value("${store.sku.batch.caffeine.maximumSize}")
    public void setStoreSkuBatchMaximumSize(Integer storeSkuBatchMaximumSize) {
        CaffeineUtils.storeSkuBatchMaximumSize = storeSkuBatchMaximumSize;
    }

    @Value("${store.sku.batch.caffeine.duration}")
    public void setStoreSkuBatchDuration(Integer storeSkuBatchDuration) {
        CaffeineUtils.storeSkuBatchDuration = storeSkuBatchDuration;
    }

    @Value("${area.sku.status.batch.caffeine.maximumSize}")
    public void setAreaSkuStatusBatchMaximumSize(Integer areaSkuStatusBatchMaximumSize) {
        CaffeineUtils.areaSkuStatusBatchMaximumSize = areaSkuStatusBatchMaximumSize;
    }

    @Value("${area.sku.status.batch.caffeine.duration}")
    public void setAreaSkuStatusBatchDuration(Integer areaSkuStatusBatchDuration) {
        CaffeineUtils.areaSkuStatusBatchDuration = areaSkuStatusBatchDuration;
    }

    @Value("${store.sku.status.batch.caffeine.maximumSize}")
    public void setStoreSkuStatusBatchMaximumSize(Integer storeSkuStatusBatchMaximumSize) {
        CaffeineUtils.storeSkuStatusBatchMaximumSize = storeSkuStatusBatchMaximumSize;
    }

    @Value("${store.sku.status.batch.caffeine.duration}")
    public void setStoreSkuStatusBatchDuration(Integer storeSkuStatusBatchDuration) {
        CaffeineUtils.storeSkuStatusBatchDuration = storeSkuStatusBatchDuration;
    }

    @Value("${sku.images.batch.caffeine.maximumSize}")
    public void setSkuImagesBatchMaximumSize(Integer skuImagesBatchMaximumSize) {
        CaffeineUtils.skuImagesBatchMaximumSize = skuImagesBatchMaximumSize;
    }

    @Value("${sku.images.batch.caffeine.duration}")
    public void setSkuImagesBatchDuration(Integer skuImagesBatchDuration) {
        CaffeineUtils.skuImagesBatchDuration = skuImagesBatchDuration;
    }

    @Value("${category.attr.batch.caffeine.maximumSize}")
    public void setCategoryAttrBatchMaximumSize(Integer categoryAttrBatchMaximumSize) {
        CaffeineUtils.categoryAttrBatchMaximumSize = categoryAttrBatchMaximumSize;
    }

    @Value("${category.attr.batch.caffeine.duration}")
    public void setCategoryAttrBatchDuration(Integer categoryAttrBatchDuration) {
        CaffeineUtils.categoryAttrBatchDuration = categoryAttrBatchDuration;
    }

    @Value("${store.sku.relation.batch.caffeine.maximumSize}")
    public void setStoreSkuRelationBatchMaximumSize(Integer storeSkuRelationBatchMaximumSize) {
        CaffeineUtils.storeSkuRelationBatchMaximumSize = storeSkuRelationBatchMaximumSize;
    }

    @Value("${store.sku.relation.batch.caffeine.duration}")
    public void setStoreSkuRelationBatchDuration(Integer storeSkuRelationBatchDuration) {
        CaffeineUtils.storeSkuRelationBatchDuration = storeSkuRelationBatchDuration;
    }

    @Value("${main.skuId.batch.caffeine.maximumSize}")
    public void setMainSkuIdBatchMaximumSize(Integer mainSkuIdBatchMaximumSize) {
        CaffeineUtils.mainSkuIdBatchMaximumSize = mainSkuIdBatchMaximumSize;
    }

    @Value("${main.skuId.batch.caffeine.duration}")
    public void setMainSkuIdBatchDuration(Integer mainSkuIdBatchDuration) {
        CaffeineUtils.mainSkuIdBatchDuration = mainSkuIdBatchDuration;
    }

    @Value("${fresh.categoryId.batch.caffeine.maximumSize}")
    public void setFreshCategoryIdBatchMaximumSize(Integer freshCategoryIdBatchMaximumSize) {
        CaffeineUtils.freshCategoryIdBatchMaximumSize = freshCategoryIdBatchMaximumSize;
    }

    @Value("${fresh.categoryId.batch.caffeine.duration}")
    public void setFreshCategoryIdBatchDuration(Integer freshCategoryIdBatchDuration) {
        CaffeineUtils.freshCategoryIdBatchDuration = freshCategoryIdBatchDuration;
    }

    @Value("${fresh.skuId.batch.caffeine.maximumSize}")
    public void setFreshSkuIdBatchMaximumSize(Integer freshSkuIdBatchMaximumSize) {
        CaffeineUtils.freshSkuIdBatchMaximumSize = freshSkuIdBatchMaximumSize;
    }

    @Value("${fresh.skuId.batch.caffeine.duration}")
    public void setFreshSkuIdBatchDuration(Integer freshSkuIdBatchDuration) {
        CaffeineUtils.freshSkuIdBatchDuration = freshSkuIdBatchDuration;
    }

    @Value("${store.sku.center.batch.caffeine.maximumSize}")
    public void setStoreSkuCenterBatchMaximumSize(Integer storeSkuCenterBatchMaximumSize) {
        CaffeineUtils.storeSkuCenterBatchMaximumSize = storeSkuCenterBatchMaximumSize;
    }

    @Value("${store.sku.center.batch.caffeine.duration}")
    public void setStoreSkuCenterBatchDuration(Integer storeSkuCenterBatchDuration) {
        CaffeineUtils.storeSkuCenterBatchDuration = storeSkuCenterBatchDuration;
    }

    @Value("${sku.center.batch.caffeine.maximumSize}")
    public void setSkuCenterBatchMaximumSize(Integer skuCenterBatchMaximumSize) {
        CaffeineUtils.skuCenterBatchMaximumSize = skuCenterBatchMaximumSize;
    }

    @Value("${sku.center.batch.caffeine.duration}")
    public void setSkuCenterBatchDuration(Integer skuCenterBatchDuration) {
        CaffeineUtils.skuCenterBatchDuration = skuCenterBatchDuration;
    }

    @Value("${sku.images.center.batch.caffeine.maximumSize}")
    public void setSkuImagesCenterBatchMaximumSize(Integer skuImagesCenterBatchMaximumSize) {
        CaffeineUtils.skuImagesCenterBatchMaximumSize = skuImagesCenterBatchMaximumSize;
    }

    @Value("${sku.images.center.batch.caffeine.duration}")
    public void setSkuImagesCenterBatchDuration(Integer skuImagesCenterBatchDuration) {
        CaffeineUtils.skuImagesCenterBatchDuration = skuImagesCenterBatchDuration;
    }

    @Value("${category.attr.center.batch.caffeine.maximumSize}")
    public void setCategoryAttrCenterBatchMaximumSize(Integer categoryAttrCenterBatchMaximumSize) {
        CaffeineUtils.categoryAttrCenterBatchMaximumSize = categoryAttrCenterBatchMaximumSize;
    }

    @Value("${category.attr.center.batch.caffeine.duration}")
    public void setCategoryAttrCenterBatchDuration(Integer categoryAttrCenterBatchDuration) {
        CaffeineUtils.categoryAttrCenterBatchDuration = categoryAttrCenterBatchDuration;
    }
}
