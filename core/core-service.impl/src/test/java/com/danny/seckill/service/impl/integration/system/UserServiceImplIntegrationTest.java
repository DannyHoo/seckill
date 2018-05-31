package com.danny.seckill.service.impl.integration.system;

import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.service.impl.integration.BaseServiceSpringTest;
import com.danny.seckill.service.system.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImplIntegrationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-31 17:22:30
 */
public class UserServiceImplIntegrationTest extends BaseServiceSpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserNameTest(){
        UserParameter userParameter=new UserParameter().setUsername("123");
        CommonResult<User> userCommonResult=userService.findByUserName(userParameter);
        Assert.assertTrue(userCommonResult.isSuccess());
        Assert.assertNotNull(userCommonResult.getBusinessObject());
        this.print(userCommonResult);
    }
}
