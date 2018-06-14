package com.danny.seckill.dao.ingegration.mybatis.dao.goods;

import com.alibaba.fastjson.JSON;
import com.danny.seckill.dao.ingegration.mybatis.dao.BaseDaoSpringTest;
import com.danny.seckill.dao.mybatis.dao.goods.GoodsDOMapper;
import com.danny.seckill.dao.mybatis.data.goods.GoodsDO;
import com.danny.seckill.framework.util.DateUtils;
import com.danny.seckill.framework.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GoodsDAOIntegrationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 15:35:52
 */
public class GoodsDAOIntegrationTest extends BaseDaoSpringTest {

    @Autowired
    private GoodsDOMapper goodsDOMapper;

    @Test
    public void addGoodsTest() {
        GoodsDO goodsDO=getGoodsDO();
        goodsDOMapper.insert(goodsDO);
        Assert.assertNull(goodsDO.getId());
        this.print(goodsDO);
    }

    private GoodsDO getGoodsDO() {
        GoodsDO goodsDO = new GoodsDO()
                .setGoodsno("G"+StringUtil.getRandomTimeStr())
                .setName("[可乐相伴 开怀畅饮]可口可乐500ml/瓶")
                .setOriginprice(BigDecimal.valueOf(3))
                .setNowprice(BigDecimal.valueOf(1))
                .setBalance(500)
                .setDescription("缤纷时刻齐分享！可口可乐以其独特的风味和上佳的口感深受大众尤其是年轻人的青睐，与 美食是绝配哦！")
                .setPictureurl("http://140.143.158.164:8080/images/seckill/guangg1.png")
                .setSeckillbegintime(DateUtils.parseDateNewFormat("2018-07-01 12:00:00"))
                .setSeckillendtime(DateUtils.parseDateNewFormat("2018-08-01 12:00:00"));
        return goodsDO;
    }
}
