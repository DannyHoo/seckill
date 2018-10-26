package com.danny.seckill.model.bean.goods;

import com.danny.seckill.model.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Goods
 * @Description:
 * @Created on 2018-06-14 17:41:02
 */
public class Goods extends BaseBean {

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

    public Goods setGoodsno(String goodsno) {
        this.goodsno = goodsno;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getOriginprice() {
        return originprice;
    }

    public Goods setOriginprice(BigDecimal originprice) {
        this.originprice = originprice;
        return this;
    }

    public BigDecimal getNowprice() {
        return nowprice;
    }

    public Goods setNowprice(BigDecimal nowprice) {
        this.nowprice = nowprice;
        return this;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public Goods setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public Goods setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goods setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public Goods setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
        return this;
    }

    public Date getSeckillbegintime() {
        return seckillbegintime;
    }

    public Goods setSeckillbegintime(Date seckillbegintime) {
        this.seckillbegintime = seckillbegintime;
        return this;
    }

    public Date getSeckillendtime() {
        return seckillendtime;
    }

    public Goods setSeckillendtime(Date seckillendtime) {
        this.seckillendtime = seckillendtime;
        return this;
    }
}
