package com.danny.seckill.framework.concurrent;

import java.util.concurrent.locks.Lock;

/**
 * @author dannyhoo
 * @Title: LockService
 * @Description:
 * @Created on 2018-06-04 17:31:01
 */
public interface LockService {

    Lock getDistributeLock(String lockKey);

}
