package com.danny.seckill.resources.controller.system;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.util.StringUtil;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.resources.controller.BaseController;
import com.danny.seckill.resources.response.ResponseData;
import com.danny.seckill.resources.utils.SessionUtils;
import com.danny.seckill.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Date;

/**
 * @author dannyhoo
 * @Title: UserController
 * @Description:
 * @Created on 2018-06-01 00:24:14
 */
@RequestMapping("/user/")
@Controller
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "system/register";
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public ResponseData doRegister(HttpServletRequest request) {
        String email = getValueFromRequest(request, "email");
        String userName = getValueFromRequest(request, "userName");
        String password = getValueFromRequest(request, "password");
        if (StringUtil.hasOneEmpty(email, userName, password)) {
            return ResponseData.newResponseData(ResultStatusEnum.PARAMETER_IS_NULL);
        }
        UserParameter userParameter = new UserParameter()
                .setEmail(email).setUsername(userName).setPassword(password);
        CommonResult<User> loginResult = userService.register(userParameter);
        if (loginResult.isSuccess()) {
            SessionUtils.setCurrentUser(request, loginResult.getBusinessObject());
        }
        return ResponseData.newResponseData(loginResult);
    }

    public static void main(String[] args) {
        char cha[] = {'a','2','3','f'};
        if (cha instanceof char[]){
            System.out.println(cha.getClass());

        }
    }
    @RequestMapping("/login")
    public String login() {
        return "system/login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseData doLogin(HttpServletRequest request) {
        String userName = getValueFromRequest(request, "userName");
        String password = getValueFromRequest(request, "password");
        if (StringUtil.hasOneEmpty(userName, password)) {
            return ResponseData.newResponseData(ResultStatusEnum.PARAMETER_IS_NULL);
        }
        UserParameter userParameter = new UserParameter()
                .setUsername(userName).setPassword(password);
        CommonResult<User> loginResult = userService.login(userParameter);
        if (loginResult.isSuccess()) {
            SessionUtils.setCurrentUser(request, loginResult.getBusinessObject());
        }
        return ResponseData.newResponseData(loginResult);
    }
}
