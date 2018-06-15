package com.danny.seckill.model.param.seckill;

import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.BaseParameter;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SeckillParameter
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-15 15:37:45
 */
public class SeckillParameter extends BaseParameter {
    private String userName;
    private String goodsNo;

    public String getUserName() {
        return userName;
    }

    public SeckillParameter setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public SeckillParameter setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
        return this;
    }
}
