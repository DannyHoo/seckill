package com.danny.seckill.resources.controller.seckill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by danny on 2018/6/7.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @RequestMapping("/index")
    public String index(){
        return "seckill/index";
    }

}
