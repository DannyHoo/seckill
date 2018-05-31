package com.danny.seckill.model.param;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseParameter
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:45:41
 */
public class BaseParameter implements Serializable {
    private static final long serialVersionUID = 2429073401643038863L;

    private Long id;
    private String comment;
    private Date createtime;
    private Date updatetime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public BaseParameter setId(Long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public BaseParameter setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public BaseParameter setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public BaseParameter setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
        return this;
    }
}
