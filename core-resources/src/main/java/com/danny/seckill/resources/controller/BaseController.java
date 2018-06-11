package com.danny.seckill.resources.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-01 00:24:04
 */
public class BaseController {

    public String getValueFromRequest(HttpServletRequest request,String paraName){
        if (request.getParameter(paraName)!=null){
            return request.getParameter(paraName).toString();
        }
        return null;
    }
}
