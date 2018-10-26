package com.danny.seckill.framework.cache.impl;

import com.danny.seckill.framework.cache.Cache;

/**
 * @author dannyhoo
 * @Title: RedisCacheImpl
 * @Description:
 * @Created on 2018-06-11 10:53:06
 */
public class RedisCacheImpl implements Cache {

    @Override
    public <K, V> V put(K key, V Value) {
        return null;
    }

    @Override
    public <K, V> V get(K key, Class<V> clazz) {
        return null;
    }

}
