package com.danny.seckill.dao.ingegration.mybatis.dao.system;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.dao.ingegration.mybatis.dao.BaseDaoSpringTest;
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
public class UserDAOIntegrationTest extends BaseDaoSpringTest {

    @Autowired
    private UserMapper userMapper;

    /*
    private ApplicationContext context;
    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("/dal/mybatis/applicationContext-mybatis.xml");
        if (context!=null){
            userMapper=(UserMapper) context.getBean("userMapper");
        }
    }*/

    @Test
    @Rollback
    public void mybatisFindTest() {
        User userFound = userMapper.selectByPrimaryKey(1l);
        Assert.assertNotNull(userFound);
        System.out.println("查询结果：" + JSON.toJSONString(userFound));
    }

}
