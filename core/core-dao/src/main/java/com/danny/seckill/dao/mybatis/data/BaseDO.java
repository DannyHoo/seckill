package com.danny.seckill.dao.mybatis.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-31 10:49:16
 */
public class BaseDO implements Serializable {
    protected static final long serialVersionUID = 2429073401643038863L;

    private Long id;
    private String comment;
    private Date createtime;
    private Date updatetime;

    public Long getId() {
        return id;
    }

    public BaseDO setId(Long id) {
        this.id = id;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getComment() {
        return comment;
    }

    public BaseDO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public BaseDO setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public BaseDO setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
        return this;
    }

}
