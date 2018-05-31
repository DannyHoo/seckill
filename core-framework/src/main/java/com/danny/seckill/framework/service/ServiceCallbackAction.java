package com.danny.seckill.framework.service;


/**
 * @author huyuyang@lxfintech.com
 * @Title: ServiceCallbackAction
 * @Copyright: Copyright (c) 2016
 * @Description: service执行内容
 * @Company: lxjr.com
 * @Created on 2018-05-31 10:26:04
 */
public interface ServiceCallbackAction {

    /**
     * 服务执行前的检查
     *
     * @return
     */
    public CallbackResult executeCheck();

    /**
     * 服务执行
     *
     * @return
     */
    public CallbackResult executeAction();

}
