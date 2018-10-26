package com.danny.seckill.framework.service;

/**
 * @author dannyhoo
 * @Title: ServiceTemplate
 * @Description: service模板
 * @Created on 2018-05-31 10:18:23
 */
public interface ServiceTemplate {

    /**
     * 支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    CallbackResult execute(ServiceCallbackAction action);

    /**
     * 不支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    CallbackResult executeWithoutTransaction(ServiceCallbackAction action);

    /**
     * 具有分布式锁控制且支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    CallbackResult executeDistributeLock(ServiceCallbackAction action,String lockKey);

    /**
     * 具有分布式锁控制且不支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    CallbackResult executeDistributeLockWithoutTransaction(ServiceCallbackAction action,String lockKey);

}
