package com.danny.seckill.framework.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dannyhoo
 * @Title: LockServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-04 17:31:10
 */
public class LockServiceImpl implements LockService {

    //单机部署时并不需要分布式锁-standalone；集群部署时需要分布式锁-cluster
    private static final String deployType = System.getProperty("deployType", "standalone");

    private String STANDALONE = "standalone";
    private String CLUSTER = "cluster";

    private static Lock lock;

    @Override
    public Lock getDistributeLock(String lockKey) {
        if (lock != null) {
            return lock;
        }
        if (STANDALONE.equals(deployType)) {
            lock = new ReentrantLock();
        }
        return lock;
    }
}
