package com.danny.seckill.model.bean.order;

import com.danny.seckill.model.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Order
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:41:41
 */
public class Order extends BaseBean{
    private String orderno;

    private String username;

    private String receiveaddress;

    private Integer paytype;

    private Integer delivertype;

    private Date delivertime;

    private BigDecimal totalprice;

    private BigDecimal cutdownprice;

    private BigDecimal freight;

    private BigDecimal actualprice;

    public String getOrderno() {
        return orderno;
    }

    public Order setOrderno(String orderno) {
        this.orderno = orderno;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Order setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public Order setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
        return this;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public Order setPaytype(Integer paytype) {
        this.paytype = paytype;
        return this;
    }

    public Integer getDelivertype() {
        return delivertype;
    }

    public Order setDelivertype(Integer delivertype) {
        this.delivertype = delivertype;
        return this;
    }

    public Date getDelivertime() {
        return delivertime;
    }

    public Order setDelivertime(Date delivertime) {
        this.delivertime = delivertime;
        return this;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public Order setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BigDecimal getCutdownprice() {
        return cutdownprice;
    }

    public Order setCutdownprice(BigDecimal cutdownprice) {
        this.cutdownprice = cutdownprice;
        return this;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public Order setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public BigDecimal getActualprice() {
        return actualprice;
    }

    public Order setActualprice(BigDecimal actualprice) {
        this.actualprice = actualprice;
        return this;
    }
}
