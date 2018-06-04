package com.danny.seckill.framework.service;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ServiceTemplateImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-31 10:45:09
 */
public class ServiceTemplateImpl implements ServiceTemplate {

    private TransactionTemplate transactionTemplate;

    public ServiceTemplateImpl(PlatformTransactionManager platformTransactionManager) {
        if (transactionTemplate == null) {
            this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
        }
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private TransactionTemplate getTransactionTemplate() {
        return this.transactionTemplate;
    }

    /**
     * 支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult execute(final ServiceCallbackAction action) {
        CallbackResult callbackResult = CallbackResult.success();
        try {
            //检查入参是否合法
            callbackResult = action.executeCheck();
            //入参合法再执行方法内容，否则直接返回参数检查结果
            if (callbackResult.isSuccess()) {
                callbackResult = (CallbackResult) this.getTransactionTemplate().execute(new TransactionCallback() {
                    @Override
                    public Object doInTransaction(TransactionStatus status) {
                        CallbackResult result= CallbackResult.success();
                        try{
                            result = action.executeAction();
                            if (result.isFailure()) {
                                status.setRollbackOnly();
                            }
                        }catch (Exception e){
                            status.setRollbackOnly();
                            throw e;
                        }
                        return result;
                    }
                });
            }
        } catch (Exception e) {
            return CallbackResult.failure(ResultStatusEnum.UNKOWN_SYS_ERROR);
        }
        return callbackResult;
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
