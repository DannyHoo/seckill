package com.danny.seckill.dao.mybatis.data.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderNo =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderNo <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderNo >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderNo >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderNo <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderNo <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderNo like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderNo not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderNo in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderNo not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderNo between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderNo not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIsNull() {
            addCriterion("receiveAddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIsNotNull() {
            addCriterion("receiveAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressEqualTo(String value) {
            addCriterion("receiveAddress =", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotEqualTo(String value) {
            addCriterion("receiveAddress <>", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressGreaterThan(String value) {
            addCriterion("receiveAddress >", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiveAddress >=", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLessThan(String value) {
            addCriterion("receiveAddress <", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLessThanOrEqualTo(String value) {
            addCriterion("receiveAddress <=", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLike(String value) {
            addCriterion("receiveAddress like", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotLike(String value) {
            addCriterion("receiveAddress not like", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIn(List<String> values) {
            addCriterion("receiveAddress in", values, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotIn(List<String> values) {
            addCriterion("receiveAddress not in", values, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressBetween(String value1, String value2) {
            addCriterion("receiveAddress between", value1, value2, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotBetween(String value1, String value2) {
            addCriterion("receiveAddress not between", value1, value2, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Integer value) {
            addCriterion("payType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Integer value) {
            addCriterion("payType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Integer value) {
            addCriterion("payType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Integer value) {
            addCriterion("payType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("payType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Integer> values) {
            addCriterion("payType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Integer> values) {
            addCriterion("payType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Integer value1, Integer value2) {
            addCriterion("payType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payType not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeIsNull() {
            addCriterion("deliverType is null");
            return (Criteria) this;
        }

        public Criteria andDelivertypeIsNotNull() {
            addCriterion("deliverType is not null");
            return (Criteria) this;
        }

        public Criteria andDelivertypeEqualTo(Integer value) {
            addCriterion("deliverType =", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeNotEqualTo(Integer value) {
            addCriterion("deliverType <>", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeGreaterThan(Integer value) {
            addCriterion("deliverType >", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliverType >=", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeLessThan(Integer value) {
            addCriterion("deliverType <", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeLessThanOrEqualTo(Integer value) {
            addCriterion("deliverType <=", value, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeIn(List<Integer> values) {
            addCriterion("deliverType in", values, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeNotIn(List<Integer> values) {
            addCriterion("deliverType not in", values, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeBetween(Integer value1, Integer value2) {
            addCriterion("deliverType between", value1, value2, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deliverType not between", value1, value2, "delivertype");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIsNull() {
            addCriterion("deliverTime is null");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIsNotNull() {
            addCriterion("deliverTime is not null");
            return (Criteria) this;
        }

        public Criteria andDelivertimeEqualTo(Date value) {
            addCriterion("deliverTime =", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotEqualTo(Date value) {
            addCriterion("deliverTime <>", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeGreaterThan(Date value) {
            addCriterion("deliverTime >", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deliverTime >=", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeLessThan(Date value) {
            addCriterion("deliverTime <", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeLessThanOrEqualTo(Date value) {
            addCriterion("deliverTime <=", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIn(List<Date> values) {
            addCriterion("deliverTime in", values, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotIn(List<Date> values) {
            addCriterion("deliverTime not in", values, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeBetween(Date value1, Date value2) {
            addCriterion("deliverTime between", value1, value2, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotBetween(Date value1, Date value2) {
            addCriterion("deliverTime not between", value1, value2, "delivertime");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(BigDecimal value) {
            addCriterion("totalPrice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(BigDecimal value) {
            addCriterion("totalPrice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(BigDecimal value) {
            addCriterion("totalPrice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalPrice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(BigDecimal value) {
            addCriterion("totalPrice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalPrice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<BigDecimal> values) {
            addCriterion("totalPrice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<BigDecimal> values) {
            addCriterion("totalPrice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalPrice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalPrice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceIsNull() {
            addCriterion("cutDownPrice is null");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceIsNotNull() {
            addCriterion("cutDownPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceEqualTo(BigDecimal value) {
            addCriterion("cutDownPrice =", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceNotEqualTo(BigDecimal value) {
            addCriterion("cutDownPrice <>", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceGreaterThan(BigDecimal value) {
            addCriterion("cutDownPrice >", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cutDownPrice >=", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceLessThan(BigDecimal value) {
            addCriterion("cutDownPrice <", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cutDownPrice <=", value, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceIn(List<BigDecimal> values) {
            addCriterion("cutDownPrice in", values, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceNotIn(List<BigDecimal> values) {
            addCriterion("cutDownPrice not in", values, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cutDownPrice between", value1, value2, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andCutdownpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cutDownPrice not between", value1, value2, "cutdownprice");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(BigDecimal value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(BigDecimal value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(BigDecimal value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(BigDecimal value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<BigDecimal> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<BigDecimal> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andActualpriceIsNull() {
            addCriterion("actualPrice is null");
            return (Criteria) this;
        }

        public Criteria andActualpriceIsNotNull() {
            addCriterion("actualPrice is not null");
            return (Criteria) this;
        }

        public Criteria andActualpriceEqualTo(BigDecimal value) {
            addCriterion("actualPrice =", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceNotEqualTo(BigDecimal value) {
            addCriterion("actualPrice <>", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceGreaterThan(BigDecimal value) {
            addCriterion("actualPrice >", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actualPrice >=", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceLessThan(BigDecimal value) {
            addCriterion("actualPrice <", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actualPrice <=", value, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceIn(List<BigDecimal> values) {
            addCriterion("actualPrice in", values, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceNotIn(List<BigDecimal> values) {
            addCriterion("actualPrice not in", values, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualPrice between", value1, value2, "actualprice");
            return (Criteria) this;
        }

        public Criteria andActualpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualPrice not between", value1, value2, "actualprice");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeIsNull() {
            addCriterion("updaetTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeIsNotNull() {
            addCriterion("updaetTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeEqualTo(Date value) {
            addCriterion("updaetTime =", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeNotEqualTo(Date value) {
            addCriterion("updaetTime <>", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeGreaterThan(Date value) {
            addCriterion("updaetTime >", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updaetTime >=", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeLessThan(Date value) {
            addCriterion("updaetTime <", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeLessThanOrEqualTo(Date value) {
            addCriterion("updaetTime <=", value, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeIn(List<Date> values) {
            addCriterion("updaetTime in", values, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeNotIn(List<Date> values) {
            addCriterion("updaetTime not in", values, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeBetween(Date value1, Date value2) {
            addCriterion("updaetTime between", value1, value2, "updaettime");
            return (Criteria) this;
        }

        public Criteria andUpdaettimeNotBetween(Date value1, Date value2) {
            addCriterion("updaetTime not between", value1, value2, "updaettime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}