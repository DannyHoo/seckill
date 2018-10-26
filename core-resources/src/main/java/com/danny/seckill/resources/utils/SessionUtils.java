package com.danny.seckill.resources.utils;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.model.bean.system.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dannyhoo
 * @Title: SessionUtils
 * @Description:
 * @Created on 2018-06-11 15:57:32
 */
public class SessionUtils {

    // TODO: 18/10/11 分布式Session

    public static final String USER_INFO_SESSION_ID = "SESSION_USER";

    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        return httpSession;
    }

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request) {
        Object currentUserInfo = request.getSession().getAttribute(USER_INFO_SESSION_ID);
        if (currentUserInfo == null) {
            return null;
        }
        User currentUser = JSON.parseObject(currentUserInfo.toString(), User.class);
        return currentUser;
    }

    /**
     * 向Session中存储当前登录用户
     *
     * @param request
     * @param user
     */
    public static void setCurrentUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(USER_INFO_SESSION_ID, JSON.toJSONString(user));
    }

    /**
     * 从Session中清除当前登录用户
     *
     * @param request
     */
    public static void deleteCurrentUser(HttpServletRequest request) {
        request.getSession().setAttribute(USER_INFO_SESSION_ID, null);
    }

    /**
     * 判断用户是否登录
     *
     * @param request
     * @return
     */
    public static boolean isLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute(USER_INFO_SESSION_ID) != null) {
            return true;
        }
        return false;
    }

}
