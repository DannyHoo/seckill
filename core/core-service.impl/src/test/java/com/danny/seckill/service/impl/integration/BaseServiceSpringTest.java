package com.danny.seckill.service.impl.integration;

import com.alibaba.fastjson.JSON;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @author dannyhoo
 * @Title: BaseServiceSpringTest
 * @Description:
 * @Created on 2018-05-31 17:21:59
 */
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-service-test.xml"})
public class BaseServiceSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected void print(Object object){
        System.out.println(JSON.toJSONString(object));
    }
}
