package com.danny.seckill.service.impl;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.model.enums.ResultStatusEnumInterface;
import com.danny.seckill.framework.service.CallbackResult;
import com.danny.seckill.framework.service.ServiceTemplate;
import com.danny.seckill.framework.service.ServiceTemplateImpl;
import com.danny.seckill.framework.util.BeanConvertUtil;
import com.danny.seckill.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.lang.reflect.InvocationTargetException;

/**
 * @author dannyhoo
 * @Title: BaseServiceImpl
 * @Description:
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
        return new CommonResult<B>().setBusinessResult(callbackResult.getResultStatus())
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

    /**
     * 检查入参是否为空
     * 1、如果request为null，返回PARAMETER_IS_NULL(100003,"参数为空")
     * 2、如果request不为null，paramNames为空，检查request的所有字段是否含有空值，如果有，返回PARAMETER_IS_NULL(100003,"参数为空")
     * 3、如果request不为null，paramNames不为空，检查request中在paramNames中的字段是否含有空值，如果有，返回PARAMETER_IS_NULL(100003,"参数为空")
     *
     * @param request
     * @param paramNames
     * @return
     */
    protected CallbackResult getCheckParameterEmptyResult(Object request, String... paramNames){
        if (request == null) {
            return CallbackResult.failure(ResultStatusEnum.PARAMETER_IS_NULL);
        }
        if (paramNames==null){
            paramNames=BeanConvertUtil.getFieldsName(request);
        }
        for (String paramName:paramNames){
            String value= null;
            try {
                value = BeanConvertUtil.getProperty(request,paramName);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (value==null){
                return CallbackResult.failure(ResultStatusEnum.PARAMETER_IS_NULL);
            }
        }
        return CallbackResult.success();
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

    protected CallbackResult getFailureCallbackResult(ResultStatusEnumInterface resultStatusEnumInterface) {
        return CallbackResult.failure(resultStatusEnumInterface);
    }

    protected CallbackResult getUnknowSystemErrorCallbackResult() {
        return CallbackResult.failure(ResultStatusEnum.UNKOWN_SYS_ERROR);
    }
}
