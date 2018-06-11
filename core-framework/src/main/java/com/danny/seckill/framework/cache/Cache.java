package com.danny.seckill.framework.cache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Cache
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 10:45:59
 */
public interface Cache {

    public<K,V> V put(K key,V Value);

    public<K,V> V get(K key,Class<V> clazz);

}
