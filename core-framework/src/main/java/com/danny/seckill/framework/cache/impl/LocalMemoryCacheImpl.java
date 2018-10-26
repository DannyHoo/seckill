package com.danny.seckill.framework.cache.impl;

import com.danny.seckill.framework.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dannyhoo
 * @Title: LocalMemoryCacheImpl
 * @Description: 本地内存缓存
 * 参考：https://www.oschina.net/code/snippet_55577_3887
 * @Created on 2018-06-11 10:52:56
 */
public class LocalMemoryCacheImpl implements Cache {

    private final Lock lock = new ReentrantLock();
    private final int maxCapacity;//缓存中的键值对的最大值，超过就要放到longterm中，等待被回收
    private final int DEFAULT_MAX_CAPACITY = 1 >> 8;
    private final Map eden;
    private final Map longterm;

    public static void main(String[] args) {
        System.out.println( 1 << 9);
    }
    public <K, V> LocalMemoryCacheImpl() {
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
        this.eden = new ConcurrentHashMap<K, V>(maxCapacity);
        this.longterm = new WeakHashMap<K, V>(maxCapacity);
    }

    public <K, V> LocalMemoryCacheImpl(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.eden = new ConcurrentHashMap<K, V>(maxCapacity);
        this.longterm = new WeakHashMap<K, V>(maxCapacity);
    }

    @Override
    public <K, V> V put(K key, V value) {
        //如果eden中的键值对超过最大值
        if (this.eden.size() > this.maxCapacity) {
            lock.lock();
            try {
                //把eden中所有数据放到longterm中，并清空eden
                this.longterm.putAll(this.eden);
                this.eden.clear();
            } finally {
                lock.unlock();
            }
        }
        return (V) this.eden.put(key, value);
    }

    @Override
    public <K, V> V get(K key, Class<V> clazz) {
        //先在eden中查找
        Object objectValue = this.eden.get(key);
        if (objectValue == null) {
            lock.lock();
            try {
                //如果在eden中不存在，去longterm中查找
                objectValue = this.longterm.get(key);
            } finally {
                lock.unlock();
            }
            if (objectValue != null) {
                //如果在longterm中存在，重新放回eden中
                this.eden.put(key, objectValue);
            } else {
                return null;
            }
        }
        return (V) objectValue;
    }

}
