package com.danny.seckill.framework.service;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.model.enums.ResultStatusEnumInterface;

/**
 * @author dannyhoo
 * @Title: CallbackResult
 * @Description:
 * @Created on 2018-05-31 10:20:19
 */
public class CallbackResult {

    /**
     * 可以继续执行，或者提交事务
     */
    public final static int SUCCESS = 1;

    /**
     * 不能继续执行，或者回滚事务
     */
    public final static int FAILURE = -1;

    /**
     * 表征事务状态，默认事务提交
     */
    private int statusCode = SUCCESS;

    /**
     * 代表业务语义的结果代码，主要用在发生回滚，进行异常throw的场景
     */
    private int resultCode = 0;

    /**
     * 结果代码描述
     */
    private String resultCodeMessage;

    /**
     * 发生的异常信息
     */
    private Throwable throwable;

    /**
     * 与该结果关联的业务主体
     */
    private Object businessObject;

    private ResultStatusEnumInterface resultStatus;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Deprecated
    public int getResultCode() {
        return resultCode;
    }

    @Deprecated
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    @Deprecated
    public String getResultCodeMessage() {
        return resultCodeMessage;
    }

    @Deprecated
    public void setResultCodeMessage(String resultCodeMessage) {
        this.resultCodeMessage = resultCodeMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Object getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(Object businessObject) {
        this.businessObject = businessObject;
    }

    public ResultStatusEnumInterface getResultStatus() {
        return resultStatus;
    }

    public CallbackResult setResultStatus(ResultStatusEnumInterface resultStatus) {
        this.resultStatus = resultStatus;
        return this;
    }

    /**
     * @param statusCode
     * @param resultStatus
     * @param throwable
     * @param businessObject
     */
    private CallbackResult(
            int statusCode, ResultStatusEnumInterface resultStatus,
            Throwable throwable, Object businessObject) {
        this.statusCode = statusCode;
        this.resultStatus = resultStatus;
        if (resultStatus != null) {
            this.resultCode = resultStatus.getCode();
            this.resultCodeMessage = resultStatus.getDescription();
        }
        this.businessObject = businessObject;
        this.throwable = throwable;
    }


    /**
     * 直接构造成功状况下的回调结果对象
     *
     * @return
     */
    public static CallbackResult success() {
        return success(ResultStatusEnum.SUCCESS, null);
    }

    /**
     * 直接构造成功状况下的回调结果对象，同时设置业务对象
     *
     * @param businessObject
     * @return
     */
    public static CallbackResult success(Object businessObject) {
        return success(ResultStatusEnum.SUCCESS, businessObject);
    }

    /**
     * 直接构造成功状况下的回调结果对象，同时设置业务代码、业务对象
     *
     * @param resultStatus
     * @param businessObject
     * @return
     */
    private static CallbackResult success(
            ResultStatusEnumInterface resultStatus, Object businessObject) {
        return new CallbackResult(SUCCESS, resultStatus, null, businessObject);
    }


    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常、业务对象
     *
     * @param resultStatus
     * @param throwable
     * @param businessObject
     * @return
     */
    public static CallbackResult failure(
            ResultStatusEnumInterface resultStatus,
            Throwable throwable, Object businessObject) {
        return new CallbackResult(FAILURE, resultStatus, throwable,
                businessObject);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常
     *
     * @param resultStatus
     * @param throwable
     * @return
     */
    public static CallbackResult failure(
            ResultStatusEnumInterface resultStatus,
            Throwable throwable) {
        return new CallbackResult(FAILURE, resultStatus, throwable, null);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码
     *
     * @param resultStatus
     * @return
     */
    public static CallbackResult failure(
            ResultStatusEnumInterface resultStatus) {
        return new CallbackResult(FAILURE, resultStatus, null, null);
    }

    /**
     * 禁止用户直接构造该对象，必须通过业务方法构造
     */
    @Deprecated
    private CallbackResult(int statusCode, int resultCode, Throwable throwable,
                           Object businessObject) {
        this.statusCode = statusCode;
        this.resultCode = resultCode;
        this.resultStatus = ResultStatusEnum.valueOf(resultCode);
        this.throwable = throwable;
        this.businessObject = businessObject;
    }

    /**
     * 禁止用户直接构造该对象，必须通过业务方法构造
     */
    @Deprecated
    private CallbackResult(int statusCode, int resultCode, String resultCodeMessage, Throwable throwable,
                           Object businessObject) {
        this.statusCode = statusCode;
        this.resultCode = resultCode;
        this.resultStatus = ResultStatusEnum.valueOf(resultCode);
        this.resultCodeMessage = resultCodeMessage;
        this.throwable = throwable;
        this.businessObject = businessObject;
    }

    // ------------------ 辅助方法 --------------------------------------

    /**
     * 直接构造成功状况下的回调结果对象，同时设置业务代码
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult success(int resultCode) {
        return success(resultCode, null);
    }

    /**
     * 直接构造成功状况下的回调结果对象，同时设置业务代码、业务对象
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult success(int resultCode, Object businessObject) {
        return new CallbackResult(SUCCESS, resultCode, null, businessObject);
    }

    /**
     * 直接构造成功状况下的回调结果对象，同时设置业务代码、业务对象
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult success(int resultCode, String resultCodeMessage, Object businessObject) {
        return new CallbackResult(SUCCESS, resultCode, resultCodeMessage, null, businessObject);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode) {
        return failure(resultCode, null, null, null);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode, String resultCodeMessage) {
        return failure(resultCode, resultCodeMessage, null, null);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode, Throwable throwable) {
        return failure(resultCode, null, throwable, null);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode, String resultCodeMessage, Throwable throwable) {
        return failure(resultCode, resultCodeMessage, throwable, null);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常、业务对象
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode, Throwable throwable,
                                         Object businessObject) {
        return new CallbackResult(FAILURE, resultCode, null, throwable,
                businessObject);
    }

    /**
     * 直接构造失败状况下的回调结果对象，同时设置业务代码、异常、业务对象
     *
     * @param resultCode
     * @return
     */
    @Deprecated
    public static CallbackResult failure(int resultCode, String resultCodeMessage, Throwable throwable,
                                         Object businessObject) {
        return new CallbackResult(FAILURE, resultCode, resultCodeMessage, throwable,
                businessObject);
    }

    /**
     * 检查服务处理是否成功
     *
     * @return 成功返回true，否则返回false
     */
    public boolean isSuccess() {
        return statusCode == SUCCESS;
    }

    /**
     * 检查服务处理是否失败
     *
     * @return 失败返回true，否则返回false
     */
    public boolean isFailure() {
        return statusCode == FAILURE;
    }

    /**
     * 检查业务对象是否为NULL，以便于外部方法判断是否进行其它处理
     *
     * @return
     */
    public boolean isNullBusinessObject() {
        return null == this.businessObject;
    }


}
