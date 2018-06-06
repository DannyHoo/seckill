package com.danny.seckill.resources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-06 10:57:10
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
