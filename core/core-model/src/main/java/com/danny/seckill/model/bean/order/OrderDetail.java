package com.danny.seckill.model.bean.order;

import com.danny.seckill.model.bean.BaseBean;

import java.math.BigDecimal;

/**
 * @author huyuyang@lxfintech.com
 * @Title: OrderDetail
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:42:14
 */
public class OrderDetail extends BaseBean {
    private String orderno;

    private String goodsno;

    private Integer goodsnum;

    private BigDecimal totalprice;

    private BigDecimal actualprice;

    public String getOrderno() {
        return orderno;
    }

    public OrderDetail setOrderno(String orderno) {
        this.orderno = orderno;
        return this;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public OrderDetail setGoodsno(String goodsno) {
        this.goodsno = goodsno;
        return this;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public OrderDetail setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
        return this;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public OrderDetail setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BigDecimal getActualprice() {
        return actualprice;
    }

    public OrderDetail setActualprice(BigDecimal actualprice) {
        this.actualprice = actualprice;
        return this;
    }
}
