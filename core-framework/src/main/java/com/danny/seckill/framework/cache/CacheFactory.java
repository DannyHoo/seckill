package com.danny.seckill.framework.cache;

import com.danny.seckill.framework.cache.enums.CacheTypeEnum;
import com.danny.seckill.framework.cache.impl.LocalMemoryCacheImpl;

/**
 * @author dannyhoo
 * @Title: CacheFactory
 * @Description:
 * @Created on 2018-06-11 10:52:08
 */
public class CacheFactory {

    private static Cache cache;

    private CacheFactory() {
    }

    /**
     * 获取缓存操作示例 默认本地内存缓存
     *
     * @param cacheTypeEnum 缓存类型
     * @return
     */
    public static Cache getCache(CacheTypeEnum cacheTypeEnum) {
        if (cache == null) {
            synchronized (CacheFactory.class) {
                if (cache != null) return cache;
                switch (cacheTypeEnum) {
                    case LOCAL_MEMORY_CACHE:
                        cache = new LocalMemoryCacheImpl();
                    default:
                        cache = new LocalMemoryCacheImpl();
                }
                return cache;
            }
        }
        return cache;
    }

    public static Cache getLocalMemoryCache() {
        cache = new LocalMemoryCacheImpl();
        return cache;
    }
}
