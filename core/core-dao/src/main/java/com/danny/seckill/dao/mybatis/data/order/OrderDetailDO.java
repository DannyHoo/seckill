package com.danny.seckill.dao.mybatis.data.order;

import com.danny.seckill.dao.mybatis.data.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDO extends BaseDO{

    private String orderno;

    private String goodsno;

    private Integer goodsnum;

    private BigDecimal totalprice;

    private BigDecimal actualprice;

    public String getOrderno() {
        return orderno;
    }

    public OrderDetailDO setOrderno(String orderno) {
        this.orderno = orderno;
        return this;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public OrderDetailDO setGoodsno(String goodsno) {
        this.goodsno = goodsno;
        return this;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public OrderDetailDO setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
        return this;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public OrderDetailDO setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BigDecimal getActualprice() {
        return actualprice;
    }

    public OrderDetailDO setActualprice(BigDecimal actualprice) {
        this.actualprice = actualprice;
        return this;
    }
}