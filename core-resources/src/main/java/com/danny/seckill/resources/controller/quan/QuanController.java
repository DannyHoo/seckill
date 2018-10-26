package com.danny.seckill.resources.controller.quan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: QuanController
 * @Description: 优惠券
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
