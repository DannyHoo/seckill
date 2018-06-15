package com.danny.seckill.dao.mybatis.data.order;

import com.danny.seckill.dao.mybatis.data.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDO extends BaseDO{

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

    public OrderDO setOrderno(String orderno) {
        this.orderno = orderno;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public OrderDO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public OrderDO setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
        return this;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public OrderDO setPaytype(Integer paytype) {
        this.paytype = paytype;
        return this;
    }

    public Integer getDelivertype() {
        return delivertype;
    }

    public OrderDO setDelivertype(Integer delivertype) {
        this.delivertype = delivertype;
        return this;
    }

    public Date getDelivertime() {
        return delivertime;
    }

    public OrderDO setDelivertime(Date delivertime) {
        this.delivertime = delivertime;
        return this;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public OrderDO setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BigDecimal getCutdownprice() {
        return cutdownprice;
    }

    public OrderDO setCutdownprice(BigDecimal cutdownprice) {
        this.cutdownprice = cutdownprice;
        return this;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public OrderDO setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public BigDecimal getActualprice() {
        return actualprice;
    }

    public OrderDO setActualprice(BigDecimal actualprice) {
        this.actualprice = actualprice;
        return this;
    }
}