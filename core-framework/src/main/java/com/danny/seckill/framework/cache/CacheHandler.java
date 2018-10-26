package com.danny.seckill.framework.cache;

import com.danny.seckill.framework.cache.enums.CacheTypeEnum;

/**
 * @author dannyhoo
 * @Title: CacheHandler
 * @Description:
 * @Created on 2018-06-11 12:55:49
 */
public class CacheHandler {

    private Cache cache;

    public CacheHandler() {
        this.cache = CacheFactory.getCache(CacheTypeEnum.LOCAL_MEMORY_CACHE);
    }

}
