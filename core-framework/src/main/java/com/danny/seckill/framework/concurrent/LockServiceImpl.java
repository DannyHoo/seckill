package com.danny.seckill.framework.concurrent;

import java.util.concurrent.locks.Lock;

/**
 * @author dannyhoo
 * @Title: LockServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-04 17:31:10
 */
public class LockServiceImpl implements LockService {

    @Override
    public Lock getDistributeLock(String lockKey) {
        return null;
    }
}
