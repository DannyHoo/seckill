package com.danny.seckill.framework.service;

import com.danny.seckill.framework.concurrent.DefaultLockServiceImpl;
import com.danny.seckill.framework.concurrent.LockService;
import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.locks.Lock;

/**
 * @author dannyhoo
 * @Title: ServiceTemplateImpl
 * @Description:
 * @Created on 2018-05-31 10:45:09
 */
public class ServiceTemplateImpl implements ServiceTemplate {

    private TransactionTemplate transactionTemplate;

    private LockService lockService;

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

    private LockService getLockService() {
        if (this.lockService == null) {
            lockService = new DefaultLockServiceImpl();
        }
        return this.lockService;
    }

    /**
     * 支持事务的模板
     *
     * @param action service执行内容
     * @return
     */
    @Override
    public CallbackResult execute(ServiceCallbackAction action) {
        return executeServiceCallbackAction(action);
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
        Lock lock = null;
        try {
            lock = this.getLockService().getDistributeLock(lockKey);
            lock.lockInterruptibly();
            return executeServiceCallbackAction(action);
        } catch (Exception e) {
            return CallbackResult.failure(ResultStatusEnum.UNKOWN_SYS_ERROR);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
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

    private CallbackResult executeServiceCallbackAction(final ServiceCallbackAction action) {
        CallbackResult callbackResult = CallbackResult.success();
        try {
            //检查入参是否合法
            callbackResult = action.executeCheck();
            //入参合法再执行方法内容，否则直接返回参数检查结果
            if (callbackResult.isSuccess()) {
                callbackResult = (CallbackResult) this.getTransactionTemplate().execute(new TransactionCallback() {
                    @Override
                    public Object doInTransaction(TransactionStatus status) {
                        CallbackResult result = CallbackResult.success();
                        try {
                            result = action.executeAction();
                            if (result.isFailure()) {
                                status.setRollbackOnly();//本地Junit调试时，出现异常时会报错，发布到服务器没问题
                            }
                        } catch (Exception e) {
                            status.setRollbackOnly();
                            throw e;
                        }
                        return result;
                    }
                });
            }
        } catch (Exception e) {
            if(callbackResult.getResultStatus()==null){
                callbackResult.setResultStatus(ResultStatusEnum.UNKOWN_SYS_ERROR);
            }
        }
        return callbackResult;
    }
}
