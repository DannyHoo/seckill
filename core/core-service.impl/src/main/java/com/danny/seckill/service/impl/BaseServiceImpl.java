package com.danny.seckill.service.impl;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.service.CallbackResult;
import com.danny.seckill.framework.service.ServiceTemplate;
import com.danny.seckill.framework.service.ServiceTemplateImpl;
import com.danny.seckill.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:51:30
 */
public class BaseServiceImpl {

    @Autowired
    protected DataSourceTransactionManager jdbcTransactionManager;

    private ServiceTemplate serviceTemplate;

    protected ServiceTemplate getServiceTemplate() {
        if (this.serviceTemplate == null) {
            this.serviceTemplate = new ServiceTemplateImpl(jdbcTransactionManager);
        }
        return this.serviceTemplate;
    }


    /**
     * 根据执行结果CallbackResult组装service返回结果CommonResult<B>
     *
     * @param callbackResult
     * @param <B>
     * @return
     */
    protected <B> CommonResult<B> getCommonResult(CallbackResult callbackResult) {
        return new CommonResult<>().setBusinessResult(callbackResult.getResultStatus())
                .setBusinessObject((B) callbackResult.getBusinessObject())
                .setExceptionMsg(this.getExceptionMsg(callbackResult));
    }

    /**
     * 获取执行结果异常描述
     *
     * @param callbackResult
     * @return
     */
    private String getExceptionMsg(CallbackResult callbackResult) {
        if (callbackResult == null) {
            return null;
        }
        if (callbackResult.getThrowable() != null) {
            return callbackResult.getThrowable().getMessage();
        }
        return null;
    }

    protected CallbackResult getSuccessCallbackResult() {
        return CallbackResult.success();
    }

    protected CallbackResult getSuccessCallbackResult(Object object) {
        return CallbackResult.success(object);
    }

    protected CallbackResult getFailureCallbackResult() {
        return CallbackResult.failure(ResultStatusEnum.FAILURE);
    }
}
