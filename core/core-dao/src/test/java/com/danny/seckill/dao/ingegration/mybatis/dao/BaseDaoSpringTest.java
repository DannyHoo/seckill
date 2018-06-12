package com.danny.seckill.dao.ingegration.mybatis.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dannyhoo
 * @Title: BaseDaoSpringTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:42:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-dao-test.xml"})
public abstract class BaseDaoSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
    public void fail(Exception e) {
        e.printStackTrace();
        Assert.fail(e.getMessage());
    }

    public void fail(String message) {
        Assert.fail(message);
    }

    public void print(String message, Object... objects) {
        message = MessageFormatter.arrayFormat(message, objects).getMessage();
        System.out.println(message);
    }

    /**
     * 随机生成指定位数的数字与字母相结合
     *
     * @param bit
     * @return
     */
    protected String generateAlphanumeric(int bit) {
        return RandomStringUtils.randomAlphanumeric(bit);
    }
}

