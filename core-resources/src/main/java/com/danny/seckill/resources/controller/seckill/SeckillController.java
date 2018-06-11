package com.danny.seckill.resources.controller.seckill;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by danny on 2018/6/7.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @RequestMapping("/index")
    public String index() {
        return "seckill/index";
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
