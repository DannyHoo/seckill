package com.danny.seckill.resources.controller.quan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: QuanController
 * @Copyright: Copyright (c) 2016
 * @Description: 优惠券
 * @Company: lxjr.com
 * @Created on 2018-06-29 16:45:58
 */
@Controller
@RequestMapping("/quan")
public class QuanController {

    @RequestMapping("/index")
    public String index(){
        return "quan/pc/index";
    }
}
