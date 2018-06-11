package com.danny.seckill.framework.cache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CacheFactory
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 10:52:08
 */
public class CacheFactory {

    private static Cache cache;

    private CacheFactory() {
    }

    /**
     * 获取缓存操作示例
     *
     * @param cacheTypeEnum 缓存类型
     * @return
     */
    public static Cache getCache(CacheTypeEnum cacheTypeEnum) {
        switch (cacheTypeEnum) {
            case LOCAL_MEMORY_CACHE:
                cache = new LocalMemoryCacheImpl();
            default:
                cache = new LocalMemoryCacheImpl();
        }
        return cache;
    }

    public static Cache getLocalMemoryCache() {
        cache = new LocalMemoryCacheImpl();
        return cache;
    }
}
