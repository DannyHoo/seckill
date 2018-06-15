package com.danny.seckill.dao.mybatis.data.goods;

import com.danny.seckill.dao.mybatis.data.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsDO extends BaseDO {

    private String goodsno;

    private String name;

    private BigDecimal originprice;

    private BigDecimal nowprice;

    private Integer totalnum;

    private Integer balance;

    private String description;

    private String pictureurl;

    private Date seckillbegintime;

    private Date seckillendtime;

    public String getGoodsno() {
        return goodsno;
    }

    public GoodsDO setGoodsno(String goodsno) {
        this.goodsno = goodsno;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsDO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getOriginprice() {
        return originprice;
    }

    public GoodsDO setOriginprice(BigDecimal originprice) {
        this.originprice = originprice;
        return this;
    }

    public BigDecimal getNowprice() {
        return nowprice;
    }

    public GoodsDO setNowprice(BigDecimal nowprice) {
        this.nowprice = nowprice;
        return this;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public GoodsDO setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public GoodsDO setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GoodsDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public GoodsDO setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
        return this;
    }

    public Date getSeckillbegintime() {
        return seckillbegintime;
    }

    public GoodsDO setSeckillbegintime(Date seckillbegintime) {
        this.seckillbegintime = seckillbegintime;
        return this;
    }

    public Date getSeckillendtime() {
        return seckillendtime;
    }

    public GoodsDO setSeckillendtime(Date seckillendtime) {
        this.seckillendtime = seckillendtime;
        return this;
    }

}