package com.danny.seckill.service.system;

import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 23:03:16
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param userParameter
     * @return
     */
    CommonResult<User> register(UserParameter userParameter);

    /**
     * 用户登录
     *
     * @param userParameter
     * @return
     */
    CommonResult<User> login(UserParameter userParameter);

    CommonResult<User> findByUserName(UserParameter userParameter);

    CommonResult<User> saveUser(UserParameter userParameter);

    CommonResult<User> updateUserByUserName(UserParameter userParameter);

}
