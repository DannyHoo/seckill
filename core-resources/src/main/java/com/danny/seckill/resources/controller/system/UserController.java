package com.danny.seckill.resources.controller.system;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.resources.controller.BaseController;
import com.danny.seckill.resources.controller.IndexController;
import com.danny.seckill.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-01 00:24:14
 */
@RequestMapping("/user/")
@Controller
public class UserController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String index(HttpServletRequest request){
        logger.info("===========新增用户-controller===========");
        UserParameter userParameter=new UserParameter()
                .setUsername("xiaobianzi")
                .setAge(12)
                .setAddress("北京市")
                .setBirthday(new Date())
                .setEmail("xiaobianzi@126.com");
        CommonResult<User> userCommonResult=userService.saveUser(userParameter);
        System.out.println(JSON.toJSONString(userCommonResult));
        return "system/user";
    }
}
