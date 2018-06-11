package com.danny.seckill.framework.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResultStatusEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 23:10:58
 */
public enum ResultStatusEnum implements ResultStatusEnumInterface {

    //10开头为系统类型
    SUCCESS(100000, "处理成功"),
    //业务失败情况
    FAILURE(100001, "服务器正忙,请稍后重试"),
    //系统出现异常情况
    UNKOWN_SYS_ERROR(100002, "服务器正忙,请稍后重试"),
    //必须的参数为空
    PARAMETER_IS_NULL(100003,"参数为空"),


    USER_ALREADY_EXIST(200000,"用户名已存在"),
    USERNAME_OR_PASSWORD_INVALID(200010,"用户名或密码错误")
    ;

    private int code;
    private String description;

    ResultStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    public ResultStatusEnum setCode(int code) {
        this.code = code;
        return this;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public ResultStatusEnum setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String getName() {
        return this.toString();
    }

    private static Map<Integer, ResultStatusEnum> valueMap = new HashMap<>();

    public static ResultStatusEnum valueOf(int code) {
        if (valueMap.isEmpty()) {
            ResultStatusEnum[] enums = ResultStatusEnum.values();
            for (ResultStatusEnum resultStatusEnum : enums) {
                valueMap.put(resultStatusEnum.getCode(), resultStatusEnum);
            }
        }
        return valueMap.get(code);
    }
}
