package com.danny.seckill.resources.controller;

import com.danny.seckill.framework.core.PropertyPlaceholder;
import com.danny.seckill.framework.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dannyhoo
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-06 10:57:10
 */
@Controller
public class IndexController {

    @RequestMapping(value={"/","/index"})
    public String index1() {
        String defaultWelcomePage = PropertyPlaceholder.getProperty("defaultWelcomePage");
        if (StringUtil.isNotEmpty(defaultWelcomePage)) {
            return defaultWelcomePage;
        }
        return "index";
    }

}
