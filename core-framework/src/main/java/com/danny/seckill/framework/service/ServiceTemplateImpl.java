package com.danny.seckill.framework.service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ServiceTemplateImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-31 10:45:09
 */
public class ServiceTemplateImpl implements ServiceTemplate {

    /**
     * 支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult execute(ServiceCallbackAction action) {
        return null;
    }

    /**
     * 不支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult executeWithoutTransaction(ServiceCallbackAction action) {
        return null;
    }

    /**
     * 具有分布式锁控制且支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult executeDistributeLock(ServiceCallbackAction action, String lockKey) {
        return null;
    }

    /**
     * 具有分布式锁控制且不支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult executeDistributeLockWithoutTransaction(ServiceCallbackAction action, String lockKey) {
        return null;
    }
}
