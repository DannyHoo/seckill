package com.danny.seckill.dao.ingegration.mybatis.dao.system;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.dao.ingegration.mybatis.dao.BaseDaoSpringTest;
import com.danny.seckill.dao.mybatis.dao.system.UserMapper;
import com.danny.seckill.dao.mybatis.data.system.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDODAOIntegrationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-29 17:21:28
 */
public class UserDODAOIntegrationTest extends BaseDaoSpringTest {

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
        UserDO userDOFound = userMapper.selectByPrimaryKey(1l);
        Assert.assertNotNull(userDOFound);
        System.out.println("查询结果：" + JSON.toJSONString(userDOFound));
    }

}
