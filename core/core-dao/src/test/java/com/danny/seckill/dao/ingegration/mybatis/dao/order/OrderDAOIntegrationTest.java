package com.danny.seckill.dao.ingegration.mybatis.dao.order;

import com.danny.seckill.dao.ingegration.mybatis.dao.BaseDaoSpringTest;
import com.danny.seckill.dao.mybatis.dao.order.OrderDOMapper;
import com.danny.seckill.dao.mybatis.data.order.OrderDO;
import com.danny.seckill.framework.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: OrderDAOIntegrationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 15:34:52
 */
public class OrderDAOIntegrationTest extends BaseDaoSpringTest {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Test
    public void addOrderTest() {
        OrderDO orderDO=getOrder();
        orderDOMapper.insert(orderDO);
        Assert.assertNotNull(orderDO.getId());
        this.print(orderDO);
    }

    private OrderDO getOrder() {
        OrderDO orderDO = new OrderDO()
                .setOrderno("O" + StringUtil.getRandomTimeStr())
                .setReceiveaddress("")
                .setPaytype(10)
                .setDelivertype(10)
                .setDelivertime(new Date())
                .setTotalprice(BigDecimal.valueOf(100))
                .setCutdownprice(BigDecimal.valueOf(10))
                .setFreight(BigDecimal.valueOf(0))
                .setActualprice(BigDecimal.valueOf(90));
        return orderDO;
    }
}
