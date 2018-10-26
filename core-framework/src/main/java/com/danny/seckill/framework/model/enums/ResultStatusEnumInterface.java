package com.danny.seckill.framework.model.enums;

/**
 * @author dannyhoo
 * @Title: ResultStatusEnumInterface
 * @Description:
 * @Created on 2018-05-30 23:11:16
 */
public interface ResultStatusEnumInterface {

    /**
     * 获取返回结果code
     *
     * @return
     */
    public int getCode();

    /**
     * 获取返回结果code对应描述
     *
     * @return
     */
    public String getDescription();

    /**
     * 获取枚举值对应名称
     *
     * @return
     */
    public String getName();

}
