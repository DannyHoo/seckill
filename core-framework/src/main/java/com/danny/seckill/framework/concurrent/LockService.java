package com.danny.seckill.framework.concurrent;

import java.util.concurrent.locks.Lock;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LockService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-04 17:31:01
 */
public interface LockService {

    Lock getDistributeLock(String lockKey);

}
