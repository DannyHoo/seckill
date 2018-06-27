package com.danny.seckill.framework.concurrent;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LockImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-27 10:04:17
 */
public class LockImplTest {

    private LockService lockService=new LockServiceImpl();

    @Test
    public void getDistributeLockTest(){
        final Lock lock=lockService.getDistributeLock("");
        final long[] obj = {0};
        for (int i=0;i<=100000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        lock.lockInterruptibly();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj[0]++;
                    lock.unlock();
                }
            }).start();
        }
        System.out.println(obj[0]);
    }
}
