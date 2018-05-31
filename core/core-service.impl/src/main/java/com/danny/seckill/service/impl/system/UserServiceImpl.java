package com.danny.seckill.service.impl.system;

import com.danny.seckill.domain.glue.system.UserGlue;
import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:50:48
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserGlue userGlue;

    @Override
    public CommonResult<User> findByUserName(UserParameter userParameter) {
        //userGlue.saveUser(userParameter);
        User user=userGlue.findByUserName(userParameter.getUsername());
        CommonResult<User> userCommonResult=new CommonResult<>();
        userCommonResult.setBusinessObject(user).setBusinessResult(ResultStatusEnum.SUCCESS);
        return userCommonResult;
    }

    public CommonResult<User> saveUser(UserParameter userParameter) {
        userGlue.saveUser(userParameter);
        User user=userGlue.findByUserName(userParameter.getUsername());
        return null;
    }

    public CommonResult<User> updateUserByUserName(UserParameter userParameter) {
        userGlue.saveUser(userParameter);
        User user=userGlue.findByUserName(userParameter.getUsername());
        return null;
    }
}
