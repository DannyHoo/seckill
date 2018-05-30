package com.danny.seckill.dao.ingegration.jpa.dao.system;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.dao.ingegration.jpa.dao.BaseDaoSpringTest;
import com.danny.seckill.dao.jpa.dao.system.UserDAO;
import com.danny.seckill.dao.jpa.data.system.UserDO;
import com.danny.seckill.dao.mybatis.dao.UserMapper;
import com.danny.seckill.dao.mybatis.data.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAOIntegrationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-29 17:21:28
 */
public class UserDAOIntegrationTest/* extends BaseDaoSpringTest*/ {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback(false)
    public void findTest(){
        UserDO userDOInit=getUserDO();
        UserDO userDOSaved=userDAO.save(userDOInit);
        UserDO userDOFound=userDAO.findOne(userDOSaved.getId());
        Assert.assertNotNull(userDOFound);
        System.out.println("查询结果："+JSON.toJSONString(userDOFound));
    }

    private UserDO getUserDO() {
        UserDO userDO=new UserDO()
                .setMobileNo("13579246810")
                .setUserName("xiaoming")
                .setAddress("北京市东城区安德里北街")
                .setAge(21)
                .setBirthday(new Date())
                .setDistrictId(100000l)
                .setEmail("xiaoming@163.com")
                .setIdCardNo("150910199009094830")
                .setPassword("J8dLlif9n")
                .setPortrait("1000101010010001010010010101001001010010")
                .setRealName("小明")
                .setSalt("c4ca4238a0b923820dcc509a6f75849b")
                .setSex(10)
                .setStatus(10);
        return userDO;
    }
}
