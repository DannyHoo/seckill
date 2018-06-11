package com.danny.seckill.framework.cache.enums;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CacheTypeEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 12:59:42
 */
public enum CacheTypeEnum {

    LOCAL_MEMORY_CACHE("LocalMemoryCache","com.danny.seckill.framework.cache.impl.LocalMemoryCacheImpl"),
            ;

    private String cacheName;
    private String implClass;

    CacheTypeEnum(String cacheName, String implClass) {
        this.cacheName = cacheName;
        this.implClass = implClass;
    }

    public String getCacheName() {
        return cacheName;
    }

    public CacheTypeEnum setCacheName(String cacheName) {
        this.cacheName = cacheName;
        return this;
    }

    public String getImplClass() {
        return implClass;
    }

    public CacheTypeEnum setImplClass(String implClass) {
        this.implClass = implClass;
        return this;
    }
}
