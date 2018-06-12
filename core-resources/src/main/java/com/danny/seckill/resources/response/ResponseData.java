package com.danny.seckill.resources.response;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.model.enums.ResultStatusEnumInterface;
import com.danny.seckill.model.result.CommonResult;

/**
 * @author dannyhoo
 * @Title: ResponseData
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 14:18:21
 */
public class ResponseData {
    private int code;
    private String message;
    private Object data;

    public ResponseData(ResultStatusEnumInterface resultStatusEnumInterface,Object data) {
        if(resultStatusEnumInterface==null){
            resultStatusEnumInterface= ResultStatusEnum.UNKOWN_SYS_ERROR;
        }
        this.code=resultStatusEnumInterface.getCode();
        this.message=resultStatusEnumInterface.getDescription();
        this.data=data;
    }

    public static ResponseData newResponseData(ResultStatusEnumInterface resultStatusEnumInterface) {
        return new ResponseData(resultStatusEnumInterface,null);
    }

    public static ResponseData newResponseData(ResultStatusEnumInterface resultStatusEnumInterface,Object data) {
        return new ResponseData(resultStatusEnumInterface,data);
    }

    public static ResponseData newResponseData(CommonResult commonResult) {
        return new ResponseData(commonResult.getBusinessResult(),commonResult.getBusinessObject());
    }

    public int getCode() {
        return code;
    }

    public ResponseData setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseData setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseData setData(Object data) {
        this.data = data;
        return this;
    }
}
