package com.danny.seckill.model.param.goods;

import com.danny.seckill.model.param.BaseParameter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GoodsParameter
 * @Description:
 * @Created on 2018-06-14 17:46:27
 */
public class GoodsParameter extends BaseParameter {
    private String goodsno;

    private String name;

    private BigDecimal originprice;

    private BigDecimal nowprice;

    private Integer balance;

    private String description;

    private String pictureurl;

    private Date seckillbegintime;

    private Date seckillendtime;

    public String getGoodsno() {
        return goodsno;
    }

    public GoodsParameter setGoodsno(String goodsno) {
        this.goodsno = goodsno;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsParameter setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getOriginprice() {
        return originprice;
    }

    public GoodsParameter setOriginprice(BigDecimal originprice) {
        this.originprice = originprice;
        return this;
    }

    public BigDecimal getNowprice() {
        return nowprice;
    }

    public GoodsParameter setNowprice(BigDecimal nowprice) {
        this.nowprice = nowprice;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public GoodsParameter setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GoodsParameter setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public GoodsParameter setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
        return this;
    }

    public Date getSeckillbegintime() {
        return seckillbegintime;
    }

    public GoodsParameter setSeckillbegintime(Date seckillbegintime) {
        this.seckillbegintime = seckillbegintime;
        return this;
    }

    public Date getSeckillendtime() {
        return seckillendtime;
    }

    public GoodsParameter setSeckillendtime(Date seckillendtime) {
        this.seckillendtime = seckillendtime;
        return this;
    }
}
