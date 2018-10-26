package com.danny.seckill.framework.concurrent;

import java.util.concurrent.locks.Lock;

/**
 * @author Danny
 * @Title: DistrbuteRedisLockServiceImpl
 * @Description:
 * @Created on 2018-09-11 17:30:35
 */
public class DistrbuteRedisLockServiceImpl implements LockService {
    @Override
    public Lock getDistributeLock(String lockKey) {
        return null;
    }
}
