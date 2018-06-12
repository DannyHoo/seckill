package com.danny.seckill.resources.controller.seckill;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dannyhoo
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-07 10:57:10
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @RequestMapping("/index")
    public String index() {
        return "seckill/index";
    }

    @RequestMapping("/{prefix}")
    public ModelAndView prefix(@PathVariable String prefix){
        ModelAndView modelAndView=new ModelAndView("seckill/"+prefix);
        return modelAndView;
    }

    @RequestMapping("/getdate")
    @ResponseBody
    public JSONObject getDate() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("endtime", "2018-06-30 12:12:12");
        jsonObject.put("nowtime", "2018-06-11 10:30:12");
        return jsonObject;
    }
}
