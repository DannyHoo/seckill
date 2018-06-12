package com.danny.seckill.resources.utils;

import com.danny.seckill.model.bean.system.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dannyhoo
 * @Title: SessionUtils
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 15:57:32
 */
public class SessionUtils {

    public static final String SESSION_USER_KEY = "SESSION_USER";


    public static void setUser(HttpServletRequest request, User user) {
        getSession(request).setAttribute(SESSION_USER_KEY, user);
    }

    public static User getUser(HttpServletRequest request) {
        return (User)getSession(request).getAttribute(SESSION_USER_KEY);
    }

    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        return httpSession;
    }
}
