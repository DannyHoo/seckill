package com.danny.seckill.model.result;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.model.enums.ResultStatusEnumInterface;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author dannyhoo
 * @Title: CommonResult
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:58:01
 */
public class CommonResult<B> implements Externalizable {

    /* 业务处理状态 */
    protected ResultStatusEnumInterface businessResult = null;

    /* 业务处理结果 */
    protected B businessObject = null;

    /* 业务处理异常描述 */
    protected String exceptionMsg = null;

    public CommonResult() {
    }

    public CommonResult(ResultStatusEnumInterface businessResult, B businessObject) {
        this.businessResult = businessResult;
        this.businessObject = businessObject;
    }

    public CommonResult(ResultStatusEnumInterface businessResult, B businessObject, String resultCodeMsg) {
        this.businessResult = businessResult;
        this.businessObject = businessObject;
        this.exceptionMsg = resultCodeMsg;
    }

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return businessResult == ResultStatusEnum.SUCCESS;
    }

    /**
     * 是否失败
     *
     * @return
     */
    public boolean isFailure() {
        return !isSuccess();
    }


    public ResultStatusEnumInterface getBusinessResult() {
        return businessResult;
    }

    public CommonResult setBusinessResult(ResultStatusEnumInterface businessResult) {
        this.businessResult = businessResult;
        return this;
    }

    public B getBusinessObject() {
        return businessObject;
    }

    public CommonResult setBusinessObject(B businessObject) {
        this.businessObject = businessObject;
        return this;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public CommonResult setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
        return this;
    }

    /* 指定序列化字段输出对象 */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(businessResult);
        out.writeObject(businessObject);
        out.writeObject(exceptionMsg);
    }

    /* 指定序列化字段输入对象 */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        businessResult = (ResultStatusEnumInterface) in.readObject();
        businessObject = (B) in.readObject();
        exceptionMsg = (String) in.readObject();
    }
}
